package Utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageLoaderUtils {
	private ArrayList<BufferedImage> mOriginalImageList;
	private ArrayList<BufferedImage> mScaledImageList;
	private int mMaxWidth = 0;
	private int mMaxHeight = 0;

	public ImageLoaderUtils() {
		mOriginalImageList = new ArrayList<>();
	}

	public ImageLoaderUtils(File pFile) {
		mOriginalImageList = new ArrayList<>();
		if(pFile.isFile() && !pFile.isHidden())
		{
			try{
				mOriginalImageList.add(ImageIO.read(pFile));
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else if(pFile.isDirectory())
		{
			try{
				for(File currentImage : pFile.listFiles())
				{
					System.out.println(currentImage.getPath());
					if(ImageIO.read(currentImage) == null || pFile.isHidden())
					{
					}
					else
					{
						mOriginalImageList.add(ImageIO.read(currentImage));
					}
					
					
				}
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			scaleImages();
		}
	}
	
	public ArrayList<BufferedImage> getUnalteredImages()
	{
		return mOriginalImageList;
	}
	
	public BufferedImage getUnalteredImage(int pIndex)
	{
		if(pIndex < mOriginalImageList.size())
		{
			return mOriginalImageList.get(pIndex);
		}
		return null;
		
	}
	
	public int getDirectorySize()
	{
		return mOriginalImageList.size();
	}
	
	private void scaleImages()
	{
		mScaledImageList = new ArrayList<>(mOriginalImageList.size());
		for(int i = 0; i < mOriginalImageList.size(); i++)
		{
			BufferedImage before = mOriginalImageList.get(i);
			int w = before.getWidth();
			int h = before.getHeight();
			BufferedImage after = new BufferedImage(94, 94, BufferedImage.TYPE_INT_ARGB);
			AffineTransform at = new AffineTransform();
			at.scale(94.0 / w, 94.0 / w);
			AffineTransformOp scaleOp = 
			   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			mScaledImageList.add(scaleOp.filter(before, after));
		}
	}
	
	public BufferedImage getScaledImage(int pIndex)
	{
		return mScaledImageList.get(pIndex);
	}

}

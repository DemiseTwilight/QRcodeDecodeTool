package com.demiseTwilight.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageSegmentation {
	
	public static List<BufferedImage> segmentationAvg9Selec1(BufferedImage image){
		int height=image.getHeight();
		int width=image.getWidth();
		
		List<BufferedImage> reslut=new ArrayList<BufferedImage>();
		reslut.add(image.getSubimage(0, 0, width/3,height/3));
		reslut.add(image.getSubimage(width/3, 0, width/3,height/3));
		reslut.add(image.getSubimage((width/3)*2, 0, width/3,height/3));
		reslut.add(image.getSubimage(0, height/3, width/3,height/3));
		reslut.add(image.getSubimage(width/3, height/3, width/3,height/3));
		reslut.add(image.getSubimage((width/3)*2, height/3, width/3,height/3));
		reslut.add(image.getSubimage(0, (height/3)*2, width/3,height/3));
		reslut.add(image.getSubimage(width/3, (height/3)*2, width/3,height/3));
		reslut.add(image.getSubimage((width/3)*2, (height/3)*2, width/3,height/3));
		
		return reslut;
		
	}
	
	public static List<BufferedImage> segmentationAvg9Selec4(BufferedImage image){
		int height=image.getHeight();
		int width=image.getWidth();
		
		List<BufferedImage> reslut=new ArrayList<BufferedImage>();
		reslut.add(image.getSubimage(0, 0, (width/3)*2,(height/3)*2));
		reslut.add(image.getSubimage(width/3, 0, (width/3)*2,(height/3)*2));
		reslut.add(image.getSubimage(0, height/3, (width/3)*2,(height/3)*2));
		reslut.add(image.getSubimage(width/3, height/3, (width/3)*2,(height/3)*2));
		return reslut;
		
	}
}

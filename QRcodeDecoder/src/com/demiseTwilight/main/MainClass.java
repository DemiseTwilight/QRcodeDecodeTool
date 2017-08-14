package com.demiseTwilight.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import com.demiseTwilight.ImageUtil.ImageSegmentation;
import com.demiseTwilight.decoder.DecodeImgZxing;

public class MainClass {

	public static void main(String[] args) throws IOException {
		//生成测试：
//		File file=new File("E:/document/qrcode.png");
//		EncodeImgZxing.writeToFile("测试数据", "png", file);
		
		//识别测试：
//		File file=new File("E:/document/测试用二维码/c77da2958b4068e916b57f660e11bae2 (SH +100%).jpg");
//		System.out.println(args.length);
		for(String arg :args){
			System.out.println(arg);
			File file=new File(arg);
			 if(!file.isFile()){  
		            System.out.println("输入格式错误");  
		            return;  
		        }
			BufferedImage image = ImageIO.read(file);
			//整体识别：
			List<String> bufferList=new ArrayList<String>();   //临时列表
			HashSet<String> result=new HashSet<String>();		//结果列表
			bufferList=DecodeImgZxing.decodeImg(image);
//			System.out.println("整体识别："+bufferList);
			result.addAll(bufferList);
			//分割1：
			List<BufferedImage> image9s=ImageSegmentation.segmentationAvg9Selec4(image);
			for(int i=0;i<image9s.size();i++){
				ImageIO.write(image9s.get(i), "jpg", new File("E:/document/测试用二维码/分割"+(i+1)+".jpg"));
				//分割识别：
				bufferList=DecodeImgZxing.decodeImg(image9s.get(i));
				System.out.println("分割"+(i+1)+bufferList);
				result.addAll(bufferList);
			}
			//分割2：
			image9s=ImageSegmentation.segmentationAvg9Selec1(image);
			for(int i=0;i<image9s.size();i++){
				ImageIO.write(image9s.get(i), "jpg", new File("E:/document/测试用二维码/分割"+(i+1)+".jpg"));
				//分割识别：
				bufferList=DecodeImgZxing.decodeImg(image9s.get(i));
				System.out.println("分割"+(i+1)+bufferList);
				result.addAll(bufferList);
			}
			
			System.out.println("输出结果："+result);
			//输出：
			for(String resultString : result){
				int i=1;
				System.out.println((i++)+"."+resultString);
			}
		}
	}

}

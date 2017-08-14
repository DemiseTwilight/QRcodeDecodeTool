package com.demiseTwilight.decoder;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import com.demiseTwilight.zxingClient.BufferedImageLuminanceSource;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;

/** 
 * 通过google的zxing解析二维码 
 * 注：此代码，不能解析：L纠错级别带logo和H级别的解析 
 * */  
public final class DecodeImgZxing {  
    //二维码格式参数  
    private static final EnumMap<DecodeHintType, Object> hints = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);  
    static{  
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(DecodeHintType.TRY_HARDER, true);
    }  
    /** 
     * 解析二维码，使用google的zxing 
     * @param imgPath 二维码路径 
     * @return content 二维码内容 
     * */  
    public static List<String> decodeImg(BufferedImage image){  
        List<String> content = new ArrayList<String>();  
        try {  
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
            QRCodeMultiReader reader = new QRCodeMultiReader();  
            Result result[] = reader.decodeMultiple(binaryBitmap, hints);
            for(int i=0;i<result.length;i++){
                content.add(result[i].getText());
            }
        } catch (NotFoundException e) {  
//            System.out.println("QRcode NotFoundException");  
//            e.printStackTrace();  
        }  
        return content;  
    }  
}  
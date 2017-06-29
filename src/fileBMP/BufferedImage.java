package fileBMP;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class BufferedImage extends java.awt.image.BufferedImage {
	private int width;
	private int height;
	private int imageType;
	
	
	private int getWidth(){
		return width;
	}
	
	private int getHeight(){
		return height;
	}
	
	private int getType(){
		return imageType;
	}
	
	public BufferedImage(int width, int height, int imageType) {
		super(width, height, imageType);
		// TODO Auto-generated constructor stub
	}
	
	 private String image_path(String path, String name, String ext){
		 return path + "/" + name + "." + ext;
	 }


	private BufferedImage user_space(BufferedImage image){
		BufferedImage new_img  = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
	    Graphics2D    graphics   = new_img.createGraphics();
	    graphics.drawRenderedImage(image, null);
	    graphics.dispose();
	    return new_img;
	}


}

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageReader {
	public CharImageArray readCharImage(int ascii) throws IOException {
		BufferedImage image = ImageIO.read(new FileInputStream("res/Image"+ascii+".png"));

		return new CharImageArray(image, (char) ascii);
	}
	
	public ImageArray readImage(String filename) throws IOException {
		BufferedImage image = ImageIO.read(new FileInputStream(filename));

		return new ImageArray(image);
	}
}

class CharImageArray{

	char ch;
	int[][] data;
	int height;
	int width;
	
	public CharImageArray(BufferedImage image, char ch) {
		height = image.getHeight();
		width = image.getWidth();
		data = new int[height][width];
		for (int yPixel = 0; yPixel < height; yPixel++)
		{
			for (int xPixel = 0; xPixel < width; xPixel++)
			{
				int color = image.getRGB(xPixel, yPixel);
				if(color==0xff000000){
					data[yPixel][xPixel] = 0x00000000;
				}
				else{
					data[yPixel][xPixel] = 0x00ffffff;
				}
			}
		}
		this.ch = ch;
	}
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<height;i++){
			sb.append(Arrays.toString(data[i])+"\n");
		}
		return sb.toString();
	}
}

class ImageArray{
	
	int[][] data;
	int height;
	int width;
	
	public ImageArray(BufferedImage image){
		height = image.getHeight();
		width = image.getWidth();
		data = new int[height][width];
		for (int yPixel = 0; yPixel < height; yPixel++)
		{
			for (int xPixel = 0; xPixel < width; xPixel++)
			{
				int color = image.getRGB(xPixel, yPixel);
				int a = (color & 0xff000000) >> 24;
				int r = (color & 0x00ff0000) >> 16;
				int g = (color & 0x0000ff00) >> 8;
				int b = (color & 0x000000ff);
//				if(r+g+b<255*3/2){
//					data[yPixel][xPixel] = 0x00000000;
//				}
//				else{
//					data[yPixel][xPixel] = 0x00ffffff;
//				}
				data[yPixel][xPixel] = color & 0x00ffffff;
			}
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<height;i++){
			sb.append(Arrays.toString(data[i])+"\n");
		}
		return sb.toString();
	}
}
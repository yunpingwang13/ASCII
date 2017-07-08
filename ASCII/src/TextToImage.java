import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class TextToImage {
	
	static final int fontSize = 5;
	String fontName = "Consolas";
	String sampleCharString = "@";
	int width,height;
	Graphics2D g2d;
	Font font;
	
	public TextToImage(int fs){
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        font = new Font(fontName, Font.PLAIN, fs);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        width = fm.stringWidth(sampleCharString);
        height = fm.getHeight();
        g2d.dispose();
	}
	
	public TextToImage(){
		this(fontSize);
	}
	
	public List<CharImage> convert(List<Character> chs){
		
		List<CharImage> result = new ArrayList<CharImage>();
		for(Character ch : chs){
	        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        g2d = img.createGraphics();
//	        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
//	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//	        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
//	        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//	        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//	        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	        g2d.setFont(font);
	        FontMetrics fm = g2d.getFontMetrics();
	        g2d.setColor(Color.BLACK);
	        g2d.drawString(Character.toString(ch), 0, fm.getAscent());
	        g2d.dispose();
	        result.add(new CharImage(img,ch));
		}
        
        return result;
	}
	
	public void writeToFile(List<CharImage> imgList){
		for(CharImage img : imgList){
			try {
				File f = new File("res/Image"+Integer.toString((int)img.ch)+".png");
				ImageIO.write(img.image, "png", f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class CharImage{
	
	BufferedImage image;
	char ch;
	
	public CharImage(BufferedImage image, char ch){
		this.image = image;
		this.ch = ch;
	}
	
}
import java.io.IOException;

public class ImageReaderTester {
	
	public static void main(String[] args){
		ImageReader reader = new ImageReader();
		try {
			System.out.println(reader.readImage("jimmy_normal.bmp"));
		} catch (IOException e) {
		}
	}

}

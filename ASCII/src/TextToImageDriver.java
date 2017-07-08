import java.util.ArrayList;
import java.util.List;


public class TextToImageDriver {
	
	public static void main(String[] args){
		
		int start = 33;
		int end = 126;
		
		TextToImage tti = new TextToImage();
		List<Character> chs = new ArrayList<Character>();
		for(int i = start;i<=end;i++){
			chs.add((char)i);
		}
		List<CharImage> lst = tti.convert(chs);
		tti.writeToFile(lst);
	}

}

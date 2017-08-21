package program;

import java.util.ArrayList;

import pageObjects.Converter;
import pageObjects.Youtube;
import utils.Driver;

public class Program {
	
	private static ArrayList<String> songsList = new ArrayList<String>();
	public static String songName;
	
	public static void main(String[] args) {	
		System.setProperty("webdriver.gecko.driver", utils.DriverLocation.webdriverFolder);				
		Youtube youtubePage = new Youtube(Driver.driver, Driver.wait);
		Converter converterPage = new Converter(Driver.driver, Driver.wait);
		
		songsList.add("Mama Cass - Dream a little dream of me"); // for testing purposes; to be implemented read from file list
		
		for (int i = 0; i < songsList.size(); i++){
			songName = songsList.get(i);
			
			youtubePage.OpenYoutube();
			youtubePage.FindVideo();
			youtubePage.OpenVideo();
			youtubePage.CopyURL();
			
			converterPage.OpenConverter();
			converterPage.EnterURL();
			converterPage.DownloadVideo();			
		}
		
	}
}

package program;

import java.util.ArrayList;

import pageObjects.Converter;
import pageObjects.Youtube;
import utils.Driver;
import utils.ReadFromFile;

public class Program {
	
	public static ArrayList<String> songsList = new ArrayList<String>();
	public static String songName;
	
	public static void main(String[] args) throws InterruptedException {	
		//System.setProperty("webdriver.gecko.driver", utils.DriverLocation.webdriverFirefox);				
		System.setProperty("webdriver.chrome.driver", utils.DriverLocation.webdriverChrome);
		
		Youtube youtubePage = new Youtube(Driver.driver, Driver.wait);
		Converter converterPage = new Converter(Driver.driver, Driver.wait);
		String songlist = System.getProperty("user.home") + "\\Desktop\\" + "songlist.txt";
		
		ReadFromFile.ReadFromFile(songlist);
		
		youtubePage.OpenYoutube();
		
		for (int i = 0; i < songsList.size(); i++){
			songName = songsList.get(i);

			youtubePage.FindVideo(songName);
			Thread.sleep(3000);
			youtubePage.OpenVideo();
			Thread.sleep(3000);
			youtubePage.CopyURL();
			
			Thread.sleep(3000);
			converterPage.OpenConverter();
			Thread.sleep(2000);
			converterPage.EnterURL(youtubePage.videoURL);
			Thread.sleep(5000);
			converterPage.DownloadVideo();	
			
			youtubePage.OpenYoutube();
		}
		Driver.driver.quit();
		System.out.println("Done!");		
	}
}

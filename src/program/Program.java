package program;

import java.io.File;
import java.util.ArrayList;

import Graphics.TopLevelWindow;
import pageObjects.Converter;
import pageObjects.Youtube;
import utils.Driver;
import utils.ReadFromFile;

public class Program {
	
	public static ArrayList<String> songsList = new ArrayList<String>();
	public static String songName;
	

	
	public static void main(String[] args) throws InterruptedException {	
		TopLevelWindow.createWindow();			
	}
	
	public static void downloadVideos() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", utils.DriverLocation.webdriverChrome);
		
		Youtube youtubePage = new Youtube(Driver.driver, Driver.wait);
		Converter converterPage = new Converter(Driver.driver, Driver.wait);
		
		// Create a list of the songs to search for
		String songlist = System.getProperty("user.home") + "\\Desktop\\" + "songlist.txt";
	
		File songs = new File(songlist);
		if(songs.exists() && !songs.isDirectory()) { 
			// Read songs list into an arraylist
			ReadFromFile.ReadFile(songlist);
			
			youtubePage.OpenYoutube();
			
			for (int i = 0; i < songsList.size(); i++){
				songName = songsList.get(i);

				youtubePage.FindVideo(songName);
				youtubePage.OpenVideo();
				youtubePage.CopyURL();
				converterPage.OpenConverter();
				converterPage.EnterURL(youtubePage.videoURL);
				converterPage.DownloadVideo();	
				
				// Check if last song on list
				if (i == (songsList.size() - 1)){
					// If last song on list, wait for download to finish before closing the browser
					converterPage.CheckIfDownloadFinished();
				}
				
				youtubePage.OpenYoutube();
			}
		} else {
			System.out.println("File not found!");	
		}
			
		Driver.driver.quit();
		TopLevelWindow.CloseWindow(TopLevelWindow.frame);
		System.out.println("Done!");
	}
}

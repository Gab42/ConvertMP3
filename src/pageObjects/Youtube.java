package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Youtube extends utils.Driver{
		public Youtube(WebDriver Driver, WebDriverWait Wait){
			super();
		}	
		
		private List<WebElement> videoList(){
			return driver.findElements(By.className("test"));
		}
		
		public void OpenYoutube(){
			
		}
		
		public void FindVideo(){
			
		}
		
		public void OpenVideo(){
			
		}
		
		public void CopyURL(){
			
		}
}

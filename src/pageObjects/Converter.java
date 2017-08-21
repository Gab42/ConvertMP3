package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Converter extends utils.Driver {
	public Converter(WebDriver Driver, WebDriverWait Wait){
		super();
	}
	
	private WebElement txtBox_test(){
		return driver.findElement(By.id("test"));	
	}
	
	public void OpenConverter(){
		
	}
	
	public void EnterURL(){
		
	}
	
	public void DownloadVideo(){
		
	}
}

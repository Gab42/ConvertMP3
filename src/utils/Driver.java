package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	public static WebDriver driver = new ChromeDriver();
	public static WebDriverWait wait = new WebDriverWait(driver, 10);
}

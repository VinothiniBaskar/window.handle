package window.handle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//print the windlow handle for active browser (parent window) 
		String parentWindow = driver.getWindowHandle();
		//print the value for parent window -->113055F913C04331F1EF4ADA576301DE
		
		//The parent window valaue is CDwindow-B16A810FD7E20853BF3418E9C2645319
		System.out.println("The parent window valaue is "+parentWindow);
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		String childWindow = driver.getWindowHandle();
		//here we are switching the control to new window(child window)
		driver.switchTo().window(childWindow);
		//We didn't switch the browser control so it is getting same string value
		//print the value for parent window -->113055F913C04331F1EF4ADA576301DE
		//After use the switch to comment the string value is -->B16A810FD7E20853BF3418E9C2645319
		System.out.println("The child window value is "+childWindow);
	}

}

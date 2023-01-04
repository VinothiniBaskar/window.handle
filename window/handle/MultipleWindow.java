package window.handle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//It is only for one window
		String parentWindow = driver.getWindowHandle();
		System.out.println("The string value of parent window is " + parentWindow);
		String parentTitle = driver.getTitle();
		System.out.println("The title of parent window is " + parentTitle);
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		String title1 = driver.getTitle();
		System.out.println(title1);
		//close the current window -->child window
		driver.close();
		
		//close the parent  window -->parent window
		driver.switchTo().window(handles.get(0));
		driver.close();
		//IF you want to close all the child window but parent window remains same

	}

}

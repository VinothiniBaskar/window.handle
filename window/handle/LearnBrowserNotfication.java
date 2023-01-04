package window.handle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnBrowserNotfication {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement element = driver.findElement(By.xpath("//a[text()='mom & baby']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(element).perform();
		
		driver.findElement(By.xpath("//a[text()='Baby Oil']")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.partialLinkText("Cetaphil Baby Massage ")).click();
		String text = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']//span[2]")).getText();
		System.out.println("The price of the product  before is :"+text);
		String str=text.replaceAll("[^0-9]", "");
		System.out.println("The price of the product after  is :"+str);
		
		for (String eachWindow : handles) {
			if (!windowHandles.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
				driver.close();
			}
		}

		
	}

}

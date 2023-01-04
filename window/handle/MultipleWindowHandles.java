package window.handle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandles {

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
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		// use the getWindowHandles method and store it as the set of string type
		//It is for multiple window
		Set<String> windowHandles = driver.getWindowHandles();
		// Convert the set into list for accessing the particular new window
		// by using index -->0 =parent window 1=child window1 2=childwindow2
		List<String> handles = new ArrayList<String>(windowHandles);
		//Move the control to particular new window
		driver.switchTo().window(handles.get(1));
		System.out.println("The string value of child window1 is " + handles);
		//Print the title
		String childTitle = driver.getTitle();
		System.out.println("The title of child window1 is " + childTitle);

		// verfiy the title
		if (parentTitle.equals(childTitle)) {
			System.out.println("Controls stays in same page");

		} else {
			System.out.println("Controls has switched to  new window");
		}
		             
		

	}

}

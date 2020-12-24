package windowShift;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShiftToAnotherWindow {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		String homepage = driver.getWindowHandle();
		System.out.println(homepage);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[13]/div[2]/div[3]/div/div/div[2]/div/div/div/div/marquee/a[1]")).click();
		
//		String popPage = driver.getWindowHandle();
//		System.out.println(popPage);
		
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		
		Iterator it = windows.iterator();
		String currentWindowId;
		while(it.hasNext())
		{
			currentWindowId = it.next().toString();
			System.out.println(currentWindowId);	
			if(!(currentWindowId.equals(homepage)))
			{
				driver.switchTo().window(currentWindowId);
				System.out.println("Window shifted");
			}
		}
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.close();
		driver.quit();
	}
}

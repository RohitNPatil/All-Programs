package AmazonPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MobileSearch 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\selenium chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		
		Actions act= new Actions(driver);
		WebElement Account=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		act.moveToElement(Account).perform();
		
		WebElement Signin=driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
		act.click(Signin).perform();
		System.out.println("Sign in button clicked");
		
		
		WebElement username=driver.findElement(By.xpath("(//html//input)[7]"));
		act.sendKeys("rohit.jadhav3198@gmail.com").perform();
		System.out.println("Username entered");

		
		WebElement Continue=driver.findElement(By.xpath("//input[@id='continue']"));
		act.click(Continue).perform();
		
		WebElement Password=driver.findElement(By.xpath("//input[@type='password']"));
		act.sendKeys("Rohitpatil").perform();
		System.out.println("Password Entered");

		
		WebElement Sign=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		act.click(Sign).perform();
		
		WebElement textbox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		textbox.sendKeys("mobiles");
//		act.click().sendKeys("mobiles").perform();
		System.out.println("Mobile enetred in textbox");
	
		WebElement Search=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Search.click();
		
		WebElement selectmobile=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
		
		selectmobile.click();
		
		String mainpageaddress = driver.getWindowHandle();
		
		System.out.println(mainpageaddress);
		
//	    Set<String> address = driver.getWindowHandles();
//		
//		System.out.println(address);
		
	    List<String> Allpageaddress = new ArrayList<String>(driver.getWindowHandles());		
		System.out.println(Allpageaddress);
		
		driver.switchTo().window(Allpageaddress.get(1));
		
		WebElement addtocart=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		
		addtocart.click();
		
		WebElement cart=driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input"));
		cart.click();
		
	}

}

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class MyFirst {

	public static void main(String[] args) {
		
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\MyChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver.get("https://www.saucedemo.com/");
		
		String userName = "standard_user";
		String password = "secret_sauce";
		
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		int expectedItemsAdded = 10;
		
		List<WebElement> myButtons = driver.findElements(By.className("btn"));
		
		for(int i=0;i<myButtons.size();i++) {
			myButtons.get(i).click();
		}
		
		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
		
		int Real = Integer.parseInt(actualItemsAdded);
		Assert.assertEquals(Real, expectedItemsAdded);
		System.out.println(actualItemsAdded);

	}

}

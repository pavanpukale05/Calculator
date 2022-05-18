package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculator extends utility{
	WebDriver driver;
	Actions act;
	@BeforeMethod
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.calculator.net/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		act = new Actions(driver);


	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test(priority=1)
	public void multiplication() {
		String n1 = "423";
		String n2 = "525";

		String expectedResult = " 222075";

		utility.direct1(driver,n1);

		driver.findElement(By.xpath("//span[normalize-space()='×']")).click();

		utility.direct2(driver, n2);

		driver.findElement(By.xpath("//span[normalize-space()='=']")).click();
		String txt = driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Assert.assertEquals(txt, expectedResult,"Not Match");

	}

	@Test(priority=2)
	public void division() {
		String n1 = "4000";
		String n2 = "200";

		String expectedResult = " 20";

		utility.direct1(driver,n1);

		driver.findElement(By.xpath("//span[normalize-space()='/']")).click();

		utility.direct2(driver, n2);

		driver.findElement(By.xpath("//span[normalize-space()='=']")).click();
		String txt = driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Assert.assertEquals(txt, expectedResult,"Not Match");

	}

	@Test(priority=3)
	public void addition() {
		String n1 = "234234";
		String n2 = "345345";

		String expectedResult = " 111111";

		driver.findElement(By.xpath("//span[contains(text(),'–')]")).click();

		utility.direct1(driver,n1);

		driver.findElement(By.xpath("//span[contains(text(),'+')]")).click();

		utility.direct2(driver, n2);

		driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();
		String txt = driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Assert.assertEquals(txt, expectedResult,"Not Match");

	}

	@Test(priority=4)
	public void subtraction() {
		String n1 = "234823";
		String n2 = "23094823";

		String expectedResult = " 23329646";

		utility.direct1(driver,n1);

		driver.findElement(By.xpath("(//span[contains(text(),'–')])[1]")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'–')])[1]")).click();


		utility.direct2(driver, n2);

		driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();
		String txt = driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Assert.assertEquals(txt, expectedResult,"Not Match");

	}


}

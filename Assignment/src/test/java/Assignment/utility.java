package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utility {
	String n1,n2;
	static WebDriver driver;
	
		public static void direct1(WebDriver driver, String n1) {

			
			
			List<WebElement> list = driver.findElements(By.xpath("//div[@style='padding-top:3px;']//span"));
			
			for(int j = 0;j<n1.length();j++) {
				for(int i = 0;i<list.size();i++) {
					String li = list.get(i).getText();
					char a = n1.charAt(j);
					if(Character.toString(a).equals(li)) {
						driver.findElement(By.xpath("//div[@style='padding-top:3px;']//span[@onclick='r("+Character.toString(a)+")']")).click();
						
					}
				}
				
			}
			//driver.findElement(By.xpath("//span[normalize-space()='×']")).click();
		}
			
			public static void direct2(WebDriver driver,String n2) {
				List<WebElement> list = driver.findElements(By.xpath("//div[@style='padding-top:3px;']//span"));
				for(int j = 0;j<n2.length();j++) {
					for(int i = 0;i<list.size();i++) {
						String li = list.get(i).getText();
						char a = n2.charAt(j);
						if(Character.toString(a).equals(li)) {
							driver.findElement(By.xpath("//div[@style='padding-top:3px;']//span[@onclick='r("+Character.toString(a)+")']")).click();
							
						}
					}
					
				}
				
			}
		



}

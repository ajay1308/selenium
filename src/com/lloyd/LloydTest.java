package com.lloyd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The Class LloydTest.
 * 
 * Selenium test suite
 * 
 * @author Ajay
 */
public class LloydTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String args[]) throws Exception {

		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/welcome");

		Thread.sleep(2000);
		//Test case 1 - both empty
		driver.findElement(By.xpath("html/body/form/p[5]/input[1]")).click();
		if (driver.findElement(By.xpath("html/body/form/p[2]")).getText().equals("Name is required field") 
				&& driver.findElement(By.xpath("html/body/form/p[4]")).getText().equals("Email is required field")) {
			System.out.println("test 1 passed");
		}

		//Test case 2 - email empty
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("abc");
		driver.findElement(By.xpath("html/body/form/p[5]/input[1]")).click();
		if (driver.findElement(By.xpath("html/body/form/p[4]")).getText().equals("Email is required field")) {
			System.out.println("test 2 passed");
		}
	
		//Test case 3 - Subscription failure
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("abc");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("abc");

		driver.findElement(By.xpath("html/body/form/p[5]/input[1]")).click();

		if (driver.findElement(By.xpath("html/body/p")).getText().equals("User not subscribed")) {
			System.out.println("test 3 passed");
		}
		driver.findElement(By.xpath("html/body/a")).click();

		//Test case 4 - Subscription Success
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("abc");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("abc@abs.com");

		driver.findElement(By.xpath("html/body/form/p[5]/input[1]")).click();

		if (driver.findElement(By.xpath("html/body/p")).getText().equals("User successfully subscribed")) {
			System.out.println("test 4 passed");
		}
		driver.findElement(By.xpath("html/body/a")).click();

		//Test case 5 - name empty
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("abc");
		driver.findElement(By.xpath("html/body/form/p[5]/input[1]")).click();
		if (driver.findElement(By.xpath("html/body/form/p[2]")).getText().equals("Name is required field")) {
			System.out.println("test 5 passed");
		}
		
		driver.close();

	}

}

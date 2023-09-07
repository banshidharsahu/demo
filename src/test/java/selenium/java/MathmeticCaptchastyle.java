package selenium.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MathmeticCaptchastyle

{
	WebDriver driver;

	@BeforeMethod
	public void steup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		/// below chromeOption step we used incase of test chrome used for automation testing scritpt
		ChromeOptions option = new ChromeOptions();
		option.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://form.jotform.com/73302671092956");
		Thread.sleep(1000);
	}

	@Test
	public void mathcaptcha() throws InterruptedException

	{

		driver.findElement(By.xpath("(//button[@class='jfWelcome-button'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(1000);

		/// Number get from captcha but before in this case have iframe then should swich first iframe then take captcha
		/// if don't have iframe then directly take captcha

		driver.switchTo().frame(0);

		/// first num ber I am taking
		String str = driver.findElement(By.xpath("(//ul[@class='captcha']//li[2]//p//span)[1]")).getText();
		/// symbol I am taking as string
		String str1 = driver.findElement(By.xpath("(//ul[@class='captcha']//li[2]//p//span)[2]")).getText();
		/// second number I am taking
		String str2 = driver.findElement(By.xpath("(//ul[@class='captcha']//li[2]//p//span)[3]")).getText();

		/// convert string value to int
		int first = Integer.valueOf(str);

		/// second string converted to int
		int second = Integer.valueOf(str2);

		/// Add or subscration or multiplication or dividation dynamically process for validate captcha

		if (str1.equals("x")) {
			int multipleresult = first * second;
			/// convert int value to string as I want to send it in sendkeys
			String valueconverted1 = String.valueOf(multipleresult);
			System.out.println(multipleresult);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='result']")).sendKeys(valueconverted1);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();

		}
		if (str1.equals("+")) {
			int addresult = first + second;
			System.out.println(addresult);
			String valueconverted2 = String.valueOf(addresult);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='result']")).sendKeys(valueconverted2);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		}
		if (str1.equals("-")) {
			int minusresult = first - second;
			System.out.println(minusresult);
			String valueconverted3 = String.valueOf(minusresult);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='result']")).sendKeys(valueconverted3);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		}
		if (str1.equals("÷")) {
			int divistion = first / second;
			System.out.println(divistion);
			String valueconverted4 = String.valueOf(divistion);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='result']")).sendKeys(valueconverted4);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		}

	}

	@AfterMethod
	public void close() {
		// driver.quit();
	}

}

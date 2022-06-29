package pc01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_page {

	public static int iBrowserType = 1; // 1-Chrome,2-FF,3-Edge
	public static String sURL = "https://ph-uat.peerconnexions.com/";
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		invokeBrowser();
		windowSettings();
		navigateURL();
		getPageInfo();
		login();
		sellerszone();
		daterange();
		numberoforg();
	

	}

	public static void invokeBrowser() {

		switch (iBrowserType) {
		case 1:
			System.out.println("User option is " + iBrowserType + ",So invoking Chrome browser!!!");
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is " + iBrowserType + ",So invoking Firefox browser!!!");
			System.setProperty("webdriver.gecko.driver", "D:\\selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User option is " + iBrowserType + ",So invoking Edge browser!!!");
			System.setProperty("webdriver.edge.driver", "D:\\selenium\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("User option is wrong " + iBrowserType + ",So invoking default Chrome browser!!!");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}

	public static void windowSettings() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public static void navigateURL() {
		driver.get(sURL);

	}

	public static void getPageInfo() throws Exception {
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Page Title is : " + title);
		System.out.println("Page URL is : " + currentUrl);
		System.out.println("Seller Dashboard");
	}

	public static void login() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[1]/div/div/div[9]/a/span[1]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Deepa+Seller@openspaceservices.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Round@123");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();
		System.out.println("1.User Loggedin Successfully");
	}

	public static void sellerszone() throws Exception {
		System.out.println("2.Selecting Sellerzone");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div/div/div[2]/div/nav/div/ul/li[5]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/header[2]/div/div[2]/div/div/div[2]/div/nav/div/ul/li[5]/div/button[3]/a/span")).click();
	}
	public static void daterange() throws Exception {
//Start date
		 driver.findElement(By.xpath("//*[@id=\'root\']/div[3]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/span/span/input[2]")).click();
	        WebElement startdatelogin =driver.findElement(By.cssSelector("#document-body > div:nth-child(11) > div > div > div > div > div.ant-calendar-date-panel > div.ant-calendar-range-part.ant-calendar-range-left > div.ant-calendar-input-wrap > div > input"));
	        startdatelogin.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	        startdatelogin.sendKeys(Keys.BACK_SPACE);
	        startdatelogin.sendKeys("05-12-2019"+Keys.ENTER);
	        
//End Date	        
	        Thread.sleep(2000);
	        WebElement enddatelogin =driver.findElement(By.cssSelector("#document-body > div:nth-child(11) > div > div > div > div > div.ant-calendar-date-panel > div.ant-calendar-range-part.ant-calendar-range-right > div.ant-calendar-input-wrap > div > input"));
	        enddatelogin.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	        enddatelogin.sendKeys(Keys.BACK_SPACE);
	        enddatelogin.sendKeys("02-14-2022"+Keys.ENTER);
	        Thread.sleep(2000);
	}
	public static void numberoforg()  {
		System.out.println("3.Selecting No. of Organizations");
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a/span/u/p")).click();
		WebElement Search=driver.findElement(By.xpath("//input[@placeholder=\"Search..\"]"));
		Search.sendKeys("NIRAJRS2");
		Search.click();
		
	}

}

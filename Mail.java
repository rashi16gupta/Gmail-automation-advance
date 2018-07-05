package rashi.GoogleMail;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Mail {
	public static  WebDriver driver;
	static WebDriverWait wait;
	  private static WebElement getUserNameEntry(){
	        return driver.findElement(By.xpath("//*[@id='identifierId']"));
	    }
	    
	    private static WebElement getPasswordEntry(){
	        return driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
	    }
	    
	    private static String getErrorMessageElement(){
	      
	    	//String error= driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/form/content/div[1]/div/div[2]/div[2]")).getText();
	    	String error= driver.findElement(By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div:nth-child(2) > form > content > div.cDSmF > div > div.LXRPh > div.dEOOab.RxsGPe")).getText();
	  	  
	    	System.out.println("error="+error); return error;
	    }
	    
	public static void launch() throws FileNotFoundException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:/rashi/chromedriver/chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
		driver.get("http://gmail.com/");
		driver.manage().window().maximize();
		 wait = new WebDriverWait(driver,50); 
		
	 
	}
	
	
	public static String testForIncorrectUserName(){
		getUserNameEntry().sendKeys("abcde");
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		return getErrorMessageElement();
		
	}
	
	public static String testForCorrectCredentials()  {
		 getUserNameEntry().sendKeys("rashi_cs_2014@rkgitw.edu.in");
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		getPasswordEntry().sendKeys("Rashi143");
		
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		//driver.findElement(By.id("passwordNext")).click();
		//driver.findElement(By.cssSelector("#passwordNext > content > span")).click();
		//driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
		
		
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		return driver.getTitle();
	}
	/* public Boolean isErrorMessage(String expectedMessage){
	        return getErrorMessageElement();
	                .contains(expectedMessage);
	    }*/
	
	public static String composeMail()
	{
		//List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		driver.findElement(By.xpath("//div/textarea[@role='combobox']")).sendKeys("csrashi143@gmail.com");
		driver.findElement(By.xpath("//div/input[@name='subjectbox']")).sendKeys("A example of msg");
		driver.findElement(By.xpath("//div/div[@aria-label='Message Body']")).sendKeys("Message to be shown as sent");
		driver.findElement(By.xpath("//tr/td/div/div[@class='T-I J-J5-Ji aoO T-I-atl L3']")).click();
		
		return driver.findElement(By.xpath("//span[contains(text(),'Message sent.')]")).getText();
		
	}
	
	
	//deleting  1st read mail
	public static String deleteMail() throws InterruptedException
	{
	/*List<WebElement> element = driver.findElements(By.xpath("//tbody/tr/td[@class='yX xY ']"));
System.out.println(element);	element.get(0).click();*/
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='zA yO']")));
	        
			driver.findElement(By.xpath("//*[@class='zA yO']")).click();
			Thread.sleep(5000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div[@data-tooltip='Delete']")));
			driver.findElement(By.xpath("//div/div[@data-tooltip='Delete']")).click();
			
		return null;
		
	}
	
	//opening  1st unread mail
	  public static void OpenMail() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='zA zE']")));
	        
		driver.findElement(By.xpath("//*[@class='zA zE']")).click();
		Thread.sleep(5000);
		
		driver.navigate().back();
	  }
	
}


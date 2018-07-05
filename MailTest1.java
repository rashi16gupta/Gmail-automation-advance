package rashi.GoogleMail;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class MailTest1 {
 
	public   WebDriver driver=Mail.driver;
	@BeforeClass
	public void launchBrowser() throws FileNotFoundException, IOException 
	{
		Mail.launch();
	 
	}
	/*@Test
	  public void test001_For_InCorrect_Uname()  {
			String eMsz= GmailTest.testForIncorrectUserName();
			System.out.println("error msz is"+eMsz);
			//Assert.assertEquals(eMsz,"Couldn't find your Google Account");
		}*/
	@Test
  public void test002_For_Correct_Credentials()  {
		String title=Mail.testForCorrectCredentials();
		Assert.assertEquals(title,"Gmail");
	}
	
	@Test
	  public void test003_For_Compose()  {
			String msz= Mail.composeMail();
			Assert.assertEquals(msz,"Message sent.");
		}
	@Test
	  public void test005_For_deleteMail() throws InterruptedException  {
			 Mail.deleteMail();
			//Assert.assertEquals(msz,"Message sent.");
		}
	@Test
	  public void test004_OpenMail() throws InterruptedException
	  {
		Mail.OpenMail();
	  }
	//
}
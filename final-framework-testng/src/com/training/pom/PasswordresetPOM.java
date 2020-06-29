package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PasswordresetPOM {
	private WebDriver driver; 
	
	public PasswordresetPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user']//a[contains(text(),'Login')]") 
	private WebElement Login;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	private WebElement EditAcc;
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement ChangePass;

	
	
	public  void Login() throws InterruptedException {
		     driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
			
	}
			
	
	public void sendUserName(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
  public void EditAccdetails() {
	  WebDriverWait wait = new WebDriverWait(driver, 1000);
	  wait.until(ExpectedConditions.visibilityOf(EditAcc));
	  this.EditAcc.click();
	  driver.findElement(By.id("input-firstname")).clear();
	  driver.findElement(By.id("input-firstname")).sendKeys("Payal2");
	  driver.findElement(By.id("input-lastname")).clear();
	  driver.findElement(By.id("input-lastname")).sendKeys("Uttamani2");
	  driver.findElement(By.id("input-email")).clear();
	  driver.findElement(By.id("input-email")).sendKeys("payalahuja29@yahoo.com");
	  driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	  WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
	   String text = msg.getText();
	   Assert.assertEquals(text,"Success: Your account has been successfully updated.");
  }
  
  public void Changepasswrd() {
	  this.ChangePass.click();
	  driver.findElement(By.id("input-password")).sendKeys("Selenium_09");
	  driver.findElement(By.id("input-confirm")).sendKeys("Selenium_09");
	  driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	  WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
	   String text = msg.getText();
	   Assert.assertEquals(text,"Success: Your password has been changed successfully");
	  
	  
	  
  }
	
}






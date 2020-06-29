package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 
	
	@FindBy(id="input-username")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="///a[contains(text(),'Edit Account')]")
	private WebElement EditAcc;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	//@FindBy(className="dropdown-toggle")
	//private WebElement dropdown; 
	
	
	
	
	
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
	public  void dropdown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fa-fw']"));
		Actions act=new Actions(driver);
		act.moveToElement(dropdown).build().perform();
		Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='sale']/ul/li[1]/a[1]"));
			act.moveToElement(element).click().build().perform();
			WebElement View = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr[1]/td[8]//a[1]/i"));
			act.moveToElement(View).click().build().perform();

	}
  public void EditAccdetails() {
	  this.EditAcc.clear();
	  this.EditAcc.click();
  }
	
}

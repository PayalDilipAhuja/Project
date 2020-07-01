package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderplacePOM {
	private WebDriver driver; 
	
	public OrderplacePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 
	
	@FindBy(xpath="//a[contains(text(),'REGULAR T-SHIRTS (Rust)')]")
	private WebElement Shop;
	
	//@FindBy(xpath="//select[@name='option[376]']//span[@class='customSelect form-control customSelectHover']")
	//private WebElement dropdown;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block']")
	private WebElement btn;
	
	
	
	
	
	
	public void ShopUniform() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//this.Shop.clear();
		this.Shop.click();
		
	}
	
	public void dropdown2() throws InterruptedException {
		//this.Shop.clear();
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='option[376]']"));
		Select selectValue = new Select(dropdown);
		selectValue.selectByIndex(2);
		//this.dropdown.click();
		
	}
	public void addtocart() throws InterruptedException {
		//this.Shop.clear();
		this.btn.click();
		
	}

}

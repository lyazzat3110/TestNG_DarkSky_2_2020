package com.qa.darksky.util;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.speakBetter.base.BasePage;


public class ElementUtil extends BasePage {
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	Properties prop;
	
	 public void scrollByElement(By locator){
	        WebElement scrollElement = getElement(locator);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", scrollElement);
	    }
	
	 public void scrollByPixel(String xPixel, String yPixel){
	        String str = "window.scrollBy("+ xPixel +", "+ yPixel +")";
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript(str);
	    }

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstant.DEFAULT_TIMEOUT);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * Wait for title
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	public boolean waitForElementPresent(WebElement locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated((By) locator));
		return true;
	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	
	
	/**
	 * Get title
	 * @return
	 */
	public String doGetPageTitle() {
		
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;
	}
	
	/**
	 * This method is used to create the webelement on the basis of by locator
	 * @param locator
	 * @return
	 */
	

	public WebElement getElement( By locator) {
//		
		WebElement element = null;
		
		try {
			if(waitForElementPresent(locator));
			element = driver.findElement(locator);
			
			
		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element");
		}
		return element;
	}
	public WebElement getElement( WebElement locator) {
//		
		WebElement element = null;
		
		try {
			if(waitForElementPresent(locator));
			element = driver.findElement((By) locator);
			
			
		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element");
		}
		return element;
	}
	/**
	 * This method is used to click the webelement on the basis of by locator
	 * @param locator
	 */
	public void doClick(By locator) {
		
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element");
		}
	}
    public void doClick(WebElement locator) {
		
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element");
		}
	}
	
	/**
	 * This method is used to send value in a field
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
			
		} catch (Exception e) {
			System.out.println("some exception got occured while entering values in a field");
		}
	}
	
	/**
	 * isDisplayed
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {
		
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occured isDisplayed method");
		}
		return false;
	}
	
	/**
	 * isEnabled
	 * @param locator
	 * @return
	 */
	public boolean doIsEnabled(By locator) {
		
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception got occured isEnabled method");
		}
		return false;
	}
	
	/**
	 * isSelected
	 * @param locator
	 * @return
	 */
	public boolean doIsSelected(By locator) {
		
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception got occured isSelected method");
		}
		return false;
	}
	
	
	/**
	 * GetText()
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting text...");
		}
		return null;
	}

	public  void selectDropDownValueByValue(By locator, String value) {
		WebElement element=getElement( locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
		
	
	}
}

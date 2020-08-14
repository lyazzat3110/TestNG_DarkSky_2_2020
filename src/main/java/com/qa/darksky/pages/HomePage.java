package com.qa.darksky.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darksky.util.ElementUtil;
import com.qa.speakBetter.base.BasePage;


public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	
	By today = By.xpath(" //*[@id='week']/a[1]");
	By currentTemp = By.xpath("//*[@class='summary swap']");
	By allTemperature = By.xpath("//div[@id='week']//div[@class='temps']//span[contains(text(),'°')]");


	public HomePage(WebDriver driver) {
		 this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}



	public void expandToday() throws InterruptedException {

		elementUtil.scrollByPixel("0", "1000");
		elementUtil.waitForElementPresent(today);
		elementUtil.doClick(today);
		Thread.sleep(3000);
	}

	public void findTodaysTemperature() throws InterruptedException {

		List<WebElement> temperatureList = driver.findElements(allTemperature);

		String currentTemperature = driver.findElement(currentTemp).getText();
		System.out.println("Current Temp:" + currentTemperature);
		System.out.println("List of all temperature");
		int temperature = Integer.parseInt(currentTemperature.substring(0, 2));

		int maxTemp = temperature;
		int minTem = temperature;

		for (int i = 0; i < temperatureList.size(); i++) {
			String text = temperatureList.get(i).getText().substring(0, 2);
			int listTemp = Integer.parseInt(text);

			System.out.println("instant temperatures : " + listTemp);

			if (listTemp > maxTemp) {
				maxTemp = listTemp;
			}
			if (listTemp < minTem) {
				minTem = listTemp;
			}
		}

		System.out.println("Maximum temperature is : " + maxTemp);
		System.out.println("Minimum temperature is : " + minTem);
		
	}
}

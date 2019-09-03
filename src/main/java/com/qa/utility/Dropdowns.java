package com.qa.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdowns {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Selenium files/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.findElement(By.id("justAnInputBox")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String multipleValue[] = { "choice 1", "choice 2", "choice 2 1", "choice 2 3" };
		String value = "choice 1";
		String selectAll = "all";

		selectDropdownValue(driver, selectAll);

	}

	/**
	 * this method checks the value/values in a drop down without select tag
	 * 
	 * @param driver
	 * @param value
	 */

	public static void selectDropdownValue(WebDriver driver, String... value) {
		int counter = 0;
		List<WebElement> choiceList = driver.findElements(
				By.xpath("//div[@class='comboTreeDropDownContainer']/ul//li/span[@class='comboTreeItemTitle']"));

		System.out.println(choiceList.size());

		if (!value[0].equalsIgnoreCase("all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				System.out.println(choiceList.get(i).getText());

				String text = choiceList.get(i).getText();

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						choiceList.get(i).click();
						counter = counter + 1;
					}
				}
				if (counter == value.length) {
					break;
				}
			}
		} else {
			try {
				for (int i = 0; i < choiceList.size(); i++) {
					choiceList.get(i).click();
				}
			} catch (Exception e) {

			}

		}
	}
}

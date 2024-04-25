package testObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MobileSearch_ElementsPage {
	
	public static WebElement element ;
	public static WebDriver driver;

	public static WebElement getSearchBox(WebDriver driver) {
		element =driver.findElement(By.id("twotabsearchtextbox"));
		return element;
	}
	public static WebElement getSearchText(WebDriver driver) {
		element =driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
		return element;
	}
	public static WebElement getResult(WebDriver driver) {
		element =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
		return element;
	}
    
	public static WebElement getSortListbox(WebDriver driver) {
		element =driver.findElement(By.className("a-dropdown-label"));
		return element;
	}
	public static List<WebElement> getOptions(WebDriver driver) {
		List<WebElement> options =driver.findElements(By.className("a-dropdown-item"));
		return options;
	}
	
	public static WebElement getSelectedOption(WebDriver driver) {
		element=driver.findElement(By.className("a-dropdown-prompt"));
		return element;
	}
}


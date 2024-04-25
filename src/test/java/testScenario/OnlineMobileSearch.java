package testScenario;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testObjectRepository.MobileSearch_ElementsPage;
import userDefinedLibraries.DriverSetup;


public class OnlineMobileSearch {
	
	public static WebDriver driver;
	
	public static WebElement searchBox,sortList,result,selectedOption,search;
	public static List<WebElement> options;
	public static String searchText,resultText;
	
	public static void driverconfig(String browser)
    {
	 	//Instantiate driver 
    	driver=DriverSetup.driverInstantiate(browser);   
    }
    
	public static void insertTextInSearchBox() 
	{
		//Inserting the search text in searchBox
		
		searchBox=MobileSearch_ElementsPage.getSearchBox(driver);
		searchBox.sendKeys("mobile smartphones under 30000");
		searchBox.submit();
		
	}
	
	public static void validatingSearchText()
	{
		//Search text validation
		
		search=MobileSearch_ElementsPage.getSearchText(driver);
		searchText=search.getText();
		
		System.out.println("Search text:"+searchText);
		String txt=searchText.replace("\"", "");
		if(txt.equals("mobile smartphones under 30000")) {
			System.out.println("Search text validation is passed");
	    }
	    else {
	    	System.out.println("Search text validation is failed");
	    }
	}
	
	public static void validatingNumberOfPages() 
	{
		// validation on No of pages in search results
		
		result=MobileSearch_ElementsPage.getResult(driver);
		 resultText = result.getText();
	    String Str[]=resultText.split(" ");
	    System.out.println("No of pages:"+Str[0]);
	    if(Str[0].matches("[0-9-]+")) {
	    	System.out.println("Number of pages validation is passed");
	    }
	    else {
	    	System.out.println("Number of pages validation is failed");
	    }
	    
	   
	}
	
	public static void validatingNumberOfItems() 
	{
		// validation on No of items in search results
		
		 
	    String Str[]=resultText .split(" ");
	    String s;
	    if(resultText.contains("over"))
	    {
	    	s=Str[3];
	    }
	    else
	    {
	    	s=Str[2];
	    }
	    
	    System.out.println("No of items:"+s);
	    if(s.matches("[0-9,]*")) {
	    	System.out.println("Number of items validation is passed");
	    }
	    else {
	    	System.out.println("Number of items validation is failed");
	    }
	    
	   
	}
	
	public static void clickOnSortListBox() 
	{
		//clicking the 'Sort By' option on the web page
		
		sortList=MobileSearch_ElementsPage.getSortListbox(driver);
		sortList.click();
	}
	
	public static void countOptions() 
	{
		//counting options in sort list
		options=MobileSearch_ElementsPage.getOptions(driver);
		int count=options.size();
		if(count==4) {
			System.out.println("Test for count of options is passed");
		}
		else {
			System.out.println("Test for count of options is failed");
		}
	}
	
	public static void selectNewArrivals() 
	{
		//selection of newest arrivals in sort list
		
		for(WebElement w:options) {
			if(w.getText().equals("Newest Arrivals")) {
				w.click();
			}
		}
	}
	
	public static void validatingSelectedOption()
	{
		//selected option validation
		
		selectedOption=MobileSearch_ElementsPage.getSelectedOption(driver);
		String s=selectedOption.getText();
		if(s.equals("Newest Arrivals")) {
			System.out.println("Test for selecting correct option is passed ");
		}
		else {
			System.out.println("Test for selecting correct option is failed");
		}
	}
	public static void  closebrowser() {
		DriverSetup.driverTearDown();
		System.out.println("Browser is closed");
	}

	public static void main(String[] args) {
		String browser;
		System.out.println("Enter the Browser type (chrome or edge):");
		Scanner sc=new Scanner(System.in);
		browser=sc.nextLine();
		sc.close();
		driverconfig(browser);
		insertTextInSearchBox();
		validatingSearchText();
		validatingNumberOfPages();
		validatingNumberOfItems();
		clickOnSortListBox();
		countOptions();
		selectNewArrivals();
		validatingSelectedOption();
		closebrowser();

	}

}


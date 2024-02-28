package selenium;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import selenium.check.Person;

public class launchselenium {
	public static void main(String args []) throws InterruptedException, JsonMappingException, JsonProcessingException {
		//Read data From Json file
		dataRead ReadData = new dataRead();
        String myData = ReadData.data();
        System.out.println(myData);
        
        //* Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adarsh Gowda\\OneDrive\\Documents\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Open the URL
        String url = "https://testpages.herokuapp.com/styled/tag/dynamic-table.html";
        driver.get(url);
        
        //Click on the Data table 
        WebElement inputTextBox = driver.findElement(By.xpath("//details"));
        inputTextBox.click();
        
        //Enter the Data into Text Box
        WebElement dataField = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
         dataField.clear();
        dataField.sendKeys(myData);
        
        //Click on Refresh Page
        WebElement refreshButton = driver.findElement(By.xpath("//button[@id='refreshtable']"));
        refreshButton.click();
  
		
     // Retrieve table data from UI
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='dynamictable']//tr"));
        tableRows.remove(0);
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);
            numbers.add(row.getText());
        }
        
        //Retrive Data from Json and convert into String List
        check jdata = new check();
     	List<Person> a = jdata.Mymethod();
        List<String> stringList = new ArrayList<>();
        for (Person num : a) {
            stringList.add(String.valueOf(num)); 
        }
  
        		
      // Assert the data in the table matches the json data
        boolean dataMatch = true;
        boolean areEqual = numbers.equals(stringList);
        System.out.println(stringList);
        System.out.println(numbers);
        // Output the result of the assertion
        if (areEqual) {
            System.out.println("Data in the table matches the Json data iin file.");
        } else {
            System.out.println("Data in the table does not match the Json data file.");
        }

        // Close the browser
        driver.quit();
 
	}
}

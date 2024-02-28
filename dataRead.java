package selenium;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class dataRead {
	public static void main(String args []) throws InterruptedException {
        
		data();
	}
	 public static String data (){        
			// Read test data from JSON file
	        List<TestData> testDataList = null;
	        try {
	            Gson gson = new Gson();
	            Type listType = new TypeToken<List<TestData>>() {}.getType();
	            testDataList = gson.fromJson(new FileReader("C:\\Users\\Adarsh Gowda\\OneDrive\\Desktop\\Myprome\\src\\main\\java\\selenium\\data.json"), listType);
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
	     // Convert test data to JSON string
	        String Data = new Gson().toJson(testDataList);
	        return Data;
	        }
	
}

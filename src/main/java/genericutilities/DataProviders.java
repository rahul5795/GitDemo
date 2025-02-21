package genericutilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider
	public Object[][] getData() throws IOException {
		/*
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("email", "abc57@gmail.com");
		map.put("password", "Rahul@123");
		map.put("product", "QWERTY");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "abc5795@gmail.com");
		map1.put("password", "Rahul@123");
		map1.put("product", "QWERTY");

		
		return new Object[][] {{map},{map1}};
		*/
		
		
		 DataReader dataReader= new DataReader();
			List<HashMap<String, String>> data = 
		dataReader.getJsonDataToMap(System.getProperty("user.dir")+"//testData//PurchaseOrder.json");;
		//dataReader.getJsonDataToMap("E:\\Selenium_Framework\\Ecommerce_Framework\\testData\\PurchaseOrder.json");
	      return new Object[][] { { data.get(0) }, { data.get(1) } };
	      
	}

}

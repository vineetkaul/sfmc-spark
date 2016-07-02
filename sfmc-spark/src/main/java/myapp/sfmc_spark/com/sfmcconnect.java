package myapp.sfmc_spark.com;

import com.exacttarget.fuelsdk.*;

public class sfmcconnect {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// retrieve the data extension "products"
		// ETFilter filter = new ETFilter("Name", ETFilter.Operators.EQUALS, "products");
		 
	   try 
	   {
		// instantiate ETClient object
		    ETClient client = new ETClient("src/main/resources/fuelsdk.properties");
		    
		// develop data extensions 
		    /**
		    ETDataExtension dataExtension = new ETDataExtension();
		    dataExtension.setClient(client);
		    
			ETResponse<ETDataExtensionRow> response = new ETResponse<ETDataExtensionRow>();
			
			// add a row to the data extension "products"
			ETDataExtensionRow row = new ETDataExtensionRow();
			row.setDataExtensionKey("0C7EDE82-F275-4F97-ABE8-BB38DC196DCD");
			row.setColumn("Social Name", "Huma");
			row.setColumn("Social Email Id", "huma.kaul@inforte.com");			
			response = dataExtension.insert(row);
			
		    **/
		    
		// Develop a triggered email + list.	
			ETTriggeredEmail trigEmail = new ETTriggeredEmail();
			trigEmail.setClient(client);
			ETSubscriber trigSubs = new ETSubscriber();
			ETResponse<ETTriggeredEmail> eresponse = new ETResponse<ETTriggeredEmail>();
			
			trigSubs.setClient(client);
			trigSubs.setEmailAddress("kaul.vineet@gmail.com");
			trigSubs.setKey("huma@gmail.com");
			
			trigEmail.setKey("ba08d41f-61fe-4418-9c2d-a464ace8c92c");
			eresponse =  trigEmail.send(trigSubs);
			System.out.println("***" + eresponse.getResponseMessage() + "- -" + eresponse.getRequestId());
	   } 
	   catch (ETSdkException e) 
	   {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   System.out.println("*** ETSdkException");
	   }
	   catch (Exception exp)
	   {
		   exp.printStackTrace();
		   System.out.println("*** Exception");
	   }
		
	}
}

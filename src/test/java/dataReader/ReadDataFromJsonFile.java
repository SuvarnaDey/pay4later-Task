package dataReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import mergeData.WriteDataIntoCSVFile;
import mergeData.WriteDataIntoJsonFile;
import mergeData.WriteDataIntoXMLFile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Implementation.stepDefinition;
import SortByUserId.sortByID;

public class ReadDataFromJsonFile {
	
	public static void ReadJson() throws Throwable
	{
		ArrayList arr_user_id = new ArrayList();
	     ArrayList arr_first_name = new ArrayList();
	     ArrayList arr_last_name = new ArrayList();
	     ArrayList arr_user_name = new ArrayList();
	     ArrayList arr_user_type = new ArrayList();
	     ArrayList arr_last_login_time = new ArrayList();
		try
		{
			//parsing the file using JSONParser 
			JSONParser parser=new JSONParser();
			JSONArray a = (JSONArray) parser.parse(new FileReader("..\\com.task\\src\\test\\java\\data\\users.json"));
				
			//collecting various read data fields into respective arraylist
                    for (Object o : a)
                    {
                    	JSONObject jsonObj = (JSONObject) o;
                    	String user_id = (String) jsonObj.get("user_id").toString();
                    	arr_user_id.add(user_id);
			            String first_name = (String) jsonObj.get("first_name").toString();
			            arr_first_name.add(first_name);
			            String last_name = (String) jsonObj.get("last_name".toString());
			            arr_last_name.add(last_name);
			            String username = (String) jsonObj.get("username").toString();
			            arr_user_name.add(username);
			            String user_type = (String) jsonObj.get("user_type").toString();
			            arr_user_type.add(user_type);
			            String last_login_time = (String) jsonObj.get("last_login_time").toString();
			            arr_last_login_time.add(last_login_time);
            
			            //sorting data read based on userids
            ArrayList<String> arrayUserID=sortByID.sortXMLByUserId(arr_user_id);
            
          //Write the data read from JSON input file to respective output files
            WriteDataIntoJsonFile.writeJSon(arrayUserID,arr_first_name,arr_last_name,arr_user_name,arr_user_type,arr_last_login_time);
            WriteDataIntoCSVFile.writeCSV(arrayUserID,arr_first_name,arr_last_name,arr_user_name,arr_user_type,arr_last_login_time);
            WriteDataIntoXMLFile.writeXML(arrayUserID, arr_first_name, arr_last_name, arr_user_name, arr_user_type, arr_last_login_time);
                    
       }}
		catch(Exception e)
		{
			System.out.println(e);
		}
	

}
}
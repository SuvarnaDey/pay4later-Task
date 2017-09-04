package mergeData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.google.gson.stream.JsonWriter;

import Implementation.stepDefinition;

public class WriteDataIntoJsonFile {
	static JSONObject userObj = new JSONObject();
	
	public static void  writeJSon(ArrayList arr_user_id,ArrayList arr_first_name,ArrayList arr_last_name,ArrayList arr_user_name,ArrayList arr_user_type,ArrayList arr_last_login_time) throws Throwable
	{
		//creation of output json file
		File file_json= new File("..\\com.task\\src\\test\\java\\Output\\output.json");					
		File ofile=stepDefinition.output_JSON_data_file_is_created_and_is_empty_in_Output_Package();
		
		//writing the new output json file using FileWriter class
		FileWriter fileWriter=new FileWriter(ofile);
		if (ofile.exists())
		{
			for (int i=0;i<arr_user_id.size();i++)
			{
			 
			//putting data into arrayList
			  userObj.put("user_id",arr_user_id.get(i));
			  userObj.put("first_name",arr_first_name.get(i));
			  userObj.put("last_name", arr_last_name.get(i));
			  userObj.put("username",arr_user_name.get(i));
			  userObj.put("user_type", arr_user_type.get(i));
			  userObj.put("last_login_time", arr_last_login_time.get(i));
		 
			  fileWriter.write(userObj.toJSONString());
			}
			     
			fileWriter.flush();  
			fileWriter.close();   
		}   
		else
			throw new FileNotFoundException("Could not ouput JSON file");	
	}
}

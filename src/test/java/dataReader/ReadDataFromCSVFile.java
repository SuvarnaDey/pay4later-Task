package dataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;

import mergeData.WriteDataIntoCSVFile;
import mergeData.WriteDataIntoJsonFile;
import mergeData.WriteDataIntoXMLFile;

import Implementation.stepDefinition;
import SortByUserId.sortByID;

import com.opencsv.CSVReader;

public class ReadDataFromCSVFile 
{
	
	public static void ReadCSV() throws Throwable
	{
		//Initializing arraylist for collecting data for each field
		ArrayList<String> arrUser=new ArrayList();
		
		//reading the data from csv input file
		String filepath="..\\com.task\\src\\test\\java\\data\\users.csv";
		File file=new File(filepath);
		
		try
		{
			Scanner inputstream=new Scanner(file);
			inputstream.next();
			inputstream.next();
			inputstream.next();
			inputstream.next();
			inputstream.next();
			inputstream.next();
			inputstream.next();
		
			inputstream.useDelimiter(",");
			while (inputstream.hasNext())
			{
				String users=inputstream.next();
				String[] user=users.split(",");
		
				
				//collecting the comma separated data into the arraylists		
            	arrUser.add(user[0]);            	
				
            	//sort the userid read from input file in ascending order
            	//ArrayList<String> arrayUserID=sortByID.sortXMLByUserId(user[0]);
            	
            	//Write the data read from csv input file to respective output files
            	
            	WriteDataIntoCSVFile.writeCSV(arrUser);

			}
			inputstream.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	

public static void ReadCSVForOtherFiles() throws Throwable
{	
	//Initializing arraylist for collecting data for each field
	ArrayList arrUserid = new ArrayList();
    ArrayList arrFirstname = new ArrayList();
    ArrayList arrLastname = new ArrayList();
    ArrayList arrUsername = new ArrayList();
    ArrayList arrUserType = new ArrayList();
    ArrayList arrLastlogintime = new ArrayList();
    
  //reading the data from csv input file using BufferedReader
    String csvFile = "..\\com.task\\src\\test\\java\\data\\users.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    try {

        br = new BufferedReader(new FileReader(csvFile));
        //
        
        for(int i=1; (line = br.readLine()) != null; i++)while ((line = br.readLine()) != null) {
        	{
            // use comma as separator
            String[] users = line.split(cvsSplitBy);
            
          //collecting the comma separated data into the arraylists
            arrUserid.add(users[0]);
            arrFirstname.add(users[1]);
            arrLastname.add(users[2]);
            arrUsername.add(users[3]);
            arrUserType.add(users[4]);
            arrLastlogintime.add(users[5]);
        	}
        	
            ArrayList<String> arrayUserID=sortByID.sortXMLByUserId(arrUserid);
            
            WriteDataIntoXMLFile.writeXML(arrayUserID, arrFirstname,arrLastname, arrUsername,arrUserType, arrLastlogintime);
            WriteDataIntoJsonFile.writeJSon(arrayUserID, arrFirstname,arrLastname, arrUsername,arrUserType, arrLastlogintime);
        	
            
            //System.out.println(arr_user_id);
        }
    }
        catch(Exception e){
        	System.out.println(e);
        }
}
}



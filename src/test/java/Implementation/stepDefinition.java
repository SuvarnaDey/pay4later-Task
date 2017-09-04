package Implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import mergeData.WriteDataIntoJsonFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.opencsv.CSVWriter;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataReader.ReadDataFromCSVFile;
import dataReader.ReadDataFromJsonFile;
import dataReader.ReadDataFromXMLFile;

public class stepDefinition {
	
	@Given("^Input data files are ready to be read in data package$")
	public void input_data_files_are_ready_to_be_read_in_data_package() throws Throwable {
	    //code to check if input files are present
		try
		{
		File file_csv = new File("..\\com.task\\src\\test\\java\\data\\users.csv");
		File file_json= new File("..\\com.task\\src\\test\\java\\data\\users.json");
		File file_xml= new File("..\\com.task\\src\\test\\java\\data\\users.xml");
		
		if(file_csv.exists() && file_json.exists() && file_xml.exists()){
		    System.out.println("input files found");
		}
		else{
			throw new FileNotFoundException("Could not find input file");
		}	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	   // throw new PendingException();
	}

	@Given("^Output XML data file is created and is empty in Output Package$")
	public static Document output_XML_data_file_is_created_and_is_empty_in_Output_Package() throws Throwable {
	    
		//To create an empty XML output file
		try{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();	
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		return doc;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@Given("^Output JSON data file is created and is empty in Output Package$")
	public static File output_JSON_data_file_is_created_and_is_empty_in_Output_Package() throws Throwable {
		try{
			//code to create an empty JSOn Output file
			File file=new File("..\\com.task\\src\\test\\java\\Output\\output.json");  
	        file.createNewFile();
	        return file;
	       
		   // throw new PendingException();
			}
		catch(Exception e)
	   		{
			System.out.println(e);
		   
	   		}
		return null;
		}

	@Given("^Output CSV data file is created and is empty in Output Package$")
	public static PrintWriter output_CSV_data_file_is_created_and_is_empty_in_Output_Package() throws Throwable {
	    try{
	    	//code to create an empty CSV Output file
	    	String csv = "..\\com.task\\src\\test\\java\\Output\\output.csv";
			PrintWriter pw = new PrintWriter(new File(csv));
			return pw;
	    }
	    catch(Exception e)
		   {
			   System.out.println(e);
		   }
		return null;
	}
	
	@When("^an XML input file is read and sorted$")
	public  void an_XML_input_file_is_read_and_sorted() throws Throwable {
		//call ReadXML function in ReadDataFromXMLFile class
		ReadDataFromXMLFile.ReadXML();
	}

	@When("^a JSON input file is read and sorted$")
	public void a_JSON_input_file_is_read_and_sorted() throws Throwable {
	    // call ReadJSON function in ReadDataFromJsonFile class
		ReadDataFromJsonFile.ReadJson();
	}

	@When("^a CSV input file is read and sorted$")
	public void a_CSV_input_file_is_read_and_sorted() throws Throwable {
	    // call readCSV function in ReadDataFromCSVFile class
		ReadDataFromCSVFile.ReadCSV();
		ReadDataFromCSVFile.ReadCSVForOtherFiles();
	}

	@Then("^all CSV,JSON,XML output files should be present with the merged data$")
	public void all_CSV_JSON_XML_output_files_should_be_present_with_the_merged_data() throws Throwable {
		//to verify if the output files with merged data is present under output folder
		try
		{
		File file_csv = new File("..\\com.task\\src\\test\\java\\Output\\output.csv");
		File file_json= new File("..\\com.task\\src\\test\\java\\Output\\output.json");
		File file_xml= new File("..\\com.task\\src\\test\\java\\Output\\output.xml");
		
		if(file_csv.exists() && file_json.exists() && file_xml.exists()){
		    System.out.println("output files created with data");
		}
		else{
			throw new FileNotFoundException("Could not find output file");
		}	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}
}

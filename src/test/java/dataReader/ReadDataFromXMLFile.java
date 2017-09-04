package dataReader;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import mergeData.WriteDataIntoCSVFile;
import mergeData.WriteDataIntoJsonFile;
import mergeData.WriteDataIntoXMLFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Implementation.stepDefinition;
import SortByUserId.sortByID;

public class ReadDataFromXMLFile {
	
	public static void ReadXML() throws Throwable{
	
		//Initializing arraylist for collecting data for each field
		 ArrayList arr_userid = new ArrayList();
	     ArrayList arr_firstname = new ArrayList();
	     ArrayList arr_surname = new ArrayList();
	     ArrayList arr_username = new ArrayList();
	     ArrayList arr_type = new ArrayList();
	     ArrayList arr_lastlogintime = new ArrayList();
	     
		try
		{
			File xmlFile = new File("..\\com.task\\src\\test\\java\\data\\users.xml");
			//parsing the file using XML DOM Parser 
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(xmlFile);
	         
	         doc.getDocumentElement().normalize();
	       
	       //collecting various read data fields into respective arraylist
	         NodeList nList=doc.getElementsByTagName("user");
	               
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	             Node nNode = nList.item(temp);
	             if (nNode.getNodeType()==Node.ELEMENT_NODE)
	            		 {
	            	        Element element=(Element) nNode;
	            	 		NodeList Userid=element.getElementsByTagName("userid");
	            	 		String SUserId=Userid.item(0).getTextContent();
	            	 		arr_userid.add(SUserId);
	            	 			            	 		
	            	 		NodeList FirstName=element.getElementsByTagName("firstname");
	            	 		String SFstName=FirstName.item(0).getTextContent();
	            	 		arr_firstname.add(SFstName);
	            	 			            	 		
	            	 		NodeList Surname=element.getElementsByTagName("surname");
	            	 		String SSurname=Surname.item(0).getTextContent();
	            	 		arr_surname.add(SSurname);
	            	 		
	            	 		NodeList Username=element.getElementsByTagName("username");
	            	 		String Susername=Username.item(0).getTextContent();
	            	 		arr_username.add(Susername);
	            	 		
	            	 		NodeList UType=element.getElementsByTagName("type");
	            	 		String SType=UType.item(0).getTextContent();
	            	 		arr_type.add(SType);
	            	 		
	            	 		NodeList LTime=element.getElementsByTagName("lastlogintime");
	            	 		String sLTime=LTime.item(0).getTextContent();
	            	 		arr_lastlogintime.add(sLTime);
	            	 		
	        	            //sorting data read based on userids
	            	 		ArrayList<String> arrayUserID=sortByID.sortXMLByUserId(arr_userid);
	            	 		
	            	 		//Write the data read from XML input file to respective output files
	            	 		WriteDataIntoJsonFile.writeJSon(arrayUserID,arr_firstname,arr_surname,arr_username,arr_type,arr_lastlogintime);
	            	 		WriteDataIntoCSVFile.writeCSV(arrayUserID,arr_firstname,arr_surname,arr_username,arr_type,arr_lastlogintime);
	            	 		WriteDataIntoXMLFile.writeXML(arrayUserID, arr_firstname,arr_surname, arr_username,arr_type, arr_lastlogintime);
	            		
	            		 }             
	         }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}

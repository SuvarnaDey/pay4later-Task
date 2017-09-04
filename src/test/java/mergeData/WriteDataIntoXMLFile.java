package mergeData;

import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Node;

import Implementation.stepDefinition;

public class WriteDataIntoXMLFile {	
	
	public static void writeXML(ArrayList arr_userid,ArrayList arr_firstname,ArrayList arr_surname,ArrayList arr_username,ArrayList arr_type,ArrayList arr_lastlogintime) throws Throwable
	{
		
		try{
			//calling function to create XML output file
			Document doc=stepDefinition.output_XML_data_file_is_created_and_is_empty_in_Output_Package();
			
			//creating rootelement for the XML File
			 Element rootElement=doc.createElement("users");
			 doc.appendChild(rootElement);			
			 
			 //inserting data data in child tags 
			for (int i=0;i<arr_userid.size();i++)
			{
				Element user = doc.createElement("user");
				rootElement.appendChild(user);
				
			Element UserId = doc.createElement("userid");
			UserId.appendChild(doc.createTextNode(String.valueOf(arr_userid.get(i))));
			user.appendChild(UserId);
			
			Element FirstName = doc.createElement("firstname");
			FirstName.appendChild(doc.createTextNode(String.valueOf(arr_firstname.get(i))));
			user.appendChild(FirstName);
			 
			Element Surname=doc.createElement("surname");
			Surname.appendChild(doc.createTextNode(String.valueOf(arr_surname.get(i))));
			user.appendChild(Surname);
			
			Element Username=doc.createElement("username");
			Username.appendChild(doc.createTextNode(String.valueOf(arr_username.get(i))));
			user.appendChild(Username);
			
			Element Usertype=doc.createElement("type");
			Usertype.appendChild(doc.createTextNode(String.valueOf(arr_type.get(i))));
			user.appendChild(Usertype);
			
			Element time=doc.createElement("lastlogintime");
			time.appendChild(doc.createTextNode(String.valueOf(arr_lastlogintime.get(i))));
			user.appendChild(time);
			
			//writing the above data in the ouput file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("..\\com.task\\src\\test\\java\\Output\\output.xml"));
			transformer.transform(source, result);
		
			 }	
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			}
	}
}

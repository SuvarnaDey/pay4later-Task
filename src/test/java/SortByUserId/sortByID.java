package SortByUserId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class sortByID {
	public static ArrayList sortXMLByUserId(ArrayList arrUserid)
	{
		List<String> userid=new ArrayList<String>();
		userid.addAll(arrUserid);
		Collections.sort(userid);
		return (ArrayList) userid;
		
	}

}

package mergeData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Implementation.stepDefinition;

public class WriteDataIntoCSVFile {
	//Only used for CSV input file
	public static void writeCSV(ArrayList userid) throws Throwable
	{
		//creation of output csv file
		PrintWriter  pw=stepDefinition.output_CSV_data_file_is_created_and_is_empty_in_Output_Package();

        StringBuilder sb = new StringBuilder();
        
        //writing the csv tags using StringBuilder
        sb.append("User ID");
        sb.append(',');
        sb.append("First Name");
        sb.append(',');
        sb.append("Last Name");
        sb.append(',');
        sb.append("Username");
        sb.append(',');
        sb.append("User Type");
        sb.append(',');
        sb.append("Last Login Time");

        //writing data from the arrayList into the output file
        for(int i=0;i<userid.size();i++)
        {
        	sb.append(userid.get(i));
        	sb.append(',');
        }
            pw.write(sb.toString());
            pw.close();
     }
	
	
	//used for XML and JSON data input files
	public static void writeCSV(ArrayList userid, ArrayList firstname,ArrayList lastname,ArrayList username,ArrayList type,ArrayList time
) throws FileNotFoundException
	{
		String csv = "..\\com.task\\src\\test\\java\\Output\\output.csv";
		PrintWriter pw = new PrintWriter(new File(csv));
		
		//writing the csv tags using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("User ID");
        sb.append(',');
        sb.append("First Name");
        sb.append(',');
        sb.append("Last Name");
        sb.append(',');
        sb.append("Username");
        sb.append(',');
        sb.append("User Type");
        sb.append(',');
        sb.append("Last Login Time");
        sb.append('\n');
        
      //writing data from the arrayList into the output file
        for(int i=0;i<userid.size();i++)
        {
        	sb.append(userid.get(i));
        	sb.append(',');
            sb.append(firstname.get(i));
            sb.append(',');
            sb.append(lastname.get(i));
            sb.append(',');
            sb.append(username.get(i));
            sb.append(',');
            sb.append(type.get(i));
            sb.append(',');
            sb.append(time.get(i));
            sb.append('\n');
        }
            pw.write(sb.toString());
            pw.close();
        }

}



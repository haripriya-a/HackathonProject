import java.io.*;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.nio.file.*;
public class Battery {
	public static void main(String[] args)throws Exception 
	  { 
		String comp1="Uid u0a202";
		String comp2="Foreground activities";
		float Battery_percentage=0,Battery_drain=0;
		File file = new File("C:\\Users\\Haripriyaa A\\Downloads\\Battery.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String s1,s2,s3,Foreground=""; 
		while ((s1 = br.readLine()) != null) 
		{
			s2=s1;
			String[] array = s2.split(":");
			if(array.length>1)
			{ 
				array[0]=array[0].trim();
				if(array[0].equals(comp1)  )
				{
		         s3=array[1];
		         String[] array1 = s3.split("\\(");
		         Battery_drain=Float.parseFloat(array1[0]); 
		         System.out.println(Battery_drain);
				}
				if(array[0].equals(comp2))
				{
                 s3=array[1];
		         String[] array1 = s3.split("\\(r");
		         Foreground=array1[0].trim();
		         System.out.println(Foreground);
				} 
			}
	   
			  
		}
		Battery_percentage=(Battery_drain/1000);
		System.out.println(Battery_percentage);
		JSONParser parser=new JSONParser();
		JSONObject obj=new JSONObject();
		obj.put("Foreground_time",Foreground);
		obj.put("Battery_drain" ,Battery_drain);
		obj.put("Battery_percentage" ,Battery_percentage);
		FileWriter file1=new FileWriter("C:\\Users\\Haripriyaa A\\Desktop\\result.json");
		file1.write(obj.toString());
		file1.flush();
		System.out.println(obj);
		
	  } 
	
}

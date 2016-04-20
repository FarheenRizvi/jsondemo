package JsonFile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class jsonfile {
	public static void main(String[] args) {

		List<String> userid = new ArrayList<String>();
		userid.add("1");
		userid.add("2");
		userid.add("3");

		List<String> username = new ArrayList<String>();
		username.add("A");
		username.add("B");
		username.add("C");

		List<String> coursename = new ArrayList<String>();
		coursename.add("java");
		coursename.add("angular");
		coursename.add("C++");

		List<String> courseid = new ArrayList<String>();
		courseid.add("123");
		courseid.add("456");
		courseid.add("789");
		
		List<String> userlist = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			
		//user userobj=new user((user)userid.get(i), (user)username.get(i));
		user obj=new user();
		System.out.println("The new obj is"+obj.toString());
		obj.userId=userid.get(i);
		obj.userName=username.get(i);
		//String u=obj.userId.toString();
		userlist.add(i,obj.toString());
		}
		System.out.println(userlist.toString());
		
		

//	ArrayList<String> userlist = new ArrayList<String>();
//	for (int i = 0; i < 3; i++) {
//
//		Map<String, String> tempMap = new HashMap<String, String>();
//		tempMap.put(userid.get(i), username.get(i));
//		userlist.add(tempMap.toString().replace("=", ","));
//}
//		System.out.println(userlist);
//		
		ArrayList<String> courselist = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {
			Map<String, String> tempMap2 = new HashMap<String, String>();
			tempMap2.put(courseid.get(i), coursename.get(i));
			courselist.add(tempMap2.toString().replace("=", ","));
		}
		System.out.println(courselist);

		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();

		for (int i = 0; i < 50; i++) {
			JSONObject info = new JSONObject();
			Random randomizer = new Random();
			String randomuserlist = userlist.get(randomizer.nextInt(userlist.size()));
			//System.out.println(randomuserlist);

			String randomcourselist = courselist.get(randomizer.nextInt(courselist.size()));
		//	System.out.println(randomcourselist);

			info.put("user", randomuserlist);
			// info.put("username", username.get(i));
			info.put("course", randomcourselist);
			// info.put("courseid",courseid.get(i));

			list.add(info);
		}
		obj.put("jsonlist", list);
		try {
			FileWriter file = new FileWriter("D:\\jsonfile.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(obj);
	}
}
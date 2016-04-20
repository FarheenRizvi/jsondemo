package Json_test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFile {

	public static void main(String[] args) {
		JsonFile obj = new JsonFile();
		obj.run();
	}

	private void run() {

		ObjectMapper mapper = new ObjectMapper();

		List<Domain> filejson = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("D:\\NewFile.json"), filejson);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(filejson);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filejson);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Domain> createDummyObject() {

		List<Domain> jsonlist = new ArrayList<Domain>();
		List<String> userid = new ArrayList<String>();
		userid.add("55ffa8becd70af14f1ee05a8");
		userid.add("564c452fcd705e7afafa5d4e");
		userid.add("564c4487cd705e7afafa5d4d");
		userid.add("561e2a96781de9cab3793f39");
		userid.add("55ed72e8cd70d18b611110b1");
		userid.add("55ee7672cd70d18b611110ec");
		userid.add("56bda92bcd70d7e4d1b8979f");

		List<String> username = new ArrayList<String>();
		username.add("jack");
		username.add("paul");
		username.add("charles");
		username.add("alex");
		username.add("kartik");
		username.add("amit");
		username.add("david");

		List<String> coursename = new ArrayList<String>();
		coursename.add("How to Build a Startup");
		coursename.add("Private Equity");
		coursename.add("Resource Management");
		coursename.add("Corporate Culture");
		coursename.add("Fundamentals of Securities Lending");
		coursename.add("Understanding Network Security");
		coursename.add("Basics of various softwares");

		List<String> courseid = new ArrayList<String>();
		courseid.add("56012751cd70ac191be3b21f");
		courseid.add("560d0b88cd7067a5bc8f6225");
		courseid.add("564c0a7ccd705e7afafa5cee");
		courseid.add("5652e484cd705e7afafa5db9");
		courseid.add("560d0b0bcd7067a5bc8f6219");
		courseid.add("5656de54cd705e7afafa5e7c");
		courseid.add("56ce9bf7cd70e40f1ebd9897");

		List<String> coursedesc = new ArrayList<String>();
		coursedesc.add("How to Build a Startup-desc");
		coursedesc.add("Private Equity-desc");
		coursedesc.add("Resource Management-desc");
		coursedesc.add("Corporate Culture-desc");
		coursedesc.add("Fundamentals of Securities Lending-desc");
		coursedesc.add("Understanding Network Security-desc");
		coursedesc.add("Basics of various softwares-desc");

		for (int i = 0; i < 1000; i++) {
			Domain json = new Domain();
			int useridx = new Random().nextInt(userid.size());
			json.setUsername(username.get(useridx));
			json.setUserId(userid.get(useridx));
			int courseidx = new Random().nextInt(courseid.size());
			json.setCoursename(coursename.get(courseidx));
			json.setCourseId(courseid.get(courseidx));
			json.setCoursedesc(coursedesc.get(courseidx));
			jsonlist.add(json);
		}

		return jsonlist;

	}

}
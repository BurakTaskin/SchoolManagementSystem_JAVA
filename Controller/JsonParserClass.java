import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserClass {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jp = new JSONParser();
		FileReader fr = new FileReader(".\\JsonFile\\School.json");
		Object obj = jp.parse(fr);
		JSONObject empjsonobj = (JSONObject)obj;
		String fsurname = (String) empjsonobj.get("surname");
		System.out.print("Surname :"+fsurname);

	}

}

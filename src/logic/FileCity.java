package logic;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileCity extends FilePlain {
	
	public void pushJson(ArrayList<City> city) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		String collection = gson.toJson(city); 
		writeFile(collection);
	}
	
	public ArrayList<City> pullJson() throws IOException{
		String json = readFile(); 
		Gson gson = new Gson(); 
		Type type = new TypeToken <ArrayList<City>>(){}.getType(); 
		ArrayList<City> output = gson.fromJson(json, type); 
		return output; 
	}

}

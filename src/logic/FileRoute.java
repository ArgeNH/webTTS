package logic;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileRoute extends FilePlain{
	
	public void pushJson(ArrayList<Route> route) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		String collection = gson.toJson(route); 
		writeFile(collection);
	}
	
	public ArrayList<Route> pullJson() throws IOException{
		String json = readFile(); 
		Gson gson = new Gson(); 
		Type type = new TypeToken <ArrayList<Route>>(){}.getType(); 
		ArrayList<Route> output = gson.fromJson(json, type); 
		return output; 
	}

}

package main;
/**
 * a class to filter out the started events and return upcoming events
 */
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataAnalysis {
private ArrayList<Events> newlist;

/**
 * constructs a dataAnalysis class that takes in an arraylist of events as instance variable
 * 
 */
public DataAnalysis() {
 newlist=new ArrayList<Events>();
	
}
/**
 * method to get live events (upcoming events)
 * @param list
 * @return list of live events
 */
public ArrayList<Events> getLiveEvents(ArrayList<Events> list) {
		
		for(Events s:list  ) {
			if(s.getStatus().equals("live") ) {
				System.out.println(s.getName() + ": "+ s.getStatus());
				newlist.add(s);
		}
	} 
	return newlist;
}

}

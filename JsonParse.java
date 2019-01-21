package main;

/**
 * a class that parses json response from API website and constructs eventlist
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParse {
	private String jsonresponse;

	/**
	 * construct an empty jsonresponse
	 */
	public JsonParse() {
		jsonresponse = "";
	}

	/**
	 * get jsonresponse
	 * 
	 * @param result string
	 */
	public String getresponse(String res) {
		return jsonresponse;
	}

	/**
	 * Makes the API call and returns the JSON result as a String
	 * 
	 * @param url
	 * @return json response
	 * @throws IOException
	 */
	public String makeAPICall(String url) throws IOException {
		URL eventbriteapi;
		URLConnection yc;
		BufferedReader in;

		eventbriteapi = new URL(url);
		yc = eventbriteapi.openConnection();
		yc.setRequestProperty("Accept", "application/json");
		in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;

		StringBuffer response = new StringBuffer();
		// if it has more input append to the StringBuffer
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			// System.out.println(inputLine);
		}
		in.close();

		return response.toString().trim();
	}

	/**
	 * a method to parse the json response from eventbrite api to an arraylist
	 * 
	 * @param jsonresponse
	 * @return arraylist of event infos
	 * @throws JSONException
	 */
	public ArrayList<Events> parseJson(String jsonresponse) throws JSONException {
		// create a JSON object with the String response
		JSONObject jObj = new JSONObject(jsonresponse); // parse json object
		// Look at the raw String response
		// After the colon there is a square bracket indicating a JSONArray
		JSONArray jArray = jObj.getJSONArray("events"); // cannot find JSONObject["events"]

		ArrayList<Events> events = new ArrayList<>();
		String des = "", id = "", url = "", name = "", status = "";
		for (int i = 0; i < jArray.length(); i++) {
			name = jArray.getJSONObject(i).getJSONObject("name").getString("text");
			des = jArray.getJSONObject(i).getJSONObject("description").get("text").toString();
			id = jArray.getJSONObject(i).getString("id");
			url = jArray.getJSONObject(i).getString("url");
			status = jArray.getJSONObject(i).getString("status");
			Events e1 = new Events(name, url, des, id, status);
			events.add(e1);
		}
		return events;
	}

}

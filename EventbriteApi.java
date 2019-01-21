package main;
/**
 * class to get subcategory and category IDs of events
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventbriteApi {
	/**
 	* method to get category ID corresponding to its name
	 * @param jsonresponse
	 * @param catname
	 * @return category ID in string
	 * @throws JSONException
	 */
	
	public String getcategoryID(String jsonresponse, Object catname) throws JSONException{
			//create a json object with json response and obtain the corresponding ID to the category name
			JSONObject jobj=new JSONObject(jsonresponse);
			System.out.println(jobj);
			JSONArray jArray=jobj.getJSONArray("categories");
			for(int i=0;i<jArray.length();i++) { 
			String name =jArray.getJSONObject(i).getString("name");
			String id=jArray.getJSONObject(i).getString("id");
			if(name.equals(catname) ) {
				return id;
			}
			
			}
			return null;
		}
	/**
	 * method to get subcategory ID
	 * @param json response in string
	 * @param subcategory name of Object
	 * @return Id in String 
	 * 
	 */
	public String getsubcategoryID(String jsonresponse, Object subname) throws JSONException{
			//create new json object from json response and return the subcategory ID based on the name
			JSONObject jobj=new JSONObject(jsonresponse);
			JSONArray jArray=jobj.getJSONArray("subcategories");

			for(int i=0;i<jArray.length();i++) { 
			String name =jArray.getJSONObject(i).getString("name");
			String id=jArray.getJSONObject(i).getString("id");
			if(name.equals( (String)subname) ) {
				return id;
				}
			}
			return null;
			
		}
	
	

	
}

package main;
/**
 * class to create events
 */
public class Events {
	//instance variables
private String name;
private String url;
private String description;
private String id;
private String status;

/**
 * Constructs an Events object using name, url, description, id, and status
 * @param name
 * @param url
 * @param description
 * @param id
 * @param status
 */
public Events(String name, String url, String description, String id,String status) {
	this.name=name;
	this.url=url;
	this.description=description;
	this.id=id;
	this.status=status;
}
/**
 * Constructs an events object with name and url as parameters
 * @param name
 * @param url
 */
public Events(String name, String url) {
	this.name=name;
	this.url=url;
	
}
/**
 * return the name of the event
 * @return name
 */

public String getName() {
	return name;
}
/**
 * get url link of the event
 * @return url
 */
public String getUrl() {
	return url;
}
/**
 * get event description
 * @return event description
 */
public String getDescription() {
	return description;
}

/**
 * get ID of event
 * @return ID
 */
public String getId() {
	return id;
}
/**
 * get event status
 * @return status
 */
public String getStatus() {
	return status;
}
}

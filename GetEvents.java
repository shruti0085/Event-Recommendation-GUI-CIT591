package main;

import java.util.ArrayList;

public class GetEvents {
private ArrayList<Events> eventlist;

public GetEvents(ArrayList<Events> eventlist) {
	this.eventlist=eventlist;
}

public ArrayList<Events> getEvents(){
	ArrayList<Events> e1=new ArrayList<>(); 
if(eventlist.size()>5) {
	for(int i=0; i<5; i++) {
		Events e2 = eventlist.get(i);
		Events e = new Events(e2.getName(), e2.getUrl());
		e1.add(e);
		
		
	}
	}
	else {
		for(int i=0;i<eventlist.size();i++) {
			Events e2=eventlist.get(i);
			Events e = new Events(e2.getName(), e2.getUrl());
			e1.add(e);
		}
	
}
return eventlist;	
}

}
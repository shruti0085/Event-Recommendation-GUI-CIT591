# Event-Recommendation-GUI-CIT591
Developed  Graphical User Interface for recommending events ,analyzing Eventbrite API data based on user preferences.(Technology: Java, Swing)
Project Description: Recommendation platforms are always useful. We created an interface where users are asked their preferences: based on the category of event they would like to attend, the subcategory they pick, whether they want the event to be free or paid and what location do they choose. Based on these inputs we present the user 5 events recommendations with their names and URL links, the results are sorted by their preference. We also conducted additional analysis to get a more narrowed event list, sorted on the status of event(live) and display it via GuI hyperlinks. Future work could involve further analysis and more variety of events on the eventbrite API, as well as a more user-friendly interface for choosing event options.

Brief technology introduction of our project: We used 6 classes to implement this project: JsonParse, EventbriteAPI, Event, Main_User_API, OpenURLAction, DataAnalysis. Junit Testing was implemented in the test package, while all other classes were implemented in the main package. To run our code, go inside the main package, build path and configure for JSON java jar and run the Main_User_API function, to choose preferences and get a the top 5 events as output to the user.

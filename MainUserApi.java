package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.json.JSONException;

public class MainUserApi {
	public static void main(String[] args) throws URISyntaxException {

		/*
		 * main method for GUI
		 */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setSize(new Dimension(250, 32));
		panel.setLayout(null);
		/*
		 * first pop up dialog box, asking user to input their preferences
		 */

		JLabel label = new JLabel("Choose type of event:");
		label.setForeground(new Color(255, 255, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 11));
		label.setBounds(0, 0, 250, 32);
		panel.add(label);

		UIManager.put("OptionPane.minimumSize", new Dimension(270, 120));
		Object chooseCat = 0;
		Object[] options = { "Music", "Seasonal & Holiday", "Food & Drink", "Film, Media & Entertainment",
				"Sports & Fitness", "Religion & Spirituality", "Performing & Visual Arts" };
		Object cat = JOptionPane.showInputDialog(null, panel, "Event Recommender", JOptionPane.QUESTION_MESSAGE, null,
				options, options[3]);
		/*
		 * Based on their selection another dialog box comes up, asking to choose from
		 * different sub categories
		 */
		if (cat == "Music") {
			Object[] oMusic = { "Alternative", "Blues & Jazz", "Classical", "Country", "EDM / Electronic", "Metal",
					"Pop", "Rock" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose type of music:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Music Recommender", JOptionPane.QUESTION_MESSAGE,
					null, oMusic, oMusic[1]);

		} else if (cat == "Film, Media & Entertainment") {
			Object[] oFilm = { "Anime", "Gaming", "Film", "Comics", "Comedy", "TV" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose genre:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Entertainment Recommender",
					JOptionPane.QUESTION_MESSAGE, null, oFilm, oFilm[1]);
		} else if (cat == "Performing & Visual Arts") {
			Object[] op = { "Theatre", "Ballet", "Dance", "Musical", "Orchestra", "Fine Arts", "Literary Arts",
					"Painting" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose genre:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Live performances Recommender",
					JOptionPane.QUESTION_MESSAGE, null, op, op[1]);
		}

		else if (cat == "Sports & Fitness") {
			Object[] op = { "Running", "Walking", "Cycling", "Obstacles", "Basketball", "Baseball", "Golf",
					"Snow sports", "Fighting & Martial Arts", "Yoga", "Camps" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose genre:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Fitness events Recommender",
					JOptionPane.QUESTION_MESSAGE, null, op, op[1]);
		}

		else if (cat == "Food & Drink") {
			Object[] op = { "Wine", "Beer", "Food", "Spirits", "Other" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose genre:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Food events Recommender",
					JOptionPane.QUESTION_MESSAGE, null, op, op[1]);
		} else if (cat == "Religion & Spirituality") {
			Object[] op = { "Buddhism", "Sikhism", "Christanity", "Islam", "Mysticism and Occult" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose genre:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Religious events Recommender",
					JOptionPane.QUESTION_MESSAGE, null, op, op[1]);
		} else if (cat == "Seasonal & Holiday") {
			Object[] op = { "Easter", "Christmas", "Halloween/Haunt", "Thanksgiving", "Fall events", "New Years Eve" };
			JPanel panel2 = new JPanel();
			JLabel label2 = new JLabel("Choose genre:");
			panel2.add(label2);
			chooseCat = JOptionPane.showInputDialog(null, panel2, "Religious events Recommender",
					JOptionPane.QUESTION_MESSAGE, null, op, op[1]);
		}

		System.out.println("You chose category:" + cat);
		System.out.println("You chose subcategory:" + chooseCat);
		/*
		 * Third pop up box asks the user if they want event to be free/paid, if they
		 * click on cancel, they are okay with either
		 */
		int n = JOptionPane.showConfirmDialog(null, "Do you want the event to be free");
		if (n == 0) {
			System.out.println("You chose a free event");
		} else if (n == 1) {
			System.out.println("You chose a paid event");
		} else {
			System.out.println("You are okay with both");
		}
		/*
		 * Fourth, asks the user to choose a location for the event
		 */
		Object[] loc = { "Philadelphia", "NewYork", "Chicago", "California", "Texas", "Pittsburgh", "Boston",
				"Baltimore" };
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel("Choose location:");
		Object locf = JOptionPane.showInputDialog(null, panel3, "Choose location", JOptionPane.QUESTION_MESSAGE, null,
				loc, loc[3]);

		System.out.println("Your event location is:" + locf);
		System.out.println(n);
		// *******************end of GUI**************************/

		// variables obtained from GUI
		Object subcategory = chooseCat;
		String price;
		if (n == 0)
			price = "free";
		else if (n == 1)
			price = "paid";
		else
			price = "";

		// create the API URL
		String endPoint = "https://www.eventbriteapi.com/";
		String path = "v3/events/search/";
		String mytoken = "token=N2REMHSUG4QCDVMHYLPB";
		String queryParams = "?location.address=" + (String) locf + "&subcategories=";
		int pnum = 1;
		String initUrl = endPoint + "v3/subcategories/?" + mytoken + "&page=" + pnum;
		ArrayList<Events> eventlist = new ArrayList<>();
		// create new eventbrite api
		EventbriteApi e1 = new EventbriteApi();
		// create new JsonParse object to store the json objects
		JsonParse p1 = new JsonParse();
		String jsonResponse = "";
		try {
			// initial call to get category ids
			String jresponse = p1.makeAPICall(initUrl);

			String idnum = "";
			if (!jresponse.isEmpty()) {
				// if json response is not empty, obtain subcategory ID
				idnum = e1.getsubcategoryID(jresponse, subcategory);
				// loop through each page until the corresponding subcategory ID is found
				while (idnum == null) {
					pnum++;
					initUrl = endPoint + "v3/subcategories/?" + mytoken + "&page=" + pnum;
					jresponse = p1.makeAPICall(initUrl);
					System.out.println(jresponse);
					idnum = e1.getsubcategoryID(jresponse, subcategory);
				}
				System.out.println("id:" + idnum);
			}
			// add the id number to the full url and print it out
			String eventbriteUrl = endPoint + path + queryParams + idnum + "&sort_by=distance" + "&price=" + price + "&"
					+ mytoken;
			// make the API call and get a String response
			try {
				jsonResponse = p1.makeAPICall(eventbriteUrl);

				// if response is not empty, parse into json objects
			} catch (IOException ex) {
				// Print out invalid location error
				System.out.println("Not a valid location, try again");
			}
			if (!jsonResponse.isEmpty()) {
				// get events that have live status and obtain the top five or less based on
				// distance from API call
				DataAnalysis d1 = new DataAnalysis();

				ArrayList<Events> event = p1.parseJson(jsonResponse);
				event = d1.getLiveEvents(event);
				if (event.size() > 5) {
					for (int i = 0; i < 5; i++) {
						Events e2 = event.get(i);
						Events e = new Events(e2.getName(), e2.getUrl());
						eventlist.add(e);
						System.out.println(e2.getUrl());
					}
				} else {
					for (int i = 0; i < event.size(); i++) {
						Events e2 = event.get(i);
						Events e = new Events(e2.getName(), e2.getUrl());
						eventlist.add(e);
					}
				}
				// Open up no events dialog if there is 0 event
				if (eventlist.size() == 0) {
					JOptionPane.showMessageDialog(null, "No events occur for this preference");
				} else {

					// ****************gui for link********************
					/*
					 * creates a frame which shows the top 5 events
					 */
					URI[] uriarray = new URI[eventlist.size()]; // eventlist
					JFrame frame = new JFrame("Event Recommendation");
					JLabel lab1 = new JLabel("Top" + cat + " events", JLabel.CENTER);
					frame.add(lab1);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(400, 400);
					Container container = frame.getContentPane();
					container.setLayout(new GridBagLayout());
					// creates an array of URL type URI
					for (int i = 0; i < eventlist.size(); i++) {
						uriarray[i] = new URI(eventlist.get(i).getUrl());
						System.out.println("print: " + uriarray[i]);
					}
					/**
					 * Method to allow name of the event 1 to be associated with the URL(hyperlink)
					 * on GUI
					 * 
					 * @author esp13
					 *
					 */
					class OpenUrlAction implements ActionListener {
						@Override
						public void actionPerformed(ActionEvent e) {
							URI urithing = uriarray[0];
							open(urithing);

						}
					}
					class OpenUrlAction2 implements ActionListener {
						@Override
						public void actionPerformed(ActionEvent e) {
							URI urithing = uriarray[1];
							open(urithing);

						}
					}
					class OpenUrlAction3 implements ActionListener {
						@Override
						public void actionPerformed(ActionEvent e) {
							URI urithing = uriarray[2];
							open(urithing);

						}
					}
					class OpenUrlAction4 implements ActionListener {
						@Override
						public void actionPerformed(ActionEvent e) {
							URI urithing = uriarray[3];
							open(urithing);

						}
					}
					class OpenUrlAction5 implements ActionListener {
						@Override
						public void actionPerformed(ActionEvent e) {
							URI urithing = uriarray[5];
							open(urithing);

						}
					}

					int j = eventlist.size();
					if (j >= 1) {
						JButton button2 = new JButton();
						// creates button to display the name and link associated with the event 1 on
						// GUI

						button2.setText("<HTML><FONT color=\"#000099\"><U>" + eventlist.get(0).getName()
								+ "</U></FONT></HTML>");
						button2.setHorizontalAlignment(SwingConstants.LEFT);
						button2.setBorderPainted(false);
						button2.setOpaque(false);
						button2.setBackground(Color.WHITE);
						button2.setToolTipText(uriarray[0].toString());
						button2.addActionListener(new OpenUrlAction());
						container.add(button2);
					}

					if (j >= 2) {
						JButton button = new JButton();
						button.setText("<HTML><FONT color=\"#000099\"><U>" + eventlist.get(1).getName()
								+ "</U></FONT></HTML>");
						button.setHorizontalAlignment(SwingConstants.LEFT);
						button.setBorderPainted(false);
						button.setOpaque(false);
						button.setBackground(Color.WHITE);
						button.setToolTipText(uriarray[1].toString());
						button.addActionListener(new OpenUrlAction2());
						container.add(button);
					}

					if (j >= 3) {
						JButton button3 = new JButton();
						button3.setText("<HTML><FONT color=\"#000099\"><U>" + eventlist.get(2).getName()
								+ "</U></FONT></HTML>");
						button3.setHorizontalAlignment(SwingConstants.LEFT);
						button3.setBorderPainted(false);
						button3.setOpaque(false);
						button3.setBackground(Color.WHITE);
						button3.setToolTipText(uriarray[2].toString());
						button3.addActionListener(new OpenUrlAction3());
						container.add(button3);
					}
					if (j >= 4) {
						JButton button4 = new JButton();
						button4.setText("<HTML><FONT color=\"#000099\"><U>" + eventlist.get(3).getName()
								+ "</U></FONT></HTML>");
						button4.setHorizontalAlignment(SwingConstants.LEFT);
						button4.setBorderPainted(false);
						button4.setOpaque(false);
						button4.setBackground(Color.WHITE);
						button4.setToolTipText(uriarray[3].toString());
						button4.addActionListener(new OpenUrlAction4());
						container.add(button4);

					}
					if (j >= 5) {
						JButton button5 = new JButton();
						button5.setText("<HTML><FONT color=\"#000099\"><U>" + eventlist.get(4).getName()
								+ "</U></FONT></HTML>");
						button5.setHorizontalAlignment(SwingConstants.LEFT);
						button5.setBorderPainted(false);
						button5.setOpaque(false);
						button5.setBackground(Color.WHITE);
						button5.setToolTipText(uriarray[4].toString());
						button5.addActionListener(new OpenUrlAction5());
						container.add(button5);

					}
					frame.setLayout(new GridLayout(6, 1));
					frame.setVisible(true);

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//To open the URL on GUI
	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
			}
		} else {
		}
	}
}

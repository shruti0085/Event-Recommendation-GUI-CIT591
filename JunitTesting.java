package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.EventbriteApi;
import main.JsonParse;
import main.Events;
import main.DataAnalysis;
import static org.junit.Assert.*;
public class JunitTesting {

	EventbriteApi eventbriteapi;
	JsonParse jsonparse;
	Events events;
	String jresponse="{\"pagination\": {\"object_count\": 1, \"page_number\": 1, \"page_size\": 50, \"page_count\": 1, \"has_more_items\": false}, \"events\": [{\"name\": {\"text\": \"Discussion with Shivpreet Singh\", \"html\": \"Discussion with Shivpreet Singh\"}, \"description\": {\"text\": \"Monthly Kirtan and Discussion at the Hayward Gurdwara\", \"html\": \"<P>Monthly Kirtan and Discussion at the Hayward Gurdwara<\\/P>\"}, \"id\": \"40038492208\", \"url\": \"https://www.eventbrite.com/e/discussion-with-shivpreet-singh-tickets-40038492208?aff=ebapi\", \"start\": {\"timezone\": \"America/Los_Angeles\", \"local\": \"2018-12-23T11:30:00\", \"utc\": \"2018-12-23T19:30:00Z\"}, \"end\": {\"timezone\": \"America/Los_Angeles\", \"local\": \"2018-12-23T12:30:00\", \"utc\": \"2018-12-23T20:30:00Z\"}, \"organization_id\": \"235959541142\", \"created\": \"2017-11-17T18:40:30Z\", \"changed\": \"2017-11-17T23:25:38Z\", \"capacity\": null, \"capacity_is_custom\": null, \"status\": \"live\", \"currency\": \"USD\", \"listed\": true, \"shareable\": true, \"online_event\": false, \"tx_time_limit\": 480, \"hide_start_date\": false, \"hide_end_date\": false, \"locale\": \"en_US\", \"is_locked\": false, \"privacy_setting\": \"unlocked\", \"is_series\": true, \"is_series_parent\": false, \"is_reserved_seating\": false, \"show_pick_a_seat\": false, \"show_seatmap_thumbnail\": false, \"show_colors_in_seatmap_thumbnail\": false, \"source\": \"create_2.0\", \"is_free\": true, \"version\": \"3.0.0\", \"logo_id\": \"37862875\", \"organizer_id\": \"15785996841\", \"venue_id\": \"22149244\", \"category_id\": \"114\", \"subcategory_id\": \"14006\", \"format_id\": \"2\", \"resource_uri\": \"https://www.eventbriteapi.com/v3/events/40038492208/\", \"is_externally_ticketed\": false, \"series_id\": \"40038479169\", \"logo\": {\"crop_mask\": {\"top_left\": {\"x\": 130, \"y\": 0}, \"width\": 1832, \"height\": 916}, \"original\": {\"url\": \"https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F37862875%2F235959541142%2F1%2Foriginal.jpg?auto=compress&s=41ca666015617976bb5fa600c0d3ac0a\", \"width\": 2094, \"height\": 1396}, \"id\": \"37862875\", \"url\": \"https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F37862875%2F235959541142%2F1%2Foriginal.jpg?h=200&w=450&auto=compress&rect=130%2C0%2C1832%2C916&s=1194f846407910e99fc821c05b0735c0\", \"aspect_ratio\": \"2\", \"edge_color\": \"#98846a\", \"edge_color_set\": true}}], \"location\": {\"latitude\": \"36.778261\", \"augmented_location\": {\"country\": \"United States\", \"region\": \"California\"}, \"within\": \"697.17044648\", \"longitude\": \"-119.417932\", \"address\": \"California\"}}";
	String jresponse1="{\"pagination\": {\"object_count\": 197, \"page_number\": 3, \"page_size\": 50, \"page_count\": 4, \"continuation\": \"eyJwYWdlIjogNH0\", \"has_more_items\": true}, \"subcategories\": [{\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/8999/\", \"id\": \"8999\", \"name\": \"Other\", \"name_localized\": \"Other\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/108/\", \"id\": \"108\", \"name\": \"Sports & Fitness\", \"name_localized\": \"Sports & Fitness\", \"short_name\": \"Sports & Fitness\", \"short_name_localized\": \"Sports & Fitness\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9001/\", \"id\": \"9001\", \"name\": \"Hiking\", \"name_localized\": \"Hiking\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9002/\", \"id\": \"9002\", \"name\": \"Rafting\", \"name_localized\": \"Rafting\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9003/\", \"id\": \"9003\", \"name\": \"Kayaking\", \"name_localized\": \"Kayaking\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9004/\", \"id\": \"9004\", \"name\": \"Canoeing\", \"name_localized\": \"Canoeing\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9005/\", \"id\": \"9005\", \"name\": \"Climbing\", \"name_localized\": \"Climbing\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9006/\", \"id\": \"9006\", \"name\": \"Travel\", \"name_localized\": \"Travel\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/9999/\", \"id\": \"9999\", \"name\": \"Other\", \"name_localized\": \"Other\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/109/\", \"id\": \"109\", \"name\": \"Travel & Outdoor\", \"name_localized\": \"Travel & Outdoor\", \"short_name\": \"Travel & Outdoor\", \"short_name_localized\": \"Travel & Outdoor\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/10001/\", \"id\": \"10001\", \"name\": \"Beer\", \"name_localized\": \"Beer\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/110/\", \"id\": \"110\", \"name\": \"Food & Drink\", \"name_localized\": \"Food & Drink\", \"short_name\": \"Food & Drink\", \"short_name_localized\": \"Food & Drink\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/10002/\", \"id\": \"10002\", \"name\": \"Wine\", \"name_localized\": \"Wine\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/110/\", \"id\": \"110\", \"name\": \"Food & Drink\", \"name_localized\": \"Food & Drink\", \"short_name\": \"Food & Drink\", \"short_name_localized\": \"Food & Drink\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/10003/\", \"id\": \"10003\", \"name\": \"Food\", \"name_localized\": \"Food\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/110/\", \"id\": \"110\", \"name\": \"Food & Drink\", \"name_localized\": \"Food & Drink\", \"short_name\": \"Food & Drink\", \"short_name_localized\": \"Food & Drink\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/10004/\", \"id\": \"10004\", \"name\": \"Spirits\", \"name_localized\": \"Spirits\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/110/\", \"id\": \"110\", \"name\": \"Food & Drink\", \"name_localized\": \"Food & Drink\", \"short_name\": \"Food & Drink\", \"short_name_localized\": \"Food & Drink\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/10999/\", \"id\": \"10999\", \"name\": \"Other\", \"name_localized\": \"Other\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/110/\", \"id\": \"110\", \"name\": \"Food & Drink\", \"name_localized\": \"Food & Drink\", \"short_name\": \"Food & Drink\", \"short_name_localized\": \"Food & Drink\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11001/\", \"id\": \"11001\", \"name\": \"Animal Welfare\", \"name_localized\": \"Animal Welfare\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11002/\", \"id\": \"11002\", \"name\": \"Environment\", \"name_localized\": \"Environment\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11003/\", \"id\": \"11003\", \"name\": \"Healthcare\", \"name_localized\": \"Healthcare\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11004/\", \"id\": \"11004\", \"name\": \"Human Rights\", \"name_localized\": \"Human Rights\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11005/\", \"id\": \"11005\", \"name\": \"International Aid\", \"name_localized\": \"International Aid\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11006/\", \"id\": \"11006\", \"name\": \"Poverty\", \"name_localized\": \"Poverty\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11007/\", \"id\": \"11007\", \"name\": \"Disaster Relief\", \"name_localized\": \"Disaster Relief\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11008/\", \"id\": \"11008\", \"name\": \"Education\", \"name_localized\": \"Education\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/11999/\", \"id\": \"11999\", \"name\": \"Other\", \"name_localized\": \"Other\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/111/\", \"id\": \"111\", \"name\": \"Charity & Causes\", \"name_localized\": \"Charity & Causes\", \"short_name\": \"Charity & Causes\", \"short_name_localized\": \"Charity & Causes\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12001/\", \"id\": \"12001\", \"name\": \"Republican Party\", \"name_localized\": \"Republican Party\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12002/\", \"id\": \"12002\", \"name\": \"Democratic Party\", \"name_localized\": \"Democratic Party\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12003/\", \"id\": \"12003\", \"name\": \"Other Party\", \"name_localized\": \"Other Party\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12004/\", \"id\": \"12004\", \"name\": \"Non-partisan\", \"name_localized\": \"Non-partisan\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12005/\", \"id\": \"12005\", \"name\": \"Federal Government\", \"name_localized\": \"Federal Government\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12006/\", \"id\": \"12006\", \"name\": \"State Government\", \"name_localized\": \"State Government\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12007/\", \"id\": \"12007\", \"name\": \"County/Municipal Government \", \"name_localized\": \"County/Municipal Government \", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12008/\", \"id\": \"12008\", \"name\": \"Military\", \"name_localized\": \"Military\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12009/\", \"id\": \"12009\", \"name\": \"International Affairs\", \"name_localized\": \"International Affairs\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12010/\", \"id\": \"12010\", \"name\": \"National Security\", \"name_localized\": \"National Security\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/12999/\", \"id\": \"12999\", \"name\": \"Other\", \"name_localized\": \"Other\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/112/\", \"id\": \"112\", \"name\": \"Government & Politics\", \"name_localized\": \"Government & Politics\", \"short_name\": \"Government\", \"short_name_localized\": \"Government\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13001/\", \"id\": \"13001\", \"name\": \"State\", \"name_localized\": \"State\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13002/\", \"id\": \"13002\", \"name\": \"County\", \"name_localized\": \"County\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13003/\", \"id\": \"13003\", \"name\": \"City/Town\", \"name_localized\": \"City/Town\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13004/\", \"id\": \"13004\", \"name\": \"LGBT\", \"name_localized\": \"LGBT\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13005/\", \"id\": \"13005\", \"name\": \"Medieval\", \"name_localized\": \"Medieval\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13006/\", \"id\": \"13006\", \"name\": \"Renaissance\", \"name_localized\": \"Renaissance\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13007/\", \"id\": \"13007\", \"name\": \"Heritage\", \"name_localized\": \"Heritage\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13008/\", \"id\": \"13008\", \"name\": \"Nationality\", \"name_localized\": \"Nationality\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13009/\", \"id\": \"13009\", \"name\": \"Language\", \"name_localized\": \"Language\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13010/\", \"id\": \"13010\", \"name\": \"Historic\", \"name_localized\": \"Historic\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/13999/\", \"id\": \"13999\", \"name\": \"Other\", \"name_localized\": \"Other\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/113/\", \"id\": \"113\", \"name\": \"Community & Culture\", \"name_localized\": \"Community & Culture\", \"short_name\": \"Community\", \"short_name_localized\": \"Community\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/14001/\", \"id\": \"14001\", \"name\": \"Christianity\", \"name_localized\": \"Christianity\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/114/\", \"id\": \"114\", \"name\": \"Religion & Spirituality\", \"name_localized\": \"Religion & Spirituality\", \"short_name\": \"Spirituality\", \"short_name_localized\": \"Spirituality\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/14002/\", \"id\": \"14002\", \"name\": \"Judaism\", \"name_localized\": \"Judaism\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/114/\", \"id\": \"114\", \"name\": \"Religion & Spirituality\", \"name_localized\": \"Religion & Spirituality\", \"short_name\": \"Spirituality\", \"short_name_localized\": \"Spirituality\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/14003/\", \"id\": \"14003\", \"name\": \"Islam\", \"name_localized\": \"Islam\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/114/\", \"id\": \"114\", \"name\": \"Religion & Spirituality\", \"name_localized\": \"Religion & Spirituality\", \"short_name\": \"Spirituality\", \"short_name_localized\": \"Spirituality\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/14004/\", \"id\": \"14004\", \"name\": \"Mormonism\", \"name_localized\": \"Mormonism\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/114/\", \"id\": \"114\", \"name\": \"Religion & Spirituality\", \"name_localized\": \"Religion & Spirituality\", \"short_name\": \"Spirituality\", \"short_name_localized\": \"Spirituality\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/14005/\", \"id\": \"14005\", \"name\": \"Buddhism\", \"name_localized\": \"Buddhism\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/114/\", \"id\": \"114\", \"name\": \"Religion & Spirituality\", \"name_localized\": \"Religion & Spirituality\", \"short_name\": \"Spirituality\", \"short_name_localized\": \"Spirituality\"}}, {\"resource_uri\": \"https://www.eventbriteapi.com/v3/subcategories/14006/\", \"id\": \"14006\", \"name\": \"Sikhism\", \"name_localized\": \"Sikhism\", \"parent_category\": {\"resource_uri\": \"https://www.eventbriteapi.com/v3/categories/114/\", \"id\": \"114\", \"name\": \"Religion & Spirituality\", \"name_localized\": \"Religion & Spirituality\", \"short_name\": \"Spirituality\", \"short_name_localized\": \"Spirituality\"}}]}\r\n" + 
			"";
	ArrayList<Events> eventlist=new ArrayList<>();
	@BeforeEach
	public void setUp() {
		jsonparse = new JsonParse();		
		try {
			eventlist=jsonparse.parseJson(jresponse);
			eventbriteapi = new EventbriteApi();
			events = new Events("event","www.random.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	//Test in JsonParse class
	//Test getName method
	@Test
	public void testJsonPaserReturnsCorrectNumberOfElements1() throws JSONException {
		 ArrayList<Events> list = jsonparse.parseJson(jresponse);
		 assertEquals("Discussion with Shivpreet Singh",list.get(0).getName());		  
	}
	
	//Test the getUrl method
	@Test
	public void testJsonPaserReturnsCorrectNumberOfElements2() throws JSONException {
		 ArrayList<Events> list = jsonparse.parseJson(jresponse);
		 assertEquals("https://www.eventbrite.com/e/discussion-with-shivpreet-singh-tickets-40038492208?aff=ebapi",list.get(0).getUrl());
	}
	//Test the size of the returned json response
	@Test
	public void testJsonPaserReturnsCorrectNumberOfElements3() throws JSONException {
		 ArrayList<Events> list = jsonparse.parseJson(jresponse);
		 assertEquals(1,list.size());
		  
	}
	
	//Test for JsonParse exception
	@Test 
	public void jsontest1() throws JSONException{
		Assertions.assertThrows(org.json.JSONException.class,()->jsonparse.parseJson("x"));
		}
	//Test for Url malformed exception
	@Test
	public void makeAPICallTest1() throws MalformedURLException {
		
		Assertions.assertThrows(MalformedURLException.class,()->jsonparse.makeAPICall("fdsa"));
	}
	//Test for makeAPICall method
	@Test
	public void makeApitest2() throws IOException{
		Assertions.assertThrows(IOException.class,()->jsonparse.makeAPICall("jfdklsa"));
	} 
	
	//Test in EventbriteApi class
	//Functional test of the getsubcategoryID method
	@Test
	public void getsubcategoryIDTest1() throws JSONException {
		System.out.println(eventbriteapi.getsubcategoryID(jresponse1, "Sikhism") );
		
		assertEquals("14006", eventbriteapi.getsubcategoryID(jresponse1, "Sikhism"));
		System.out.println(eventbriteapi.getsubcategoryID(jresponse1, "Sikhism"));
	}

	//Test for JSON exception 
	@Test
	public void getsubcategoryIDTest21() throws JSONException {
		eventbriteapi.getsubcategoryID(jresponse1, "Theater");
		assertEquals(null, eventbriteapi.getsubcategoryID(jresponse1, "Theater"));
	}

	//Test inside the Events class
	//Test the getName method
	@Test
	public void getNameTest()
	{
		System.out.println("getName");
		Events instance = new Events("name","www.url.com");
		String expectedResult = "name";
		String result = instance.getName();
		assertEquals(expectedResult, result);
	}

	//Test the getUrl method
	@Test
	public void getUrlTest()
	{
		System.out.println("getUrl");
		Events instance = new Events("time","www.google.com");
		String expectedResult = "www.google.com";
		String result = instance.getUrl();
		assertEquals(expectedResult, result);
	}

	//Test the getDescription method
	@Test
	public void getDescriptionTest()
	{
		System.out.println("getDescription");
		Events instance = new Events("The Nutcracker Ballet","www.eventbriteapi.nutcracker.com","dance at the hall","","live");
		String expectedResult = "dance at the hall";
		String result = instance.getDescription();
		assertEquals(expectedResult, result);
	}

	//Test the getStatus method
	@Test
	public void getStatusTest1()
	{
		System.out.println("get status");
		Events instance = new Events("dance","www.eventlist.com","live dance at the city hall","111","live");
		assertEquals("live", instance.getStatus());	
	}
	
	//Test the getId method
	@Test
	public void getIdTest1()
	{
		Events instance = new Events("Name","www.google.com","Hello how are","104","live");
		String expectedResult = "104";
		String result = instance.getId();
		assertEquals(expectedResult, result);
	}
	
	//Test for getId method
	@Test
	public void getIdTest2() {
		System.out.println("getId");
		Events instance= new Events("Name","www.google.com","Hellow how are","103","live");
		String expectedResult = "104";
		String result = instance.getId();
		assertNotEquals(expectedResult,(result ));
		
	}
	
	//Test in DataAnalysis class
	//Test the getLiveEvents method
	@Test
	public void getStatusTest2()
	{
		System.out.println("live test");
		DataAnalysis d1=new DataAnalysis();
		ArrayList<Events> newlist=d1.getLiveEvents(eventlist);
		for(Events e:newlist) {
			if(!e.getStatus().equals("live"))
				newlist.add(e);
			}
			
			for(Events e:eventlist) {
				assertEquals("live", e.getStatus());	
			}
		}

}

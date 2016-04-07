package controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import models.weather;
import views.html.index;

//import play.libs.ws.WSRequest;


/**
 * Created by tianmaolan on 16/3/29.
 */
public class Applications extends Controller {

    public static Result sayHello(){
        return ok("say hello");
    }


    public static Result index() {


        return ok(index.render(weather.all(), Form.form(weather.class)));


    }



    public static Result getWeatherInfo() throws IOException{

//
        NamedNodeMap info = getInfo();


        String weather = "Date :" + getDate(info) + '\n' + "the weather is " + getTest(info);
        return ok(weather);


    }



    public static NamedNodeMap getInfo() throws IOException {

        StringBuffer strBuffer;

//        String city = java.net.URLEncoder.encode("202487889","utf-8");
//        System.out.print(city);
        String xml_url_head = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%20";
//                "2487889"
        String xml_url_end =    "&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        strBuffer=new StringBuffer();

        URL url = null;


        try {
//            url = new URL(yahoo_url);
            url = new URL(xml_url_head + "2487889" + xml_url_end);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }


        URLConnection conn = null;
        try {
            conn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        BufferedReader
//        InputStreamReader

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

        String line = null;
        while((line=reader.readLine())!=null)

        {
            strBuffer.append(line + " ");
        }

        reader.close();

        NamedNodeMap attr = strParseXML(strBuffer.toString());
//        System.out.print("Date :" + getDate(attr) + '\n' + "the weather is " + getTest(attr));
        return attr;
    }


    public static NamedNodeMap strParseXML(String str){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;

        Document doc = null;
        NamedNodeMap attributes = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource( new StringReader(str)));
            Element root = doc.getDocumentElement();

            org.w3c.dom.Node weatherInfo = root.getFirstChild().getFirstChild().getFirstChild().getFirstChild();
            attributes = weatherInfo.getAttributes();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return attributes;

    }

    public static String getTest(NamedNodeMap node){

        String text = node.getNamedItem("text").getNodeValue();

        return text;
    }

    public static String getDate(NamedNodeMap node){
        String date =  node.getNamedItem("date").getNodeValue();

        return date;
    }




}

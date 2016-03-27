package controllers;



//import com.oracle.javafx.jmx.json.JSONDocument;
//import com.oracle.javafx.jmx.json.JSONReader;
import jdk.nashorn.internal.parser.JSONParser;
//import org.json.*;
import play.*;
import play.api.libs.json.Json;
import play.api.libs.json.Writes;
import play.mvc.*;

import views.html.*;

//import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.lang.Object.*;

/**
 * Created by tianmaolan on 16/3/27.
 */
public class Application extends Controller {




//    public Result searchWeather() throws MalformedURLException, IOException {
//
//         BufferedReader br;
//         StringBuilder sb;
//
//
//        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%";
//        String cityCode =  "202487889";
//        String url2 = "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
//        URLConnection conn = new URL(url+cityCode + url2).openConnection();
//
//        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//        sb = new StringBuilder();
//
//        String line = null;
//
//        Writes<String> wr = null;
//
//        while ((line = br.readLine()) != null){
//            sb.append(line);
//
//        }
//
//        String datas = sb.toString();
//
//
//        return ok(datas);
////        return ok(index.render("Your new application is ready."));
//
//    }
}

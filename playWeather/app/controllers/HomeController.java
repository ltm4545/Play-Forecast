package controllers;

import play.*;
import play.api.libs.json.Writes;
import play.mvc.*;

import views.html.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
//    public Result index() {
//        return ok(index.render("Your new application is ready."));
//    }

    public Result addCityCode(){


        return redirect("/weather");
    }

    public Result searchWeather() throws MalformedURLException, IOException {

        BufferedReader br;
        StringBuilder sb;


        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%";
        String cityCode =  "202487889";
        String url2 = "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        URLConnection conn = new URL(url+cityCode + url2).openConnection();

        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        sb = new StringBuilder();

        String line = null;

        Writes<String> wr = null;

        while ((line = br.readLine()) != null){
            sb.append(line);

        }

        String datas = sb.toString();
        
        return ok(datas);
//        return ok(index.render("Your new application is ready."));

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Forecast;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.bind.JAXBException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author pedro
 */
public class UserWeather {
    
    YahooWeatherService service;
    Channel result;
    int tempMin;
    int tempMax;
    String descricao;

    
    // 737514 é oo codigo da yahoo de braga, nao sei como procurar codigos para outras cidades
    public UserWeather() throws JAXBException, IOException {
        this.service = new YahooWeatherService();
        this.result = service.getForecast("737514", DegreeUnit.CELSIUS);
        for (Forecast dia : this.result.getItem().getForecasts()) {
            if ("08 Dec 2016".equals(dia.getDate())) {
                this.tempMin = dia.getLow();
                this.tempMax = dia.getHigh();
                this.descricao = dia.getText();
                break;
            }
        }
    }
    
    public UserWeather(String data) throws JAXBException, IOException {
        this.service = new YahooWeatherService();
        this.result = service.getForecast("737514", DegreeUnit.CELSIUS);
        for (Forecast dia : this.result.getItem().getForecasts()) {
            if (data.equals(dia.getDate())) {
                this.tempMin = dia.getLow();
                this.tempMax = dia.getHigh();
                this.descricao = dia.getText();
                break;
            }
        }
    }
    
    public UserWeather(String cidade, String data) throws JAXBException, IOException {
        this.service = new YahooWeatherService();
        this.result = service.getForecast(getWOEID(cidade), DegreeUnit.CELSIUS);
        for (Forecast dia : this.result.getItem().getForecasts()) {
            if (data.equals(dia.getDate())) {
                this.tempMin = dia.getLow();
                this.tempMax = dia.getHigh();
                this.descricao = dia.getText();
                break;
            }
        }
    }
    
    private String getWOEID(String cidade) throws IOException {
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20geo.places%20where%20text%3D%" + cidade + "%22%20AND%20placeTypeName.code%20%3D%207&format=json&diagnostics=true&callback=";
        URL requestUrl;
        requestUrl = new URL(url);
        
        // Make the web request
        URLConnection conn = requestUrl.openConnection();
        InputStream inStream = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
        String inputLine, output = "";
        
        while((inputLine = br.readLine()) != null)
        {
            output += inputLine;
        }
        
        br.close();
        inStream.close();
        JSONObject obj = new JSONObject(output);
        JSONArray arrRes = obj.getJSONObject("query").getJSONObject("results").getJSONArray("place");
        Integer woeid = arrRes.getJSONObject(0).getInt("woeid");
        output = woeid.toString();       
        
        return output;        
    }

    public YahooWeatherService getService() {
        return this.service;
    }

    public Channel getResult() {
        return this.result;
    }

    public int getTempMin() {
        return this.tempMin;
    }

    public int getTempMax() {
        return this.tempMax;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return "UserWeather{" + "tempMin=" + tempMin + ", tempMax=" + tempMax + ", descricao=" + descricao + '}';
    }

    
    
    
}

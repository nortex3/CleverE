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
import java.io.IOException;
import javax.xml.bind.JAXBException;

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
    
    public UserWeather(String woeid, String data) throws JAXBException, IOException {
        this.service = new YahooWeatherService();
        this.result = service.getForecast(woeid, DegreeUnit.CELSIUS);
        for (Forecast dia : this.result.getItem().getForecasts()) {
            if (data.equals(dia.getDate())) {
                this.tempMin = dia.getLow();
                this.tempMax = dia.getHigh();
                this.descricao = dia.getText();
                break;
            }
        }
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

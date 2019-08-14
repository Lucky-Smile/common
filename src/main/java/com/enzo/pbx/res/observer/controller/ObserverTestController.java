package com.enzo.pbx.res.observer.controller;

import com.enzo.pbx.res.observer.domain.WeatherDataModel;
import com.enzo.pbx.res.observer.service.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:43
 * Company: Zoom
 */

@RestController
public class ObserverTestController {

	@Autowired
	private Weather weather;

	@PostMapping(value = "/weather/set")
	public void setWeather(){
		WeatherDataModel weatherDataModel = new WeatherDataModel();

		weatherDataModel.setTemperature(22f);
		weatherDataModel.setHumidity(0.8f);
		weatherDataModel.setPressure(1.2f);

		weatherDataModel.setForecastTemperatures(new ArrayList<>());
		weatherDataModel.getForecastTemperatures().add(22f);
		weatherDataModel.getForecastTemperatures().add(23f);
		weatherDataModel.getForecastTemperatures().add(27f);

		weather.measurementChanged(weatherDataModel);
	}
}

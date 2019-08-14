package com.enzo.pbx.res.observer.domain;

import java.util.List;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:34
 * Company: Zoom
 */
public class WeatherDataModel {
	float temperature;
	float humidity;
	float pressure;

	List<Float> forecastTemperatures;

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public List<Float> getForecastTemperatures() {
		return forecastTemperatures;
	}

	public void setForecastTemperatures(List<Float> forecastTemperatures) {
		this.forecastTemperatures = forecastTemperatures;
	}
}

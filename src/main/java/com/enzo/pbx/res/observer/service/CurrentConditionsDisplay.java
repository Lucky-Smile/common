package com.enzo.pbx.res.observer.service;

import com.enzo.pbx.res.observer.annotation.Observer;
import com.enzo.pbx.res.observer.domain.WeatherDataModel;
import org.springframework.stereotype.Service;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:36
 * Company: Zoom
 */
@Service
public class CurrentConditionsDisplay {

	@Observer("weatherChanged")
	public void currentConditions(WeatherDataModel weatherDataModel) {
		System.out.println("温度: " + weatherDataModel.getTemperature());
		System.out.println("湿度: " + weatherDataModel.getHumidity());
		System.out.println("气压: " + weatherDataModel.getPressure());
	}
}

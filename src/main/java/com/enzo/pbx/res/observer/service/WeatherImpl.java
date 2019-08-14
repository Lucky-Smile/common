package com.enzo.pbx.res.observer.service;

import com.enzo.pbx.res.observer.annotation.Subject;
import com.enzo.pbx.res.observer.domain.WeatherDataModel;
import org.springframework.stereotype.Service;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:35
 * Company: Zoom
 */
@Service
public class WeatherImpl implements Weather {

	@Override
	@Subject("weatherChanged")
	public WeatherDataModel measurementChanged(WeatherDataModel weatherDataModel) {
		System.out.println("weather changed: ");
		return weatherDataModel;
	}
}

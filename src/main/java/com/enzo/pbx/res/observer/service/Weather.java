package com.enzo.pbx.res.observer.service;

import com.enzo.pbx.res.observer.domain.WeatherDataModel;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 18:11
 * Company: Zoom
 */
public interface Weather {

	WeatherDataModel measurementChanged(WeatherDataModel weatherDataModel);
}

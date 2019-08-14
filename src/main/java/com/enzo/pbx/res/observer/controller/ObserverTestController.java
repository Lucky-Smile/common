package com.enzo.pbx.res.observer.controller;

import com.enzo.pbx.res.observer.ObserverHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/13 17:43
 * Company: Zoom
 */

@RestController
public class ObserverTestController {

	@Autowired
	private ObserverHelper observerHelper;

	@PostMapping(value = "/extension/update/number")
	public void updateExtensionNumber(){
		observerHelper.sendAllEvent("enzo", "yang", "123123");
	}
}

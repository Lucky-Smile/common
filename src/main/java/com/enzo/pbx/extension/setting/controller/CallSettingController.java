package com.enzo.pbx.extension.setting.controller;

import com.enzo.pbx.extension.setting.domain.CallSetting;
import com.enzo.pbx.extension.setting.service.ExtensionSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:32
 * Company: Zoom
 */
@RestController
public class CallSettingController {

	private static final Logger logger = LoggerFactory.getLogger(CallSettingController.class);

	@Autowired
	private ExtensionSettingService extensionSettingService;

	@GetMapping(value = "/extension/setting/get")
	public ResponseEntity<CallSetting> getCallSetting(){
		CallSetting callSetting = extensionSettingService.getCallSetting("le", "yang", "default");
		return new ResponseEntity<>(callSetting, HttpStatus.OK);
	}

	@PostMapping(value = "/extension/setting/put")
	public ResponseEntity<Void> putCallSetting(){

		return new ResponseEntity<>(HttpStatus.OK);
	}
}

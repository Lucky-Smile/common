package com.enzo.pbx.extension.setting.service;

import com.enzo.pbx.extension.setting.ExtensionSettingHandlerContext;
import com.enzo.pbx.extension.setting.annotation.MethodAround;
import com.enzo.pbx.extension.setting.domain.CallSetting;
import com.enzo.pbx.extension.setting.handler.AbstractExtensionSettingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:37
 * Company: Zoom
 */
@Service
public class ExtensionSettingServiceIml implements ExtensionSettingService {

	private static final Logger logger = LoggerFactory.getLogger(ExtensionSettingServiceIml.class);

	@Autowired
	private ExtensionSettingHandlerContext extensionSettingHandlerContext;

	@Override
	@MethodAround
	public CallSetting getCallSetting(String accountId, String extensionId, String settingKey) {
		logger.debug("Get extension setting, accountId: {}, extensionId: {}, settingKey: {}", accountId, extensionId, settingKey);
		AbstractExtensionSettingHandler settingHandler = extensionSettingHandlerContext.getSettingHandler(settingKey);
		return settingHandler.getCallSetting(accountId, extensionId, settingKey);
	}
}

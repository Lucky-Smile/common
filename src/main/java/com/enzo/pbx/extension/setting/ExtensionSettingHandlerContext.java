package com.enzo.pbx.extension.setting;

import com.enzo.pbx.extension.setting.handler.AbstractExtensionSettingHandler;

import java.util.Map;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:52
 * Company: Zoom
 */

public class ExtensionSettingHandlerContext {

	private Map<String, AbstractExtensionSettingHandler> settingHandlerMap;

	public ExtensionSettingHandlerContext(Map<String, AbstractExtensionSettingHandler> settingHandlerMap){
		this.settingHandlerMap = settingHandlerMap;
	}

	public AbstractExtensionSettingHandler getSettingHandler(String settingKey){
		AbstractExtensionSettingHandler handler = settingHandlerMap.get(settingKey);
		if (handler == null){
			throw new IllegalArgumentException("Invalid input setting key: "+settingKey);
		}
		return handler;
	}
}

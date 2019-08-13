package com.enzo.pbx.extension.setting.handler;

import com.enzo.pbx.extension.setting.domain.CallSetting;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 17:14
 * Company: Zoom
 */
public abstract class AbstractExtensionSettingHandler implements ExtensionSettingHandler{

	@Override
	public CallSetting getCallSetting(String accountId, String extensionId, String settingKey){
		return null;
	}
}

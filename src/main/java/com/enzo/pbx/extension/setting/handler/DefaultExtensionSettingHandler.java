package com.enzo.pbx.extension.setting.handler;

import com.enzo.pbx.extension.setting.annotation.SettingProperties;
import com.enzo.pbx.extension.setting.domain.CallSetting;
import org.springframework.stereotype.Component;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:55
 * Company: Zoom
 */
@Component
@SettingProperties
public class DefaultExtensionSettingHandler extends AbstractExtensionSettingHandler {

	@Override
	public CallSetting getCallSetting(String accountId, String extensionId, String settingKey) {
		CallSetting callSetting = new CallSetting();
		callSetting.setAccountId(accountId);
		callSetting.setExtensionId(extensionId);
		callSetting.setSettingKey(settingKey);
		callSetting.setSettingValue("default");
		return callSetting;
	}
}

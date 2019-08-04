package com.enzo.pbx.extension.setting.service;

import com.enzo.pbx.extension.setting.domain.CallSetting;

/**
 * @author: lorenzo
 * Date: Created in 2019/8/4 16:37
 * Company: Zoom
 */
public interface ExtensionSettingService {

	CallSetting getCallSetting(String accountId, String extensionId, String settingKey);
}

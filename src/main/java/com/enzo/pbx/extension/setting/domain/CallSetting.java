package com.enzo.pbx.extension.setting.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Li Niu
 * @since 03/05/2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallSetting {

    private String callSettingId;

    private String accountId;

    private String userId;

    private String extensionId;

    private String settingKey;

    private String settingValue;

    private String settingValueName;

    private String settingValuePath;

    public CallSetting() {
    }

    public CallSetting(String settingValue) {
        this.settingValue = settingValue;
    }

    public String getSettingValueName() {
        return settingValueName;
    }

    public void setSettingValueName(String settingValueName) {
        this.settingValueName = settingValueName;
    }

    public String getSettingValuePath() {
        return settingValuePath;
    }

    public void setSettingValuePath(String settingValuePath) {
        this.settingValuePath = settingValuePath;
    }

    public String getCallSettingId() {
        return callSettingId;
    }

    public void setCallSettingId(String callSettingId) {
        this.callSettingId = callSettingId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    @Override
    public String toString() {
        return "CallSetting{" +
                "callSettingId='" + callSettingId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", userId='" + userId + '\'' +
                ", extensionId='" + extensionId + '\'' +
                ", settingKey='" + settingKey + '\'' +
                ", settingValue='" + settingValue + '\'' +
                ", settingValueName='" + settingValueName + '\'' +
                ", settingValuePath='" + settingValuePath + '\'' +
                '}';
    }
}

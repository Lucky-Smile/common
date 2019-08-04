package com.enzo.pbx.extension.setting.enums;

public enum CallSettingKeys {
    // #{key_name_in_database} (#{name_in_URL})
    // To add new setting features, just need to add pairs in this enum class
    CALLER_ID_NUMBER("caller_id_number"),
    RING_TYPE("ringType"),
    BUSINESS_HOUR_ACTION("business_hour_action"),
    CLOSE_HOUR_ACTION("close_hour_action"),
    CLOSE_HOUR_ACTION_ARGS("close_hour_action_args"),
    TWENTY_FOUR_SEVEN("twenty_four_seven"),
    CUSTOMIZED_BUSINESS_HOUR("customized_business_hour"),
    TIMEZONE("timezone"),
    LANGUAGE("language"),
    AUDIO_LANGUAGE("audio_language"),
    CLOSE_HOUR_ACTION_MESSAGE("close_hour_action_message"),
    // support close hour voicemail greeting voice
    CLOSE_HOUR_ACTION_VOICEMAIL("close_hour_action_voicemail"),
    AREA_CODE("area_code"),
    COUNTRY("country"),
    SECURITY_QUESTION("security_question"),
    VOICE_GREETING("voice_greeting"),
    EMERGENCY_ADDRESS("emergency_address"),
    USER_ON_HOLD_VOICE("user_on_hold_music"),
    USER_DATE_FORMAT("user_date_format"),
    USER_HOUR_SYSTEM("user_time_12_24"),
    PMI("pmi"),
    LINE_KEY_ORDER("line_key_order");

    private String key;

    CallSettingKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

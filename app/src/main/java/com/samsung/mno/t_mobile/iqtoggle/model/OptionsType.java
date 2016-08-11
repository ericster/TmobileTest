package com.samsung.mno.t_mobile.iqtoggle.model;

/**
 * Created by me.jung on 8/8/16.
 */
public enum OptionsType
{

    PHONE_PERMISSION("phone_permission"),
    DIAGNOSTICS("diagnostics"),
    LOCATION_PERMISSION("location_permission"),
    SMS_PERMISSION("sms_permission"),
    ISSUE_ASSIST("assist"),
    SPECIAL_OFFERS("offers");

    private final String optionName;

    private OptionsType(String str) {
        this.optionName = str;
    }

    public final String getScreenName() {
        return this.optionName;
    }
}


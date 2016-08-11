package com.samsung.mno.t_mobile.iqtoggle.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by me.jung on 8/8/16.
 */
public class SimHelper {
    public static boolean isSimReady(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == TelephonyManager.SIM_STATE_READY;
    }
}

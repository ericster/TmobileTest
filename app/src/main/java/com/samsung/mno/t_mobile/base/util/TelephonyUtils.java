package com.samsung.mno.t_mobile.base.util;

import android.util.Log;

/**
 * Created by me.jung on 8/8/16.
 */
public class TelephonyUtils {
    public static boolean isTMobileSim(){
            final String simOperator = "310260";
            if ("310260".equals(simOperator) || "310160".equals(simOperator) || "310200".equals(simOperator) || "310210".equals(simOperator)
            || "310220".equals(simOperator) || "310230".equals(simOperator) || "310240".equals(simOperator) || "310250".equals(simOperator)
            || "310270".equals(simOperator) || "310300".equals(simOperator) || "310310".equals(simOperator) || "310490".equals(simOperator)
            || "310580".equals(simOperator) || "310660".equals(simOperator) || "310800".equals(simOperator))
            return true;
            return false;

            }
    }

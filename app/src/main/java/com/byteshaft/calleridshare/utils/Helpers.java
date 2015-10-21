package com.byteshaft.calleridshare.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import static android.content.Context.TELEPHONY_SERVICE;

public class Helpers {

    public static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) AppGlobals.getContext().getSystemService(TELEPHONY_SERVICE);
    }

    public static void sendDataSms(String phoneNumber, String port, String messageText) {
        SmsManager smsManager = getSmsManager();
        Log.i("BinarySMS", getSmsFeedbackFormattedMessage(phoneNumber, port, messageText));
        smsManager.sendDataMessage(
                phoneNumber, null, Short.valueOf(port), messageText.getBytes(), null, null
        );
    }

    public static SharedPreferences getPreferenceManager() {
        return PreferenceManager.getDefaultSharedPreferences(AppGlobals.getContext());
    }

    private static SmsManager getSmsManager() {
        return SmsManager.getDefault();
    }

    private static String getSmsFeedbackFormattedMessage(String number, String port,
                                                         String command) {

        return String.format(
                "Sending data SMS \"%s\" to %s on port number: %s",
                command, number, String.valueOf(port)
        );
    }

    public static String getNumber() {
        SharedPreferences sharedPreferences = getPreferenceManager();
        return sharedPreferences.getString("phone_number", "+32475498297");
    }
}

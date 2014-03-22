package com.eincs.android.receiptholder.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * SMS가 도착하면 받은 SMS 데이터를 수신하여 처리를 하는 BoradcastReciever구현체
 */
public class SMSReceiver extends BroadcastReceiver {
    public static final String SMS_RECV = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECV)) {

        }
    }
}

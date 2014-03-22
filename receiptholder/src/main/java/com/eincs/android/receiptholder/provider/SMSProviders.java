package com.eincs.android.receiptholder.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.eincs.android.receiptholder.model.RSmsMessage;
import com.google.common.collect.Lists;

import java.util.List;

public final class SMSProviders {
    private static final Uri SMS_URI = Uri.parse("content://sms");

    private SMSProviders() {}

    /**
     * 핸드폰에 저장된 모든 SMS를 가져온다.
     */
    public static List<RSmsMessage> querySMS(Context context) {
        return querySMS(context, 0);
    }

    /**
     * 핸드폰에 저장된 SMS 중 until에 표시된 시간에 받은 SMS까지만 가져온다.
     */
    public static List<RSmsMessage> querySMS(Context context, long until) {
        ContentResolver cr = context.getContentResolver();
        List<RSmsMessage> result = Lists.newArrayList();
        Cursor c = cr.query(SMS_URI, new String[] { "_id", "thread_id", "address", "person", "date", "body" }, null, null, "date desc");
        try {
            while (c.moveToNext()) {
                long id = c.getLong(0);
                long threadId = c.getLong(1);
                String sender = c.getString(2);
                long contactId = c.getLong(3);
                long recieved = c.getLong(4);
                String body = c.getString(5);

                if (recieved < until) {
                    break;
                }

                RSmsMessage message = new RSmsMessage();
                message.setId(id);
                message.setThreadId(threadId);
                message.setSender(sender);
                message.setContactId(contactId);
                message.setRecieved(recieved);
                message.setBody(body);
                result.add(message);
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                // close cursor silently
            }
        }
        return result;
    }
}

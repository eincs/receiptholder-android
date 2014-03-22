package com.eincs.android.receiptholder.parser;

import android.util.Log;
import com.eincs.android.receiptholder.model.RSmsMessage;
import com.eincs.android.receiptholder.model.RTransaction;

import java.util.StringTokenizer;

public final class SmsParsers {
    private SmsParsers() {}

    /**
     * {@link RSmsMessage} 인스턴스를 받아 {@link RTransaction}로 파싱한다.
     * 카드사로부터 온 메시지라면, 적절하게 파싱을 하지만, 그렇지 않으면 null을 리턴한다.
     */
    public static RTransaction toTransaction(RSmsMessage message) {
        boolean isTransactionalSms = CardDescriber.isCardSender(message.getSender());
        if (!isTransactionalSms) {
            return null;
        }
        try {
            CardDescriber cardDescriber = CardDescriber.getBySender(message.getSender());
            return cardDescriber.getSmsParser().parse(message);
        } catch (Exception e) {
            Log.e("SmsParsers", e.getMessage(), e);
            return null;
        }
    }
}

package com.eincs.android.receiptholder.parser;

import com.eincs.android.receiptholder.model.RCurrency;
import com.eincs.android.receiptholder.model.RSmsMessage;
import com.eincs.android.receiptholder.model.RTransaction;
import com.eincs.android.receiptholder.utils.Calendars;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * 삼성카드에서 온 메시지를 파싱한다.
 * 다음과 같은 메시지 포맷을 파싱할 수 있다.
 *
 * <pre>
 * 삼성카드승인이정*님
 * 03/14 13:53
 * 8,500원
 * 일시불
 * 와비사비
 * 누적xxx,xxx원
 * </pre>
 */
public class SamsungCardSmsParser implements SmsParser {

    @Override
    public RTransaction parse(RSmsMessage message) {
        StringTokenizer tokenizer = new StringTokenizer(message.getBody(), "/n");
        tokenizer.nextToken();
        tokenizer.nextToken();
        String amount = tokenizer.nextToken();
        amount = amount.trim();
        amount = amount.replace(",", "");
        amount = amount.replace("원", "");
        tokenizer.nextToken();
        String store = tokenizer.nextToken();
        store = store.trim();

        Calendar calendar = Calendars.forTime(message.getRecieved());
        RTransaction transaction = new RTransaction();
        transaction.setCard("삼성카드");
        transaction.setYear(Integer.toString(calendar.get(Calendar.YEAR)));
        transaction.setMonth(Integer.toString(calendar.get(Calendar.MONTH)) + 1);
        transaction.setDate(Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
        transaction.setTimemillis(message.getRecieved());
        transaction.setCurrency(RCurrency.KRW);
        transaction.setStore(store);
        transaction.setAmount(Integer.parseInt(amount));
        transaction.setSmsBody(message.getBody());
        return transaction;
    }
}

package com.eincs.android.receiptholder.parser;

import com.eincs.android.receiptholder.model.RCurrency;
import com.eincs.android.receiptholder.model.RSmsMessage;
import com.eincs.android.receiptholder.model.RTransaction;
import com.eincs.android.receiptholder.utils.Calendars;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * 삼성카드에서 온 해외결제 메시지를 파싱한다.
 * 다음과 같은 메시지 포맷을 파싱할 수 있다.
 *
 * <pre>
 * 삼성카드
 * 해외승인
 * 03/21 11:06
 * APPLE ITUNES STORE USD
 * USD 1.00
 * 감사합니다
 * </pre>
 */
public class SamsungCardOverseasSmsParser implements SmsParser {

    @Override
    public RTransaction parse(RSmsMessage message) {
        StringTokenizer tokenizer = new StringTokenizer(message.getBody(), "/n");
        tokenizer.nextToken();
        tokenizer.nextToken();
        String amount = tokenizer.nextToken();
        amount = amount.replace(".", "");
        amount = amount.replace("USD", "");
        amount = amount.trim();
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
        transaction.setCurrency(RCurrency.USD);
        transaction.setStore(store);
        transaction.setAmount(Integer.parseInt(amount));
        transaction.setSmsBody(message.getBody());
        return transaction;
    }
}

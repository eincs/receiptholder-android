package com.eincs.android.receiptholder.parser;

import com.eincs.android.receiptholder.model.RSmsMessage;
import com.eincs.android.receiptholder.model.RTransaction;

/**
 * 특정 SMS에 대해 피상하여 RTransaction을 만들어낸다.
 * 각 카드사의 포맷에 따라 파싱하는 구현체를 만들어 CardDesriber에 등록하면 SmsParsers의 메소드에서 이를 참조하여 메시지를 파싱한다.
 */
public interface SmsParser {
    public RTransaction parse(RSmsMessage message) throws Exception;
}

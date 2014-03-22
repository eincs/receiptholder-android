package com.eincs.android.receiptholder.parser;

import com.eincs.android.receiptholder.model.RSmsMessage;
import com.eincs.android.receiptholder.model.RTransaction;

public interface SmsParser {
    public RTransaction parse(RSmsMessage message) throws Exception;
}

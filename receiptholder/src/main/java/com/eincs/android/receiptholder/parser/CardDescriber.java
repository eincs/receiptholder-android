package com.eincs.android.receiptholder.parser;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

public enum CardDescriber {
    HANA_SK_CHECK_CARD("15991155", new HanaSkCheckCardSmsParser()),
    SAMSUNG_CARD("15888900", new SamsungCardSmsParser()),
    SAMSUNG_CHARD_OVERSEAS("20008100", new SamsungCardOverseasSmsParser());

    public static Map<String, CardDescriber> VALUES_BY_SENDERS;
    static {
        Map<String, CardDescriber> senderMap = Maps.newHashMap();
        for (CardDescriber describer : values()) {
            senderMap.put(describer.getSender(), describer);
        }
        VALUES_BY_SENDERS = Collections.unmodifiableMap(senderMap);
    }

    public static boolean isCardSender(final String sender) {
        return Iterables.any(VALUES_BY_SENDERS.keySet(), new Predicate<String>() {
            @Override
            public boolean apply(String sederInCardSenders) {
                return sender.contains(sederInCardSenders);
            }
        });
    }

    public static CardDescriber getBySender(String sender) {
        return VALUES_BY_SENDERS.get(sender);
    }

    private final String sender;
    private final SmsParser smsParser;

    CardDescriber(String sender, SmsParser smsParser) {
        this.sender = sender;
        this.smsParser = smsParser;
    }

    public String getSender() {
        return sender;
    }

    public SmsParser getSmsParser() {
        return smsParser;
    }
}

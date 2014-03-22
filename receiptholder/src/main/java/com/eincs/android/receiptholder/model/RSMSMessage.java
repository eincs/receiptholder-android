package com.eincs.android.receiptholder.model;

public class RSmsMessage {

    private long id;
    private long threadId;
    private String sender;
    private long contactId;
    private long recieved;
    private String body;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getRecieved() {
        return recieved;
    }

    public void setRecieved(long recieved) {
        this.recieved = recieved;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

package com.codegym.model;

public class Email {
    private String language;
    private int size;
    private boolean spamFilter;
    private String signature;

    public Email() {
        this.language = "English";
        this.size = 5;
        this.spamFilter = false;
        this.signature = signature;
    }

    public Email(String language, int size, boolean spamFilter, String signature) {
        this.language = language;
        this.size = size;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

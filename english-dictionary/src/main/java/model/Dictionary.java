package model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();

    public Dictionary() {
        this.dictionary = dictionary;
        dictionary.put("hello","xin chào");
        dictionary.put("table","cái bàn");
    }
    
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}

package com.beta.replyservice.service;

import com.beta.replyservice.dto.ReplyMessage;
import com.beta.replyservice.rules.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class StringReplyService {
    private static RuntimeException exception =new RuntimeException("Invalid input");

    /**
     * This bean is defined in RestServiceApplication.java
     */
    @Autowired
    private Map<Character, Rule> rules;

    public ReplyMessage prepareMessage(String input) {
        String[] str = input.split("-");
        if(str.length < 2){
            throw exception;
        }
        String rulesToBeExecuted = str[0];
        String message = str[1];
        for(int i=0; i< rulesToBeExecuted.length(); i++){
            Rule rule = rules.get(rulesToBeExecuted.charAt(i));
            if (rule != null) {
                message = rule.executeRule(message);
            }else{
                throw exception;
            }
        }
        return new ReplyMessage(message);
    }
}
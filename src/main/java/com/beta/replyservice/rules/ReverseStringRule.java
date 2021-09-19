package com.beta.replyservice.rules;

import org.springframework.stereotype.Service;

@Service
public class ReverseStringRule implements Rule {

	@Override
	public String executeRule(String str){
		if(str == null){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for(int i= str.length()-1;i>=0; i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	@Override
	public Character getType() {
		return '1';
	}
}
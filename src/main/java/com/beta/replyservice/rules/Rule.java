package com.beta.replyservice.rules;

/*
* Every tme when new rule to be added, just create ne implementation class this interface.
* Rest of the things will be handled by application
* */
public interface Rule {
	 String executeRule(String str);
	 Character getType();
}
package com.beta.replyservice;

import com.beta.replyservice.rules.Rule;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
	/*
	 * collects all the implemented
	 * */
	@Autowired
	private List<Rule> rules;

	/*
	*  map all implemented rules with identity number
	* */
	@Bean
	public Map<Character, Rule> rulesMap() {
		Map<Character, Rule> rulesMap = new HashMap<>();
		for (Rule rule : rules) {
			rulesMap.put(rule.getType(), rule);
		}
		return rulesMap;
	}
}

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
	/**
	 * collects all the implemented Rules
	 * */
	@Autowired
	private List<Rule> rules;

	/**
	*  Map all implemented rules with identity number/character.
	 *  So whenever new rule needs to be implemented just implement Rule interface
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

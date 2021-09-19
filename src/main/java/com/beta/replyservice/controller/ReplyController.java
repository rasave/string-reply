package com.beta.replyservice.controller;

import com.beta.replyservice.dto.ReplyMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.beta.replyservice.service.*;
@RestController
public class ReplyController {

	@Autowired
	private StringReplyService stringReplyService;

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ResponseEntity<Object> replying(@PathVariable String message) {
		try{
			return ResponseEntity.ok(stringReplyService.prepareMessage(message));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
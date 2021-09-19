package com.beta.replyservice;


import com.beta.replyservice.service.StringReplyService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringReplyServiceTest {
    @Autowired
    private StringReplyService stringReplyService;

    @Test
    public void testReverseStringRule(){
        assertThat(stringReplyService.prepareMessage("1-hello").getMessage()).contains("olleh");
        assertThat(stringReplyService.prepareMessage("11-hello").getMessage()).contains("hello");
    }

    @Test
    public void testMD5EncodeRule(){
        assertThat(stringReplyService.prepareMessage("2-hello").getMessage()).contains("5d41402abc4b2a76b9719d911017c592");
        assertThat(stringReplyService.prepareMessage("112-hello").getMessage()).contains("5d41402abc4b2a76b9719d911017c592");
    }

    @Test
    public void testInvalidInput(){
        boolean flag = false;
        try{
            stringReplyService.prepareMessage("hello");
        }catch(Exception e){
            flag = true;
            assertThat(e.getMessage()).contains("Invalid input");
        }
        assertThat(flag).isTrue();
    }
}

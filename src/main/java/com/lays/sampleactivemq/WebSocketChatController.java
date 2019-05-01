package com.lays.sampleactivemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketChatController {

    private static final Logger log = LoggerFactory.getLogger(WebSocketChatController.class);

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/one")
    public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/one")
    public WebSocketChatMessage newUser(@Payload WebSocketChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/sendMessage")
    @SendTo("topic/global")
    public SampleChatMessage reply(SampleChatMessage incoming) throws Exception {

        incoming.setWhen(System.currentTimeMillis());
        log.info("incoming " + incoming.toString());

        SampleChatMessage msg = new SampleChatMessage();
        msg.setWho(HtmlUtils.htmlEscape("winston.lays@gmail.com"));
        msg.setWhat(HtmlUtils.htmlEscape("HELLO WORLD"));
        msg.setWhen(System.currentTimeMillis());
        msg.setScope(Long.valueOf(0));
        return msg;
    }
}

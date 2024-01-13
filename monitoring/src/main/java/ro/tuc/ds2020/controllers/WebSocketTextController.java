package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2020.dtos.TextMessage;

@RestController
public class WebSocketTextController {

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody TextMessage textMessageDTO) {
        template.convertAndSend("/topic/message", textMessageDTO);
        System.out.println("buna  i saic ");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload TextMessage textMessageDTO) {
        // receive message from client
    }


    @SendTo("/topic/message")
    public TextMessage broadcastMessage(@Payload TextMessage textMessageDTO) {
        return textMessageDTO;
    }
}

package com.example.rabbitmq.Controller;

import com.example.rabbitmq.Dto.MessageDto;
import com.example.rabbitmq.Service.MessageService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageController {

    @Resource
    private final MessageService messageService;


    /**
     * Queue로 메시지를 발행
     *
     * @param messageDto 발행할 메시지의 DTO 객체
     * @return ResponseEntity 객체로 응답을 반환
     */
    @RequestMapping(value = "/send/message", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto);
        //messageService.sendMessage(messageDto);
        return ResponseEntity.ok("Message sent to RabbitMQ!");
    }
}
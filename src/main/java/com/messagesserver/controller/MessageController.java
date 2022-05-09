package com.messagesserver.controller;

import com.messagesserver.model.Message;
import com.messagesserver.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
class MessageController {

    @Autowired
    MessageRepository repository;

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAll() {
        return new ResponseEntity<>(repository.findAllBy(), HttpStatus.OK);

    }

    @PostMapping("/message")
    public ResponseEntity<Message> newMessage(@RequestBody Message newMessage) {
        System.out.println("asdasd");
        return new ResponseEntity<>(repository.save(newMessage), HttpStatus.CREATED);
    }


    @GetMapping("/messages/{id}")
    public Message oneMessage(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    @PutMapping("/message/{id}")
    public Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {

        return repository.findById(id)
                .map(Message -> {
                    Message.setContent(newMessage.getContent());
                    return repository.save(Message);
                })
                .orElseGet(() -> {
                    newMessage.setId(id);
                    return repository.save(newMessage);
                });
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
package com.messagesserver.controller;

import com.messagesserver.model.Message;
import com.messagesserver.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
class MessageController {

    @Autowired
    MessageRepository repository;

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAll() {
        System.out.println("asdasd");
        return new ResponseEntity<>(repository.findAllBy(), HttpStatus.OK);

    }
    // end::get-aggregate-root[]

    @PostMapping("/message")
    public Message newMessage(@RequestBody Message newMessage) {
        return repository.save(newMessage);
    }

    // Single item

    @GetMapping("/messages/{id}")
    public Message one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    @PutMapping("/message/{id}")
    public Message replaceEmployee(@RequestBody Message newMessage, @PathVariable Long id) {

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
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
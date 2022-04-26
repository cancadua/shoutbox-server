package com.messagesserver.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "login")
    private String login;
    @Column(name = "date")
    private Date date;

    public Message() {}

    public Message(String content, String login) {
        this.content = content;
        this.login = login;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.content, this.login, this.date);
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + this.id + ", name='" + this.content + '\'' + ", login='" + this.login + '\'' + ", date='" + this.date + '\'' + '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    void date() {
        this.date = new Date();
    }
}
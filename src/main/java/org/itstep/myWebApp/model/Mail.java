package org.itstep.myWebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "mails")
public class Mail extends BaseEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "to")
    private String to; // email

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "userId")
    private Integer userId; // owner

    public Mail() {
    }

    public Mail(Integer id, String name, String text, String to, LocalDateTime created, Integer userId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.to = to;
        this.created = created;
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "text='" + text + '\'' +
                ", to='" + to + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                "}";
    }
}

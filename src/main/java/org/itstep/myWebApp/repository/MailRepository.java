package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.Mail;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MailRepository {

    Map<Integer, Mail> mails = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    {
        save(new Mail("text1", "text1", "to1", LocalDateTime.now(), 1));
        save(new Mail("text2", "text2", "to2", LocalDateTime.now(), 2));
        save(new Mail("text3", "text3", "to3", LocalDateTime.now(), 3));
        save(new Mail("text4", "text4", "to4", LocalDateTime.now(), 1));
    }

    public void save(Mail mail) {
        if (mail.getId() == null) {
            mail.setId(counter.getAndIncrement());
        }

        mails.put(mail.getId(), mail);
    }

    public List<Mail> getAll(Integer userId) {
        List<Mail> mailList = new ArrayList<>(mails.size());

        for (Mail mail : mails.values()) {
            if (mail.getUserId().equals(userId)) {
                mailList.add(mail);
            }
        }

        return mailList;
    }

    public void deleteAll(Integer userId) {
        getAll(userId).remove(userId);
    }

    public void delete(Integer id, Integer userId) {
        getAll(userId).remove(id);
    }

    public Mail getById(Integer id, Integer userId) {
        return getAll(userId).get(id);
    }

}

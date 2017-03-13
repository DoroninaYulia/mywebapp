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
    //private Map<Integer, Map<Integer, Mail>> mails = new ConcurrentHashMap<>();
    private Map<Integer, Mail> mails = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    {
        save(new Mail("name_1", "text_1", "to_1", LocalDateTime.now(), 1));
        save(new Mail("name_2", "text_2", "to_2", LocalDateTime.now(), 2));
        save(new Mail("name_3", "text_3", "to_3", LocalDateTime.now(), 2));
        save(new Mail("name_4", "text_4", "to_4", LocalDateTime.now(), 2));
        save(new Mail("name_5", "text_5", "to_5", LocalDateTime.now(), 3));
    }

    public List<Mail> getAll() {
        return new ArrayList<>(mails.values());
    }

    private void addMail(Mail mail){
        mails.put(mail.getUserId(), mail);
    }

    public List<Mail> getAll(Integer someId) {
        List<Mail> mailList = new ArrayList<>(mails.size());

        for(Mail m: mails.values()){
            if(m.getUserId().equals(someId)){
                mailList.add(m);
            }
        }
        return mailList;
    }

    public void deleteAll(Integer someId){
        getAll(someId).remove(someId);
    }

    public void delete(Integer id) {
        mails.remove(id);
    }


    public void save(Mail mail) {
        if (mail.getId() == null) {
            mail.setId(counter.getAndIncrement());
        }

        //Map<Integer, Mail> map = mails.computeIfAbsent(mail.getId(), ConcurrentHashMap<Integer, Mail>::new);
        mails.put(mail.getId(), mail);
    }

}

package org.itstep.myWebApp.service;


import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.repository.MailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    private MailRepository repository;

    public MailService(MailRepository repository) {
        this.repository = repository;
    }

    public List<Mail> getAll(Integer someId) {
        return repository.getAll(someId);
    }

    public void deleteAll(Integer someId){
        repository.deleteAll(someId);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

 /*   public List<Mail> getAll(Integer userId) {
        return repository.getAll(userId);
    }*/
    //public List<Mail> searchListMail(Integer userId, Mail mail){return repository.searchListMail(userId, mail);}

/*    public void delete(Integer userId) {
        repository.delete(userId);
    }

    public void save(Mail mail) {
        repository.save(mail);
    }*/
}

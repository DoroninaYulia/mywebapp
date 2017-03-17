package org.itstep.myWebApp.service;


import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailRepository repository;

    public void save(Mail mail) {
        repository.save(mail);
    }

    public List<Mail> getAll(Integer userId) {
        return repository.getAll(userId);
    }

    public void deleteAll(Integer userId) {
        repository.deleteAll(userId);
    }

    public void delete(Integer id, Integer userId) {
        repository.getById(id, userId);
    }

    public Mail getById(Integer id, Integer userId) {
        return repository.getById(id, userId);
    }

}

package com.codegym.service;

import com.codegym.model.MailboxSettings;
import com.codegym.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MailboxService implements IMailboxService{
    @Autowired
    IMailboxRepository mailboxRepository;

    @Override
    public List<MailboxSettings> findAll() {
        return mailboxRepository.findAll();
    }

    @Override
    public void save(MailboxSettings mailboxSettings) {
        mailboxRepository.save(mailboxSettings);
    }
}

package com.codegym.service;

import com.codegym.model.MailboxSetting;
import com.codegym.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService implements IMailboxService{
    @Autowired
    IMailboxRepository mailboxRepository;

    @Override
    public List<MailboxSetting> findAll() {
        return mailboxRepository.findAll();
    }

    @Override
    public void save(MailboxSetting mailboxSetting) {
        mailboxRepository.save(mailboxSetting);
    }

    @Override
    public MailboxSetting findById(int id) {
        return mailboxRepository.findById(id);
    }

    @Override
    public void editSettings(int id, MailboxSetting mailboxSetting) {
        mailboxRepository.editSettings(id, mailboxSetting);
    }
}

package com.codegym.repository;

import com.codegym.model.MailboxSettings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class MailboxRepository implements IMailboxRepository{
    public static List<MailboxSettings> mailboxSettings = new ArrayList<>();
    static {
        mailboxSettings.add(1, new MailboxSettings("English",10,true,"abc"));
//        mailboxSettings.add(2, new MailboxSettings("Vietnamese",100,false,"bde"));
//        mailboxSettings.add(3, new MailboxSettings("English",25,true,"jgj"));
    }

    @Override
    public List<MailboxSettings> findAll() {
        return mailboxSettings;
    }

    @Override
    public void save(MailboxSettings mailbox) {
        mailboxSettings.add(mailbox);
    }
}

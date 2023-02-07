package com.codegym.repository;

import com.codegym.model.MailboxSetting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository{
    public static List<MailboxSetting> mailboxSettingList = new ArrayList<>();
    static {
        mailboxSettingList.add(new MailboxSetting("English", 25, false, "John"));
    }

    @Override
    public List<MailboxSetting> findAll() {
        return mailboxSettingList;
    }

    @Override
    public void save(MailboxSetting mailboxSetting) {
        mailboxSettingList.add(mailboxSetting);
    }
}

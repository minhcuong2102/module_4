package com.codegym.repository;

import com.codegym.model.MailboxSetting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {
    public static List<MailboxSetting> mailboxSettingList = new ArrayList<>();

    static {
        mailboxSettingList.add(new MailboxSetting(1, "English", 25, false, "John"));
        mailboxSettingList.add(new MailboxSetting(2, "Vietnamese", 50, true, "Cường"));
        mailboxSettingList.add(new MailboxSetting(3, "Chinese", 100, false, "Lee"));
    }

    @Override
    public List<MailboxSetting> findAll() {
        return mailboxSettingList;
    }

    @Override
    public void save(MailboxSetting mailboxSetting) {
        mailboxSettingList.add(mailboxSetting);
    }

    @Override
    public MailboxSetting findById(int id) {
        MailboxSetting mailboxSetting = null;
        for (MailboxSetting mailbox : mailboxSettingList) {
            if (mailbox.getId() == id) {
                mailboxSetting = new MailboxSetting(mailbox.getId(), mailbox.getLanguages(),
                        mailbox.getPageSize(), mailbox.isSpamsFilter(), mailbox.getSignature());
            }
        }
        return mailboxSetting;
    }

    @Override
    public void editSettings(int id, MailboxSetting mailboxSetting) {
        for (MailboxSetting mailbox : mailboxSettingList) {
            if (id == mailbox.getId()){
                mailbox.setLanguages(mailboxSetting.getLanguages());
                mailbox.setPageSize(mailboxSetting.getPageSize());
                mailbox.setSpamsFilter(mailboxSetting.isSpamsFilter());
                mailbox.setSignature(mailboxSetting.getSignature());
            }
        }
    }
}

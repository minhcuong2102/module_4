package com.codegym.repository;

import com.codegym.model.MailboxSetting;

import java.util.List;

public interface IMailboxRepository {
    List<MailboxSetting> findAll();
    void save(MailboxSetting mailboxSetting);
    MailboxSetting findById(int id);
    void editSettings(int id, MailboxSetting mailboxSetting);
}

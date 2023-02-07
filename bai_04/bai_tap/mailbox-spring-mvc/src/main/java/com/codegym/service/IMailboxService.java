package com.codegym.service;

import com.codegym.model.MailboxSetting;

import java.util.List;

public interface IMailboxService {
    List<MailboxSetting> findAll();
    void save(MailboxSetting mailboxSetting);
}

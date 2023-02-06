package com.codegym.service;

import com.codegym.model.MailboxSettings;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IMailboxService {
    List<MailboxSettings> findAll();
    void save(MailboxSettings mailboxSettings);
}

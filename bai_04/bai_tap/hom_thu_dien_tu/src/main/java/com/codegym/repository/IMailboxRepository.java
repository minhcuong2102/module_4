package com.codegym.repository;

import com.codegym.model.MailboxSettings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IMailboxRepository {
    List<MailboxSettings> findAll();
    void save(MailboxSettings mailboxSettings);
}

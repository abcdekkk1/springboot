package com.dns.springboot3.service;

import java.util.List;

import com.dns.springboot3.entities.Contact;

public interface ContactService {

    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Contact findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);

}

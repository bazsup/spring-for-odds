package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogRepository {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog() {

    }
}

package com.codegym.ung_dung_muon_sach.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    private static int count = 0;
    private static int countRentReturn = 0;

    @Pointcut("execution(* com.codegym.ung_dung_muon_sach.controller.BookController.*(..))")
    public void getTimeAccess() {
    }

    @Pointcut("execution(* com.codegym.ung_dung_muon_sach.controller.BookController.rent(..))")
    public void getTimeRent() {
    }

    @Pointcut("execution(* com.codegym.ung_dung_muon_sach.controller.BookController.returnBook(..))")
    public void getTimeReturn() {
    }

    @After(value = "getTimeAccess()")
    public void countTime() {
        count++;
        System.out.println("Thời điểm truy cập: " + count);
    }

    @After(value = "getTimeRent()")
    public void countTimeRent() {
        countRentReturn++;
        System.out.println("Thời điểm mượn hoặc trả sách: " + countRentReturn);
    }

    @After(value = "getTimeReturn()")
    public void countTimeReturn() {
        countRentReturn++;
        System.out.println("Thời điểm mượn hoặc trả sách: " + countRentReturn);
    }
}

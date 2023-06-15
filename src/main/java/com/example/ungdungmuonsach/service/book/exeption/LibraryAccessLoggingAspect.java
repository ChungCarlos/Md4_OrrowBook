package com.example.ungdungmuonsach.service.book.exeption;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryAccessLoggingAspect {
    //Triển khai lớp LibraryAccessLoggingAspect sử dụng Spring AOP để ghi log hành động thay đổi trạng thái sách của thư viện
    @AfterReturning("execution(* com.example.ungdungmuonsach.service.book.impl.BookService.borrowBook(..)) || " +
            "execution(* com.example.ungdungmuonsach.service.book.impl.BookService.returnBook(..))")
    public void logLibraryAction(JoinPoint joinPoint) {
        // Ghi log hành động thay đổi trạng thái sách
        System.out.println("Thay đổi trạng thái sách");
    }
}

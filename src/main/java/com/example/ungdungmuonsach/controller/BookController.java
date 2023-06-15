package com.example.ungdungmuonsach.controller;

import com.example.ungdungmuonsach.model.Books;
import com.example.ungdungmuonsach.service.book.IBookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Controller
public class BookController {
    @Autowired
    private IBookservice iBookservice;

    @GetMapping("/")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listBook", iBookservice.findAll());
        modelAndView.addObject("book", new Books());
        return modelAndView;
    }



    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("book", iBookservice.findById(id).orElse(null));
        return modelAndView; //xem chi tiết
    }

    @PostMapping("/borrow/{id}")
    public ModelAndView borrowBook(@PathVariable Long id) {
        Random random = new Random();
        ModelAndView modelAndView = new ModelAndView("borrow-result");
        Optional<Books> optionalBook = iBookservice.findById(id);
        if (optionalBook.isPresent()) {
            Books book = optionalBook.get();
            if (book.getQuantity() > 0) {
                iBookservice.borrowBook(book);

                long timestamp = Instant.now().toEpochMilli();
                modelAndView.addObject("borrowCode", ((int) (timestamp % 100000) * 100000 + random.nextInt(100000)) % 100000);
                // Tạo mã sách ko trùng nhau có 5 số...
                // Mượn sách thành công...
            } else {
                modelAndView.addObject("borrowCode", "Số lượng sách không đủ");
            }
        } else {
            modelAndView.addObject("borrowCode", "Không tìm thấy sách");
        }
        return modelAndView;
    }

    @PostMapping("/return/{id}") //đổi post và get để kiểm tra exeption
    public ModelAndView returnBook(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("return-result");
        Optional<Books> optionalBook = iBookservice.findById(id);
        if (optionalBook.isPresent()) {
            Books book = optionalBook.get();
            iBookservice.returnBook(book);
            modelAndView.addObject("returnStatus", "Bạn đã trả sách thành công");
        } else {
            modelAndView.addObject("returnStatus", "Không tìm thấy sách");
        }
        return modelAndView;
    }
}

package com.example.springcourse.CRUD2appBoot.exeptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String error) {
        super(error);
    }
}

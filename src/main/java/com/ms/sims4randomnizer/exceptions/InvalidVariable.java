package com.ms.sims4randomnizer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.annotation.HttpConstraint;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidVariable extends Exception{

    public InvalidVariable() {
        super("Invalid variable introduced. Try again.");
    }
}

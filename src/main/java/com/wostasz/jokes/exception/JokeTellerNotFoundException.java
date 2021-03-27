package com.wostasz.jokes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "JokeTeller not found!")
public class JokeTellerNotFoundException extends Exception{
}

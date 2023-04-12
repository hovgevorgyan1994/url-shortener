package com.urlshortener.dataaccess.exception;

import com.urlshortener.exception.BaseException;

public class UrlNotFountException extends BaseException {
    public UrlNotFountException(String message) {
        super(message);
    }
}

package com.urlshortener.application.service.exception;

import com.urlshortener.exception.BaseException;

public class UrlException extends BaseException {
    public UrlException(String message) {
        super(message);
    }
}

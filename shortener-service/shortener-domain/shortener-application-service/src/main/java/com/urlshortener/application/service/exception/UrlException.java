package com.urlshortener.application.service.exception;

import com.urlshortener.common.domain.exception.BaseException;

public class UrlException extends BaseException {
    public UrlException(String message) {
        super(message);
    }
}

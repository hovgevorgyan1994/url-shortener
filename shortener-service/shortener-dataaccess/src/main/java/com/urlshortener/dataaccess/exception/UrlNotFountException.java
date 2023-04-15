package com.urlshortener.dataaccess.exception;

import com.urlshortener.common.domain.exception.BaseException;

public class UrlNotFountException extends BaseException {
    public UrlNotFountException(String message) {
        super(message);
    }
}

package com.urlshortener.event;

public interface DomainEventPublisher<T extends DomainEvent>{
    void publish(T data);
}

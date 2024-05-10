package com.javierdiez.produccion.domian.planosDomain.handler;

public interface DomainEventHandler<T>{
    void handle(T DomainEvent);
}

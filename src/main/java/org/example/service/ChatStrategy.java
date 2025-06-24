package org.example.service;

public interface ChatStrategy {
    String getResponse(String prompt) throws Exception;
}

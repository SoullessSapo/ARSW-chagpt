package org.example.chat;


public interface ChatStrategy {
    String getResponse(String prompt) throws Exception;
}

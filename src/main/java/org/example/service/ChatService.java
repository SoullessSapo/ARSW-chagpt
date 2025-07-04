package org.example.service;

public class ChatService {
    private final ChatStrategy strategy;

    public ChatService() {
        this.strategy = new ChatGPTStrategy();
    }

    public String chat(String prompt) throws Exception {
        return strategy.getResponse(prompt);
    }
}

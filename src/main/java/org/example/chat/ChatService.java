package org.example.chat;

public class ChatService {
    private final ChatStrategy strategy;

    public ChatService(ChatStrategy strategy) {
        this.strategy = strategy;
    }

    public String chat(String prompt) throws Exception {
        return strategy.getResponse(prompt);
    }
}

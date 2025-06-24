package org.example.chat;

public class LoggingDecorator implements ChatStrategy {
    private final ChatStrategy wrapped;

    public LoggingDecorator(ChatStrategy wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getResponse(String prompt) throws Exception {
        System.out.println("Prompt: " + prompt);
        String response = wrapped.getResponse(prompt);
        System.out.println("Response: " + response);
        return response;
    }
}

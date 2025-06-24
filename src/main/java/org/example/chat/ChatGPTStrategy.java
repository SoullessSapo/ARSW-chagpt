package org.example.chat;

public class ChatGPTStrategy implements ChatStrategy {
    private final ChatClientFacade client;

    public ChatGPTStrategy(ChatClientFacade client) {
        this.client = client;
    }

    @Override
    public String getResponse(String prompt) throws Exception {
        String request = new ChatRequestBuilder()
                .withUserMessage(prompt)
                .build();
        return client.sendRequest(request);
    }
}

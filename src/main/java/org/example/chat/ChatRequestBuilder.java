package org.example.chat;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatRequestBuilder {
    private final JSONArray messages = new JSONArray();

    public ChatRequestBuilder withUserMessage(String content) {
        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", content);
        messages.put(message);
        return this;
    }

    public String build() {
        JSONObject json = new JSONObject();
        json.put("model", "gpt-3.5-turbo");
        json.put("messages", messages);
        return json.toString();
    }
}

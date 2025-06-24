package org.example.controller;

import org.example.dto.ChatRequest;
import org.example.dto.ChatResponse;
import org.example.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController() {
        this.chatService = new ChatService(); // Sin inyección por simplicidad
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) throws Exception {
        String response = chatService.chat(request.getPrompt());
        return new ChatResponse(response);
    }
}

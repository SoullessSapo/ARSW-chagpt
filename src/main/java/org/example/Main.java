package org.example;

import org.example.chat.*;

public class Main {
    public static void main(String[] args) {
        try {
            ChatClientFacade client = new ChatClientFacade("TU_API_KEY");
            ChatStrategy strategy = new LoggingDecorator(new ChatGPTStrategy(client));
            ChatService service = new ChatService(strategy);

            String prompt = "¿Cuál es la capital de Japón?";
            String response = service.chat(prompt);

            System.out.println("Respuesta: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

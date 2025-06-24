package org.example.chat;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ChatClientFacade {
    private final String apiKey;

    public ChatClientFacade(String apiKey) {
        this.apiKey = apiKey;
    }

    public String sendRequest(String requestBody) throws IOException {
        URI uri = URI.create("https://api.openai.com/v1/chat/completions");
        URL url = uri.toURL();  // ← Forma moderna y no deprecated

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(requestBody.getBytes());
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }
}

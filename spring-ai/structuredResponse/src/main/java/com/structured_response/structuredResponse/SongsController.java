package com.structured_response.structuredResponse;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SongsController {

    private final ChatClient chatClient;

    public SongsController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/songs")
    public String getSongsByArtists(@RequestParam(value = "artist", defaultValue = "Taylor Swift") String artist) {
        String message = """
                Please give me a list of top 10 songs for the artist {artist}. If you don't know the answer, just say "I don't know"
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("artist", artist));

        Prompt prompt = promptTemplate.create();

        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();

        return response.getResult().toString();

    }

    @GetMapping("/StructuredSongs")
    public Object getStructuredSongsByArtists(
            @RequestParam(value = "artist", defaultValue = "Taylor Swift") String artist) {
        String message = """
                Please give me a list of top 10 songs. If you don't know the answer, just say "I don't know"
                in response key is the name songs and value name of the name artist

                {format}
                """;

        MapOutputConverter mapOutputConverter = new MapOutputConverter();

        PromptTemplate promptTemplate = new PromptTemplate(message,
                Map.of("artist", artist, "format", mapOutputConverter.getFormat()));

        Prompt prompt = promptTemplate.create();

        // ========= returning list ============

        // chatClient.prompt(prompt)
        // .call()
        // .entity(new ListOutputConverter(new DefaultConversionService()));

        // ============ returning map ============

        return mapOutputConverter.convert(chatClient.prompt(prompt).call().chatResponse().getResult().toString());
    }
}

package com.koreait.exam.chat_example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();

//    @AllArgsConstructor
//    @Getter
//    public static class writeChatMessageRequest {
//        private final String authorName;
//        private final String content;
//    }

    // 위아래가 동일한 문

    public record writeChatMessageRequest(String authorName, String content) {
    }

    public record writeChatMessageResponse(long id) {

    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<writeChatMessageResponse> writeMessage(@RequestBody writeChatMessageRequest req) {
        ChatMessage message = new ChatMessage(req.authorName(), req.content());
        chatMessages.add(message);
        return new RsData<>(
                "S-1",
                "메세지가 전달됨",
                new writeChatMessageResponse(message.getId())
        ); // 보고서를 일관성있게 제출을 위해
    }

    public record messagesResponse(List<ChatMessage> messages, long count) {}

    @GetMapping("/messages")
    @ResponseBody
    public RsData<messagesResponse> messages() {
        return new RsData<>(
                "S-1",
                "메세지 리스트",
                new messagesResponse(chatMessages, chatMessages.size())
        );
    }
}

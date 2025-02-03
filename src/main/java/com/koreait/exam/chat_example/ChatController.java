package com.koreait.exam.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();

    public record writeChatMessageResponse(long id) {

    }

    @GetMapping("/writeMessage")
    @ResponseBody
    public RsData<writeChatMessageResponse> writeMessage() {
        ChatMessage message = new ChatMessage("김철수", "안녕");
        chatMessages.add(message);
        return new RsData<>(
                "S-1",
                "메세지가 전달됨",
                new writeChatMessageResponse(message.getId())
        ); // 보고서를 일관성있게 제출을 위해
    }

}

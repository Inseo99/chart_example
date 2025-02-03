package com.koreait.exam.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    ChatMessage message = new ChatMessage("김철수", "안녕");

    @GetMapping("/writeMessage")
    @ResponseBody
    public RsData<ChatMessage> writeMessage() {
        return new RsData<>("S-1", "메세지가 전달됨", message); // 보고서를 일관성있게 제출을 위해
    }

}

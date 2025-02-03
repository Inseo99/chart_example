package com.koreait.exam.chat_example;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ChatMessage {
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm-ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;
    private String authorName;
    private String content;

    public ChatMessage(String authorName, String content) {
        this(ChatMessageIdGenerator.getNextId(), LocalDateTime.now(), authorName, content); // 다른 생성자 호출

    }
}

class ChatMessageIdGenerator{

    private static long id = 0;

    public static long getNextId() {
        return id++;
    }
}
package com.simbirsoft.chat.dto;

import com.simbirsoft.chat.model.Message;
import com.simbirsoft.chat.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private Long id;
    private String text;
    private Date date;
    private Long userId;
    private Long roomId;

    public static MessageDto from(Message message){
        if(message==null){
            return null;
        }
        return MessageDto.builder()
                .id(message.getId())
                .text(message.getText())
                .date(message.getDate())
                .userId(message.getUser().getId())
                .roomId(message.getRoom().getId())
                .build();
    }
    public static List<MessageDto> from(List<Message> messages) {
        return messages.stream()
                .map(MessageDto::from)
                .collect(Collectors.toList());
    }

}

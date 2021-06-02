package com.simbirsoft.chat.dto;

import com.simbirsoft.chat.model.Room;
import com.simbirsoft.chat.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {
    private Long id;
    private List<User> useruserList;

    public static RoomDto from(Room room){
        if(room==null){
            return null;
        }
        return RoomDto.builder()
                .id(room.getId())
                .useruserList(room.getUser())
                .build();
    }
    public static List<RoomDto> from(List<Room> room) {
        return room.stream()
                .map(RoomDto::from)
                .collect(Collectors.toList());
    }
}

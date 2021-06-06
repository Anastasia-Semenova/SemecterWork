package ru.itis.sem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.sem.model.Master;
import ru.itis.sem.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MasterDto {

    private String information;
    private String position;

    public static MasterDto from(Master master) {
        if (master == null) {
            return null;
        }
        return MasterDto.builder()
                .information(master.getInformation())
                .position(master.getPosition())
                .build();
    }
    public static List<MasterDto> from(List<Master> masters) {
        return masters.stream()
                .map(MasterDto::from)
                .collect(Collectors.toList());
    }

}

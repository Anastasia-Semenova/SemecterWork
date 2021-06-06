package ru.itis.sem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.sem.model.MasterSchedule;
import ru.itis.sem.model.Schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MasterScheduleDto {
    private Long id;
    private Long masterId;
    private Date time;


    public static MasterScheduleDto from(MasterSchedule masterSchedule){
        if(masterSchedule==null){
            return null;
        }
        return MasterScheduleDto.builder()
                .id(masterSchedule.getId())
                .masterId(masterSchedule.getMasterId())
                .time(masterSchedule.getTime())
                .build();
    }

    public static List<MasterScheduleDto> from(List<MasterSchedule> schedules) {
        return schedules.stream()
                .map(MasterScheduleDto::from)
                .collect(Collectors.toList());
    }
}

package ru.itis.sem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.sem.model.Schedule;
import ru.itis.sem.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDto {
    private Long id;
    private Long masterId;
    private Long userId;
    private Date time;
    private Schedule.State state;


    public static ScheduleDto from(Schedule schedule){
        if(schedule==null){
            return null;
        }
        return ScheduleDto.builder()
                .id(schedule.getId())
                .masterId(schedule.getMasterId())
                .userId(schedule.getUserId())
                .time(schedule.getTime())
                .state(schedule.getState())
                .build();
    }

    public static List<ScheduleDto> from(List<Schedule> schedules) {
        return schedules.stream()
                .map(ScheduleDto::from)
                .collect(Collectors.toList());
    }
}

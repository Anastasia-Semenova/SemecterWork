package ru.itis.sem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sem_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long masterId;
    private Long userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        CONFIRMED, NOT_CONFIRMED
    }

    public boolean isActive() {
        return isConfirmed();
    }

    public boolean isConfirmed() {
        return this.state == State.CONFIRMED;
    }

//    temporalValues.setUtilTimestamp(
//            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

}

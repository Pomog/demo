package scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "step")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "step-name")
    private String stepName;
    
    @OneToMany(
            mappedBy = "equipment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Equipment> equipment;
    
    @OneToOne
    @JoinColumn(name = "code")
    private Room room;
    
    @OneToMany(
            mappedBy = "operator",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Operator> operators; // Operators certified for this stage
    
    @Column(name = "duration")
    private Duration duration;
    
    @Column(name = "is_night_shift")
    private boolean isNightShift;
    
    @Column(name = "is_weekend")
    private boolean isWeekend;
    
    @Column(name = "start-time")
    private LocalDateTime startTime;
    
    @Column(name = "end-time")
    private LocalDateTime endTime;
}

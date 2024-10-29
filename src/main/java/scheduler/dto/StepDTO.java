package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.StepEntity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class StepDTO {
    @NonNull
    private String stepName;
    private RoomDTO room;
    private Duration duration;
    private boolean isNightShift;
    private boolean isWeekend;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    private List<EquipmentDTO> equipment;
    private List<OperatorDTO> operators; // Operators certified for this stage
    
    public StepDTO(StepEntity stepEntity){
        this.stepName = stepEntity.getStepName();
        this.room = new RoomDTO(stepEntity.getRoomEntity());
        this.duration = stepEntity.getDuration();
        this.isNightShift = stepEntity.isNightShift();
        this.isWeekend = stepEntity.isWeekend();
        this.startTime = stepEntity.getStartTime();
        this.endTime = stepEntity.getEndTime();
        
        this.equipment = stepEntity.getEquipmentEntities().stream()
                .map(EquipmentDTO::new).collect(Collectors.toList());
        this.operators = stepEntity.getOperatorEntities().stream()
                .map(OperatorDTO::new)
                .collect(Collectors.toList());
    }
}

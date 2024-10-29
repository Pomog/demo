package scheduler.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.ProcessEntity;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ProcessDTO {
    @NonNull
    private String processName;
    private List<StepDTO> steps;
    
    public ProcessDTO(ProcessEntity processEntity) {
        this.processName = processEntity.getProcessName();
        this.steps = processEntity.getStepEntities().stream()
                .map(StepDTO::new)
                .collect(Collectors.toList());
    }
}

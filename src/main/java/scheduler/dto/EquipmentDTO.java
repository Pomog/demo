package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.Equipment;
import scheduler.entity.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    @NonNull
    private String name;
    @NonNull
    private String code;
    private List<StepDTO> steps = new ArrayList<>();
    
    public EquipmentDTO(Equipment equipmentEntity) {
        this.name = equipmentEntity.getName();
        this.code = equipmentEntity.getCode();
        this.steps.addAll(equipmentEntity.getSteps().stream()
                .map(StepDTO::new)
                .collect(Collectors.toList()));
    }
}

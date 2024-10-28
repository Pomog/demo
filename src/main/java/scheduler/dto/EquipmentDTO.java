package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.Equipment;
import scheduler.entity.Step;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    @NonNull
    private String name;
    @NonNull
    private String code;
    private List<Step> steps = new ArrayList<>();
    
    public EquipmentDTO(Equipment equipmentEntity) {
        this.name = equipmentEntity.getName();
        this.code = equipmentEntity.getCode();
        this.steps.addAll(equipmentEntity.getSteps());
    }
}

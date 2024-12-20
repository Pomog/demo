package scheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import scheduler.entity.EquipmentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EquipmentDTO {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;
    
    @NotBlank(message = "Code cannot be blank")
    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "Code format must be 'AAA-1234'")
    private String code;
    
    private List<StepDTO> steps = new ArrayList<>();
    
    public EquipmentDTO(EquipmentEntity equipmentEntity) {
        this.name = equipmentEntity.getName();
        this.code = equipmentEntity.getCode();
        this.steps.addAll(equipmentEntity.getStepEntities().stream()
                .map(StepDTO::new)
                .collect(Collectors.toList()));
    }
}

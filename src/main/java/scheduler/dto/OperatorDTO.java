package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.OperatorEntity;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OperatorDTO {

    @NonNull
    private String name;
    private SettingsDTO settings;
    private boolean prefersNight;
    private boolean prefersWeekend;
    private List<SkillDTO> skills;
    
    public OperatorDTO(OperatorEntity operatorEntity){
        this.name = operatorEntity.getName();
        this.settings = new SettingsDTO(operatorEntity.getSettingsEntity());
        this.skills = operatorEntity.getSkillEntities().stream()
                .map(SkillDTO::new)
                .collect(Collectors.toList());
                
    }
    
}

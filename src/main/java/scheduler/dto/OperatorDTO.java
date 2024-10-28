package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.Operator;
import scheduler.entity.Settings;
import scheduler.entity.Skill;

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
    
    public OperatorDTO(Operator operatorEntity){
        this.name = operatorEntity.getName();
        this.settings = new SettingsDTO(operatorEntity.getSettings());
        this.skills = operatorEntity.getSkills().stream()
                .map(SkillDTO::new)
                .collect(Collectors.toList());
                
    }
    
}

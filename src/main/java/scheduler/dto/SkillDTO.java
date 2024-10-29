package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.SkillEntity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class SkillDTO {
    @NonNull
    private String processName;
    private String stepName;
    private int level;
    
    public SkillDTO(SkillEntity skillEntity){
        this.processName = skillEntity.getProcessName();
        this.stepName = skillEntity.getStepName();
        this.level = skillEntity.getLevel();
    }
}

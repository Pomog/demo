package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.SettingsEntity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class SettingsDTO {
    @NonNull
    private String name;
    private double normalHours;
    private double nightCoefficient;
    private double weekendCoefficient;
    
    public SettingsDTO (SettingsEntity settingsEntity){
        this.name = settingsEntity.getName();
        this.normalHours = settingsEntity.getNormalHours();
        this.nightCoefficient = settingsEntity.getNightCoefficient();
        this.weekendCoefficient = settingsEntity.getWeekendCoefficient();
    }
}

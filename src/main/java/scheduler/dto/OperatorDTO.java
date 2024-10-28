package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.Settings;
import scheduler.entity.Skill;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OperatorDTO {

    @NonNull
    private String name;

    private Settings settings;

    private boolean prefersNight;

    private boolean prefersWeekend;
    
    private List<Skill> skills;
}

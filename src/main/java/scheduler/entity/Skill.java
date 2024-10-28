package scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "skill")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "process_name")
    @NonNull
    private String processName;
    
    @Column(name = "step_name")
    @NonNull
    private String stepName;
    
    @Column(name = "level")
    @NonNull
    private int level;
}

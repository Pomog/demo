package scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "settings", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class SettingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "name")
    @NonNull
    private String name;
    
    @Column(name = "normal_hours")
    private double normalHours;
    
    @Column(name = "normal_hours")
    private double nightCoefficient;
    
    @Column(name = "normal_hours")
    private double weekendCoefficient;
}

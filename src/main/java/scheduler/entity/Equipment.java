package scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "equipment")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "name")
    private String name;
    
    @NonNull
    @Column(name = "name")
    private String code;
    
    @OneToMany(
            mappedBy = "step",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Step> steps;
}

package scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "process")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    
    @Column(name = "process-name")
    private String processName;
    
    @OneToMany(
            mappedBy = "step",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Step> steps;
}
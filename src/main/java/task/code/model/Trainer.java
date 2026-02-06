package task.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trainers")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trainer implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    private String lastName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String phoneNumber;
}

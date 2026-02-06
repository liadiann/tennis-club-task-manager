package task.code.dto.court;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourtCreateDTO {
    @NotBlank
    private String name;
}

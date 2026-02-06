package task.code.dto.court;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class CourtUpdateDTO {
    @NotBlank
    private JsonNullable<String> name;
}

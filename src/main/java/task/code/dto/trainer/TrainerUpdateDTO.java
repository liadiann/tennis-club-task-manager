package task.code.dto.trainer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class TrainerUpdateDTO {
    @NotBlank
    private JsonNullable<String> firstName;
    @NotBlank
    private JsonNullable<String> lastName;
    @NotBlank
    private JsonNullable<String> phoneNumber;
}

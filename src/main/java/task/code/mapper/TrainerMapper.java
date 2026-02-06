package task.code.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import task.code.dto.trainer.TrainerCreateDTO;
import task.code.dto.trainer.TrainerDTO;
import task.code.dto.trainer.TrainerUpdateDTO;
import task.code.model.Trainer;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TrainerMapper {
    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    public abstract TrainerDTO map(Trainer trainer);
    public abstract Trainer map(TrainerCreateDTO data);
    public abstract void update(TrainerUpdateDTO data, @MappingTarget Trainer trainer);
}

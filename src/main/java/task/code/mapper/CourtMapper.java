package task.code.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import task.code.dto.court.CourtCreateDTO;
import task.code.dto.court.CourtDTO;
import task.code.dto.court.CourtUpdateDTO;
import task.code.model.Court;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CourtMapper {
    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    public abstract CourtDTO map(Court court);
    public abstract Court map(CourtCreateDTO data);
    public abstract void update(CourtUpdateDTO data, @MappingTarget Court court);
}

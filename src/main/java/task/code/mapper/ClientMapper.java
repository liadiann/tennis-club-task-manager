package task.code.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import task.code.dto.client.ClientCreateDTO;
import task.code.dto.client.ClientDTO;
import task.code.dto.client.ClientUpdateDTO;
import task.code.model.Client;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ClientMapper {
    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    public abstract ClientDTO map(Client client);
    public abstract Client map(ClientCreateDTO client);
    public abstract void update(ClientUpdateDTO dto, @MappingTarget Client client);
}

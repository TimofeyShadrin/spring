package ru.tshadrin.teta.mapper;

import org.mapstruct.Mapper;
import ru.tshadrin.teta.domain.PersonsEntity;
import ru.tshadrin.teta.dto.user.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto (PersonsEntity personsEntity);
    PersonsEntity toEntity (UserDTO userDTO);
}

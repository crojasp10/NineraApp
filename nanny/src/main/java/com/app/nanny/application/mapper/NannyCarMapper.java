package com.app.nanny.application.mapper;

import com.app.nanny.domain.models.NannyCar;
import com.app.nanny.infrastructure.entities.NannyCarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/*UsuarioEntity entity = new UsuarioEntity("Juan", "juan@correo.com");
Usuario model = UsuarioMapper.INSTANCE.toModel(entity);*/

@Mapper
public interface NannyCarMapper {


    NannyCarMapper INSTANCE = Mappers.getMapper(NannyCarMapper.class);

    NannyCar toModel(NannyCarEntity nannyCarEntity);

    NannyCarEntity toEntity(NannyCar nannyCar);


}

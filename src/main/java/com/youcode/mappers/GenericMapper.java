package com.youcode.mappers;

import org.mapstruct.MapperConfig;

@MapperConfig(componentModel = "spring")
public interface GenericMapper<Entity, Request, Response> {
    Response toDto(Entity entity);
    Entity toEntity(Request requestDto);
}

package com.rabbitmq.consumer.dto;


import com.rabbitmq.consumer.model.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProfileMapper {
    public abstract ProfileDto toDto(Profile profile);
}

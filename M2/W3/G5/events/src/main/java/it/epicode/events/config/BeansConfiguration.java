package it.epicode.events.config;

import it.epicode.events.Mapper;
import it.epicode.events.dto.LoginResponseDto;
import it.epicode.events.dto.RegisterUserDto;
import it.epicode.events.dto.RegisteredUserDto;
import it.epicode.events.entities.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeansConfiguration {
    @Bean
    @Scope("singleton")
    Mapper<RegisterUserDto, UserEntity> mapRegisterUser2UserEntity() {
        return (input) -> UserEntity.builder() //
                .withEmail(input.getFriendlyName()) //
                .withPassword(input.getPassword()) //
                .withUsername(input.getUsername()) //
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<UserEntity, RegisteredUserDto> mapUserEntity2RegisteredUser() {
        return (input) -> RegisteredUserDto.builder() //
                .withFriendlyName(input.getUsername()) //
                .withUsername(input.getUsername()) //
                .withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
                .build();
    }

    @Bean
    @Scope("singleton")
    Mapper<UserEntity, LoginResponseDto> mapUserEntity2LoginResponse() {
        return (input) -> LoginResponseDto.builder() //
                .withFriendlyName(input.getUsername()) //
                .withId(input.getId()) //
                .withUsername(input.getUsername()) //
                .withRoles(input.getRoles().stream().map(r -> r.getName()).toList()) //
                .build();
    }
}

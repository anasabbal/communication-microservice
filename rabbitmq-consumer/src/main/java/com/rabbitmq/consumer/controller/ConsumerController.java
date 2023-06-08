package com.rabbitmq.consumer.controller;


import com.rabbitmq.consumer.dto.ProfileDto;
import com.rabbitmq.consumer.dto.ProfileMapper;
import com.rabbitmq.consumer.model.Profile;
import com.rabbitmq.consumer.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/hhhh")
@RequiredArgsConstructor
public class ConsumerController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAll(){
        return ResponseEntity.ok(profileService.getAll().stream().map(profileMapper::toDto).toList());
    }
}

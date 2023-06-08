package com.rabbitmq.consumer.service;


import com.rabbitmq.consumer.model.Profile;
import com.rabbitmq.consumer.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {


    private final ProfileRepository profileRepository;


    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }
}

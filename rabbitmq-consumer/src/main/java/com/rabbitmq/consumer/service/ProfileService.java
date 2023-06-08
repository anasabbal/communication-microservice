package com.rabbitmq.consumer.service;

import com.rabbitmq.consumer.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProfileService {
    List<Profile> getAll();
}

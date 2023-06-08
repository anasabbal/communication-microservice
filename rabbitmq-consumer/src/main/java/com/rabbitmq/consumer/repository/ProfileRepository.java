package com.rabbitmq.consumer.repository;

import com.rabbitmq.consumer.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
}

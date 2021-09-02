package org.ada.school.SpringBootData.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserDocument, String>
{}
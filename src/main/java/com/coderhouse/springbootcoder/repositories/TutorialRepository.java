package com.coderhouse.springbootcoder.repositories;

import com.coderhouse.springbootcoder.entity.documents.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleAndPublishedOrDescription(String title, boolean published, String description);
}


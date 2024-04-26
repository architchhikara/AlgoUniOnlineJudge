package com.algouni.algouniOJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algouni.algouniOJ.models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> { 
}

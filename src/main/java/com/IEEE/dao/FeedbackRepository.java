package com.IEEE.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IEEE.entity.Feedback;
@Repository
public interface FeedbackRepository  extends JpaRepository<Feedback,Integer>{

}

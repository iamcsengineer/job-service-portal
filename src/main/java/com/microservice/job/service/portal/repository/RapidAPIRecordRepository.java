package com.microservice.job.service.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.job.service.portal.entities.RapidAPIRecord;

@Repository
public interface RapidAPIRecordRepository extends JpaRepository<RapidAPIRecord, Integer>{

}

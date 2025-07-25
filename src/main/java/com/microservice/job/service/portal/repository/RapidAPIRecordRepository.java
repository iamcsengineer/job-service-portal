package com.microservice.job.service.portal.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.job.service.portal.entities.RapidAPIRecord;

@Repository
public interface RapidAPIRecordRepository extends JpaRepository<RapidAPIRecord, Integer> {

	@Query(value = "SELECT * FROM rapidapirecord ORDER BY id DESC LIMIT 1", nativeQuery = true)
	RapidAPIRecord retrieveLastRecordTime();
}

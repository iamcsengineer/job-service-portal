package com.microservice.job.service.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.job.service.portal.entities.RapidAPIRecord;

@Repository
public interface RapidAPIRecordRepository extends JpaRepository<RapidAPIRecord, Integer> {

	@Query(value = "SELECT * FROM rapidapirecord r WHERE r.remote_job = :remoteJob ORDER BY r.id DESC LIMIT 1", nativeQuery = true)
	RapidAPIRecord retrieveLastRecord(@Param("remoteJob") int remoteJob);
}

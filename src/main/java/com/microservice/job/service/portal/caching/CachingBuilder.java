package com.microservice.job.service.portal.caching;

import com.microservice.job.service.portal.entities.RapidAPIRecord;
import com.microservice.job.service.portal.repository.RapidAPIRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CachingBuilder {

    @Autowired
    private RapidAPIRecordRepository rapidAPIRecordRepository;

    @Cacheable(value = "jobPortalCache", key = "'latestJobs'")
    public RapidAPIRecord retrieveLastRecordFromDB(){
        RapidAPIRecord retrieveLastRecord = rapidAPIRecordRepository.retrieveLastRecord();
        return retrieveLastRecord;
    }

}

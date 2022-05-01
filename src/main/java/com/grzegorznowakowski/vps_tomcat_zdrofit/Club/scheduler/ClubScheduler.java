package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.scheduler;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service.ClubSchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubScheduler {

    private final ClubSchedulerService clubSchedulerService;

    @Value("${schedule.download-once-a-day.enable}")
    private boolean isSchedulerEnabled;

    @Scheduled(cron = "${schedule.download-once-a-day.cron}")
    public void downloadClubs() {
        if (isSchedulerEnabled) {
            log.info("Downloading list of clubs {}", LocalDateTime.now());

            long startTime = System.nanoTime();
            clubSchedulerService.logClubs();
            long importTimeInMs = (System.nanoTime() - startTime) / 1000000;
            log.info("Download done after: {} ms", importTimeInMs);
        } else {
            log.info("ClubScheduler is disabled.");
        }
    }
}

package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.scheduler;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Club.service.ClubWhoIsInCountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubWhoIsInCountScheduler {
    private final ClubWhoIsInCountService clubWhoIsInCountService;

    @Value("${schedule.download-every-30-min.enable}")
    private boolean isSchedulerEnabled;

    @Scheduled(cron = "${schedule.download-every-30-min.cron}")
    public void downloadWhoIsInCount() {
        if (isSchedulerEnabled) {
            log.info("Downloading current number of members in each club at {}", LocalDateTime.now());

            long startTime = System.nanoTime();
            clubWhoIsInCountService.logZdrofitMembers();
            long importTimeInMs = (System.nanoTime() - startTime) / 1000000;
            log.info("Download done after: {} ms", importTimeInMs);
        } else {
            log.info("WhoIsInCountScheduler is disabled.");
        }
    }
}

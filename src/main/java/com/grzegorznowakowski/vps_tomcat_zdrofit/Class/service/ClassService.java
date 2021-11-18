package com.grzegorznowakowski.vps_tomcat_zdrofit.Class.service;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.dto.ClassWhoIsInDTO;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.dto.ClassWhoIsInResponse;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.entity.ClassWhoIsIn;
import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.repository.ClassWhoIsInRepository;
import com.grzegorznowakowski.vps_tomcat_zdrofit.config.ZdrofitAPI;
import com.grzegorznowakowski.vps_tomcat_zdrofit.dto.MonikaDTO;
import com.grzegorznowakowski.vps_tomcat_zdrofit.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassService {
    private final ZdrofitAPI zdrofitAPI;
    private final static String WHO_IS_IN_URL = "/v1/Classes/WhoIsIn";
    private final RestTemplate restTemplate;
    private final ClassWhoIsInRepository classWhoIsInRepository;

    public void logClassWhoIsIn() {
        UriComponents uri = UriComponentsBuilder.fromUriString(zdrofitAPI.getUrl())
                .path(WHO_IS_IN_URL)
                .build().encode();

        ResponseEntity<ClassWhoIsInResponse> response = restTemplate.exchange(uri.toString(),
                HttpMethod.GET,
                zdrofitAPI.getHttpEntity(),
                ClassWhoIsInResponse.class);

        HttpUtils.validateError(response);
        saveClassWhoIsIn(response);
    }

    private void saveClassWhoIsIn(ResponseEntity<ClassWhoIsInResponse> response) {
        LocalDateTime time = LocalDateTime.now();
        Objects.requireNonNull(response.getBody()).getData()
                .forEach(whoIsInCount -> logClassWhoIsIn(time, whoIsInCount));
    }

    private void logClassWhoIsIn(LocalDateTime time, ClassWhoIsInDTO whoIsIn) {
        System.out.println(whoIsIn.getId() + " => " + whoIsIn.getLastName());
        ClassWhoIsIn registeredClassMember = ClassWhoIsIn.builder()
                .id(whoIsIn.getId())
                .firstName(whoIsIn.getFirstName())
                .nickName(whoIsIn.getNickName())
                .lastName(whoIsIn.getLastName())
                .photoUrl(whoIsIn.getPhotoUrl())
                .isStandby(whoIsIn.isStandby())
                .isCanceled(whoIsIn.isCanceled())
                .classId(whoIsIn.getClassId())
                .companyId(whoIsIn.getCompanyId())
                .timestamp(whoIsIn.getTimestamp())
                .isDeleted(whoIsIn.isDeleted())
                .build();
        classWhoIsInRepository.save(registeredClassMember);
    }

    public MonikaDTO getMonika() {
        return MonikaDTO.create(classWhoIsInRepository.findMonika());
    }

}

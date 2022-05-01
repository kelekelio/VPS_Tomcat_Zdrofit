package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Club")
public class Club {

    @Id
    private Long id;

    private String name;

    private String description;

    private Long companyId;

    private Double longitude;

    private Double latitude;

    private Boolean isHidden;

    private Boolean isDeleted;
}

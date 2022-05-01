package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@ToString
public class ClubDTO {

    private Long id;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Long companyId;
    private Boolean isHidden;
    private Boolean isDeleted;



    public ClubDTO(@JsonProperty("id") Long id,
                   @JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("longitude") Double longitude,
                   @JsonProperty("latitude") Double latitude,
                   @JsonProperty("companyId") Long companyId,
                   @JsonProperty("isHidden") Boolean isHidden,
                   @JsonProperty("isDeleted") Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.companyId = companyId;
        this.isHidden = isHidden;
        this.isDeleted = isDeleted;
    }
}

package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ChartResponse {

    private String type;
    private String name;
    private String color;
    private Integer markerSize;
    private String xValueFormatString;
    private String yValueFormatString;
    private Boolean showInLegend;
    private Boolean visible;
    private List<Count> dataPoints;

}

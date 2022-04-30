package com.grzegorznowakowski.vps_tomcat_zdrofit.Club.Enum;

public enum ChartType {
    SPLINE("spline"),
    SPLINE_AREA("splineArea");

    public final String type;

    private ChartType(String type) {
        this.type = type;
    }
}

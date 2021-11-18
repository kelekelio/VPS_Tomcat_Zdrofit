package com.grzegorznowakowski.vps_tomcat_zdrofit.dto;

import com.grzegorznowakowski.vps_tomcat_zdrofit.Class.entity.ClassWhoIsIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MonikaDTO {

    private List<ClassWhoIsIn> monikas;

    private int size;

    public static MonikaDTO create(List<ClassWhoIsIn> monikas) {
        return MonikaDTO.builder()
                .monikas(monikas)
                .size(monikas.size())
                .build();
    }
}

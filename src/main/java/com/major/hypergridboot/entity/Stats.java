package com.major.hypergridboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stats {

    private double value;
    private String caption;
    private String info;
    private String prefix;
    private String suffix;

}

package com.obit.ganalyzer.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GForce {

    private Integer duration;
    private BigDecimal xAxisG;
    private BigDecimal yAxisG;
    private BigDecimal zAxisG;

}

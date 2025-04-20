package org.yinxiao.nothing.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CigaretteRetailer {
    private String uuid;
    private Integer residentPopulation;
    private Integer studentCountThisSemester;
    private BigDecimal stayingRateDuringHolidays;
    private BigDecimal smokingRate;
    private BigDecimal studentRegulationRatio;
    private BigDecimal geographicalWeight;
    private BigDecimal salesIntensityCoefficient;
    private Integer weeklySales;
    private BigDecimal gearCoefficient;
    private Integer serviceRequestCount;
    private Integer abnormalSalesCount;
    private BigDecimal inventorySalesRatio;
    private BigDecimal fullOrderRateFluctuation;
    private String retailerLicenseNumber;
    private String retailerName;
}
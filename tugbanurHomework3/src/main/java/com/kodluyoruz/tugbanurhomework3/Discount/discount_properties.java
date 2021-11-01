package com.kodluyoruz.tugbanurhomework3.Discount;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "discount")
@Data
public class discount_properties {
    private double deliveryFee;
    private double deliveryFeeLimit;
    private double discPercentage;
    private int creditCartCommission;
}

package uz.sirnornur.zopatest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteOption {
    private Integer id;
    private String lenderName;
    private Double rate;
    private Integer availableAmount;
}
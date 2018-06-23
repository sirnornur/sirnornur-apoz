package uz.sirnornur.zopatest.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Siroj Matchanov
 */
@Data
@Builder
public class QuoteInfo {
    private Integer requestedAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;
}

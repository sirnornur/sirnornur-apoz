package uz.sirnornur.zopatest.service;

import uz.sirnornur.zopatest.dto.QuoteInfo;

/**
 * RepaymentCalculator implementation based on the nominal interest rate calculation formula.
 *
 * @author Siroj Matchanov
 */
public class NominalInterestRepaymentCalculator implements RepaymentCalculator {
    @Override
    public QuoteInfo calculateMonthlyRate(
            final int requestedAmount,
            final double rate,
            final int rentalPeriodInMonths
    ) {
        Double r = rate / 12;
        //d = (r s)/(1 - (1 + r)^-n)
        Double monthlyRate = (r * requestedAmount) / (1 - Math.pow(1 + r, -rentalPeriodInMonths));
        return QuoteInfo.builder()
                .monthlyRepayment(monthlyRate)
                .totalRepayment(monthlyRate * rentalPeriodInMonths)
                .requestedAmount(requestedAmount)
                .rate(rate)
                .build();
    }
}

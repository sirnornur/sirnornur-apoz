package uz.sirnornur.zopatest.service;

import uz.sirnornur.zopatest.dto.QuoteInfo;

/**
 * This interface defines the repayment calculator methods.
 * Doing some research, I discovered that there can be different calculation
 * methods, e.g.:
 * - nominal interest rate calculator
 * - effective interest rate calculator
 *
 * @author Siroj Matchanov
 */
public interface RepaymentCalculator {
    QuoteInfo calculateMonthlyRate(
            final int requestedAmount,
            final double rate,
            final int rentalPeriodInMonths
    );
}

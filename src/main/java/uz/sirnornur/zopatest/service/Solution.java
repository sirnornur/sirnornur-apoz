package uz.sirnornur.zopatest.service;

import uz.sirnornur.zopatest.dto.QuoteInfo;

import java.io.IOException;

/**
 * The solution class that solves the given problem.
 * It is also useful for testing purposes.
 *
 * @author Siroj Matchanov
 */
public class Solution {

    private final int RENTAL_PERIOD_IN_MONTHS = 36;

    private final String filename;
    private final Integer requestedAmount;

    public Solution(String filename, Integer requestedAmount) {
        this.filename = filename;
        this.requestedAmount = requestedAmount;
    }

    public void run() throws Exception {
        validateRequestedAmount(requestedAmount);

        QuoteInfo quoteInfo = fetchQuoteInfo(filename, requestedAmount);

        printQuoteInfo(quoteInfo);
    }

    private void validateRequestedAmount(int amount) {
        if (amount < 1000 || amount > 15000 || amount % 100 != 0) {
            throw new IllegalArgumentException("Please provide the requested loan amount correctly. Allowed amount: any £100 increment between £1000 and £15000 inclusive.");
        }
    }

    private QuoteInfo fetchQuoteInfo(String filename, Integer requestedAmount) throws Exception {
        return new CsvFileQuoteProvider(filename, RENTAL_PERIOD_IN_MONTHS, new NominalInterestRepaymentCalculator())
            .getQuote(requestedAmount);
    }

    private void printQuoteInfo(QuoteInfo quoteInfo) {
        // a quote that matches our requirements was found, print the info
        System.out.println(String.format("Requested amount: £%s", quoteInfo.getRequestedAmount()));
        System.out.println(String.format("Rate: £%.1f", quoteInfo.getRate() * 100));
        System.out.println(String.format("Monthly repayment: £%.2f", quoteInfo.getMonthlyRepayment()));
        System.out.println(String.format("Total repayment: £%.2f", quoteInfo.getTotalRepayment()));
    }
}

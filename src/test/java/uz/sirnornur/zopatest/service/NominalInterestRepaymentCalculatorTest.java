package uz.sirnornur.zopatest.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import uz.sirnornur.zopatest.dto.QuoteInfo;

/**
 * @author Siroj Matchanov
 */
public class NominalInterestRepaymentCalculatorTest {
    private NominalInterestRepaymentCalculator repaymentCalculator;

    public NominalInterestRepaymentCalculatorTest() {
        this.repaymentCalculator = new NominalInterestRepaymentCalculator();
    }

    @Test
    public void calculateMonthlyRate() throws Exception {
        // given
        final int requestedAmount = 10000;
        final double rate = 0.07;
        final int rentalPeriod = 36;

        // when
        QuoteInfo quoteInfo = repaymentCalculator.calculateMonthlyRate(requestedAmount, rate, rentalPeriod);

        // then
        Assertions.assertThat(quoteInfo)
                .isNotNull();

        Assertions.assertThat(quoteInfo.getRequestedAmount())
                .isEqualTo(requestedAmount);

        Assertions.assertThat(quoteInfo.getTotalRepayment())
                .isGreaterThan(requestedAmount);

        // ideally there should be formula based assertions.
        // I did not write them to save the time.
    }

}
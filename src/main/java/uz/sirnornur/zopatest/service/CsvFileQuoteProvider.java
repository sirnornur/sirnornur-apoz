package uz.sirnornur.zopatest.service;

import uz.sirnornur.zopatest.dto.QuoteOption;
import uz.sirnornur.zopatest.dto.QuoteInfo;
import uz.sirnornur.zopatest.utils.FileIOHelper;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * QuoteProvider implementation that reads QuoteOptions from csv file.
 *
 * @author Siroj Matchanov
 */
public class CsvFileQuoteProvider implements QuoteProvider {

    private final List<QuoteOption> availableQuotes;
    private final int rentalPeriodInMonths;
    private final RepaymentCalculator repaymentCalculator;

    public CsvFileQuoteProvider(
            final String filename,
            final int rentalPeriodInMonths,
            final RepaymentCalculator repaymentCalculator
    ) throws IOException {
        this.availableQuotes = initializeFromFile(filename);
        this.rentalPeriodInMonths = rentalPeriodInMonths;
        this.repaymentCalculator = repaymentCalculator;
    }

    @Override
    public QuoteInfo getQuote(Integer requestedAmount) {
        Double rate = 0d;
        Integer collectedAmount = 0;
        for (QuoteOption option : availableQuotes) {
            collectedAmount += Math.min(option.getAvailableAmount(), requestedAmount - collectedAmount);
            rate = option.getRate();
            if (collectedAmount.equals(requestedAmount)) break;
        }
        if (collectedAmount < requestedAmount) {
            throw new IllegalStateException("The available loan amount is less than the requested amount.");
        }

        return repaymentCalculator.calculateMonthlyRate(requestedAmount, rate, rentalPeriodInMonths);
    }

    private List<QuoteOption> initializeFromFile(String filename) throws IOException {
        String fileContents = FileIOHelper.readFileContents(filename);

        String[] lines = fileContents.split("\n");

        List<QuoteOption> quoteOptions = new LinkedList<>();
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] elems = line.split(",");
            if (elems.length < 3) {
                throw new IOException("Failed to read line #" + i);
            }

            quoteOptions.add(
                    QuoteOption.builder()
                            .id(i)
                            .lenderName(elems[0])
                            .rate(Double.parseDouble(elems[1]))
                            .availableAmount(Integer.parseInt(elems[2]))
                            .build());
        }
        quoteOptions.sort(Comparator.comparing(QuoteOption::getRate));
        return quoteOptions;
    }
}

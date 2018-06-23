package uz.sirnornur.zopatest.service;

import uz.sirnornur.zopatest.dto.QuoteInfo;

/**
 * Base class for QuoteProviders.
 * There can be different QuoteProvider implementations, e.g.:
 * CsvFileQuoteProvider, DatabaseQuoteProvider and etc.
 *
 * @author Siroj Matchanov
 */
public interface QuoteProvider {

    /**
     * Provides a suitable loan quote, if any.
     *
     * @param requestedAmount the requested loan amount
     * @return QuoteInfo instance if found, null if not found.
     */
    QuoteInfo getQuote(Integer requestedAmount);
}

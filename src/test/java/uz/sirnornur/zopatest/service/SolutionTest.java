package uz.sirnornur.zopatest.service;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Siroj Matchanov
 */
public class SolutionTest {

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenFileNotFound() throws Exception {
        // given
        final String fileNameThatDoesNotExist = "resources/not-found";
        final int correctRequestedAmount = 5000;

        // when
        new Solution(fileNameThatDoesNotExist, correctRequestedAmount).run();

        // then
        // IOException (file not found) expected
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSmallAmount() throws Exception {
        // given
        final String sampleFile = "samples/input.csv";
        final int wrongRequestedAmount = 900;

        // when
        new Solution(sampleFile, wrongRequestedAmount).run();

        // then
        // IOException (file not found) expected
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTooBigAmount() throws Exception {
        // given
        final String sampleFile = "samples/input.csv";
        final int wrongRequestedAmount = 15100;

        // when
        new Solution(sampleFile, wrongRequestedAmount).run();

        // then
        // IOException (file not found) expected
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAmountNotDivisibleBy100() throws Exception {
        // given
        final String sampleFile = "samples/input.csv";
        final int wrongRequestedAmount = 10501;

        // when
        new Solution(sampleFile, wrongRequestedAmount).run();

        // then
        // IOException (file not found) expected
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenLessAmountAvailable() throws Exception {
        // given
        final String sampleFile = "samples/input.csv";
        final int moreAmountThanAvailable = 10500;

        // when
        new Solution(sampleFile, moreAmountThanAvailable).run();

        // then
        // IOException (file not found) expected
    }

}
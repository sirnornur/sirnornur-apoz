package uz.sirnornur.zopatest.utils;

import org.junit.Test;
import uz.sirnornur.zopatest.service.Solution;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Siroj Matchanov
 */
public class FileIOHelperTest {

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenFileNotFound() throws Exception {
        // given
        final String fileNameThatDoesNotExist = "resources/not-found";

        // when
        FileIOHelper.readFileContents(fileNameThatDoesNotExist);

        // then
        // IOException (file not found) expected
    }
}

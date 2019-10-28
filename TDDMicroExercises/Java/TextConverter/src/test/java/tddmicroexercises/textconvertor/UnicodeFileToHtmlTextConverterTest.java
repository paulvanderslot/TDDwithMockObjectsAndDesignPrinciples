package tddmicroexercises.textconvertor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UnicodeFileToHtmlTextConverterTest {

    @Test
    void convertsAFileToHtmlWithAnAmpersandAndNewLines() throws Exception {
        String fullFilenameWithPath = getClass().getClassLoader().getResource("testFile.txt").getPath();
        UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(fullFilenameWithPath);
        assertThat(converter.convertToHtml())
            .isEqualTo("This file<br />should be converted &amp; returned<br />to HTML!<br />");
    }
}

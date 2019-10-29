package tddmicroexercises.textconvertor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UnicodeTextToHtmlConverterTest {

    @Test
    void convertsAFileToHtmlWithAnAmpersandAndNewLines() throws Exception {
        String fullFilenameWithPath = getClass().getClassLoader().getResource("testFile.txt").getPath();
        UnicodeTextToHtmlConverter converter = new UnicodeTextToHtmlConverter(new FileFromPathReader(fullFilenameWithPath));
        assertThat(converter.convertToHtml())
            .isEqualTo("This file<br />should be converted &amp; returned<br />to HTML!<br />");
    }

}

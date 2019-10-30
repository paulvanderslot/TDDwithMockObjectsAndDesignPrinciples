package tddmicroexercises.textconvertor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UnicodeTextToHtmlConverterTest {

    @Test
    void convertsAFileToHtmlWithAnAmpersandAndNewLines() throws Exception {
        String fullFilenameWithPath = getClass().getClassLoader().getResource("testFile.txt").getPath();

        UnicodeTextToHtmlConverter converter = new UnicodeTextToHtmlConverter(new FileFromPathReader(fullFilenameWithPath));

        assertThat(converter.convertToHtml())
            .isEqualTo("This file<br />should be converted &amp; returned<br />to HTML!<br />");
    }

    @Test
    void convertLinesToHtml() throws Exception {
        List<String> readLines = Arrays.asList("This file", "should be converted", "to HTML!");

        UnicodeTextToHtmlConverter converter = new UnicodeTextToHtmlConverter(() -> readLines);

        assertThat(converter.convertToHtml())
            .isEqualTo("This file<br />should be converted<br />to HTML!<br />");
    }

    @Test
    void convertLinesWithEscapeCharacters() throws Exception {
        List<String> readLines = Arrays.asList("\"bread\" & \"butter\"");

        UnicodeTextToHtmlConverter converter = new UnicodeTextToHtmlConverter(() -> readLines);

        assertThat(converter.convertToHtml()).isEqualTo("&quot;bread&quot; &amp; &quot;butter&quot;<br />");
    }
}

package tddmicroexercises.textconvertor;

import java.io.IOException;

import org.apache.commons.lang3.StringEscapeUtils;

public class UnicodeTextToHtmlConverter {
    private static final String LINE_BREAK = "<br />";
    private Reader reader;

    public UnicodeTextToHtmlConverter(Reader reader) {
        this.reader = reader;
    }

    public String convertToHtml() throws IOException {
        StringBuilder htmlStringBuilder = new StringBuilder();
        reader.readLines().forEach(line -> htmlStringBuilder.append(convertToHtml(line)));
        return htmlStringBuilder.toString();
    }

    private String convertToHtml(String line) {
        StringBuilder builder = new StringBuilder();
        builder.append(StringEscapeUtils.escapeHtml4(line));
        builder.append(LINE_BREAK);
        return builder.toString();
    }
}

package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringEscapeUtils;

public class UnicodeFileToHtmlTextConverter {
    private static final String LINE_BREAK = "<br />";
    private String fullFilenameWithPath;

    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath))) {
            StringBuilder htmlStringBuilder = new StringBuilder();
            readLines(reader).forEach(line -> htmlStringBuilder.append(convertToHtml(line)));
            return htmlStringBuilder.toString();
        }
    }

    private Collection<String> readLines(BufferedReader reader) throws IOException {
        Collection<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        return lines;
    }

    private String convertToHtml(String line) {
        StringBuilder builder = new StringBuilder();
        builder.append(StringEscapeUtils.escapeHtml4(line));
        builder.append(LINE_BREAK);
        return builder.toString();
    }
}

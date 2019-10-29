package tddmicroexercises.textconvertor.somedependencies;

import java.io.IOException;

import tddmicroexercises.textconvertor.FileFromPathReader;
import tddmicroexercises.textconvertor.UnicodeTextToHtmlConverter;

public class aTextConverterClient1 {
    // A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
    // that has impact on the refactoring.

    public aTextConverterClient1() throws IOException {
        String filename = "aFilename.txt";
        UnicodeTextToHtmlConverter textConverter = new UnicodeTextToHtmlConverter(new FileFromPathReader(filename));

        String html = textConverter.convertToHtml();
    }
}

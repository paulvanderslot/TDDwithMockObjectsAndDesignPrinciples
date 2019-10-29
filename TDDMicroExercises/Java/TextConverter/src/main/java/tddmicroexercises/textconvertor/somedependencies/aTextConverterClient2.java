package tddmicroexercises.textconvertor.somedependencies;

import java.io.IOException;

import tddmicroexercises.textconvertor.FileFromPathReader;
import tddmicroexercises.textconvertor.UnicodeTextToHtmlConverter;

public class aTextConverterClient2 {
    // A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
    // that has impact on the refactoring.

    UnicodeTextToHtmlConverter _textConverter;

    public aTextConverterClient2() throws IOException {
        _textConverter = new UnicodeTextToHtmlConverter(new FileFromPathReader("anotherFilename.txt"));

        String html = _textConverter.convertToHtml();
    }

}

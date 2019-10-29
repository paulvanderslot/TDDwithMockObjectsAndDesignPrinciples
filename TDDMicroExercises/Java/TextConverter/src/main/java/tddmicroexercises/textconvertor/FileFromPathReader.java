package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class FileFromPathReader implements Reader {

    private final String filenameWithPath;

    public FileFromPathReader(String filenameWithPath) {
        this.filenameWithPath = filenameWithPath;
    }

    @Override
    public Collection<String> readLines() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filenameWithPath))) {
            Collection<String> lines = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            return lines;
        }
    }

}

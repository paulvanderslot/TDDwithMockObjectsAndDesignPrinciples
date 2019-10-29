package tddmicroexercises.textconvertor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class FileFromPathReaderTest {

    @Test
    void canReadFile() throws Exception {
        String fullFilenameWithPath = getClass().getClassLoader().getResource("testFile.txt").getPath();
        Reader reader = new FileFromPathReader(fullFilenameWithPath);

        Collection<String> lines = reader.readLines();

        assertThat(lines).containsExactly("This file", "should be converted & returned", "to HTML!");
    }

    @Test
    void cantReadNonExistingFile() throws Exception {
        Reader reader = new FileFromPathReader("doesNotExist.txt");

        assertThrows(IOException.class, () -> reader.readLines());
    }
}

package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.Collection;

public interface Reader {

    public Collection<String> readLines() throws IOException;
}

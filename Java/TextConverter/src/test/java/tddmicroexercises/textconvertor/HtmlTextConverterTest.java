package tddmicroexercises.textconvertor;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlTextConverterTest {

    @Test
    public void should_escape_html_from_text_file() throws URISyntaxException, IOException {
        String expected = readFrom("escaped_text.txt");
        HtmlTextConverter converter = new HtmlTextConverter(this.getClass().getClassLoader().getResource("not_escaped_text.txt").getPath());

        String actual = converter.convertToHtml();

        assertEquals(expected, actual);
    }

    private String readFrom(String file) throws IOException, URISyntaxException {
        URL resource = this.getClass().getClassLoader().getResource(file);
        return Files.readAllLines(Paths.get(resource.toURI()))
                .stream()
                .collect(Collectors.joining());
    }
}

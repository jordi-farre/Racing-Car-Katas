package tddmicroexercises.textconvertor;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlPagesConverterTest {

    @Test
    public void should_return_single_html_escaped_page() throws IOException, URISyntaxException {
        String expected = readFrom("escaped_text_single_page.txt");
        HtmlPagesConverter converter = new HtmlPagesConverter(this.getClass().getClassLoader().getResource("not_escaped_text_multiple_pages.txt").getPath());

        String actual = converter.getHtmlPage(2);

        assertEquals(expected, actual);
    }

    private String readFrom(String file) throws IOException, URISyntaxException {
        URL resource = this.getClass().getClassLoader().getResource(file);
        return Files.readAllLines(Paths.get(resource.toURI()))
                .stream()
                .collect(Collectors.joining());
    }

}

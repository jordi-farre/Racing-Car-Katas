package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException{
    	return Files.lines(Paths.get(fullFilenameWithPath))
				.map(StringEscapeUtils::escapeHtml)
				.collect(Collectors.joining("<br />")) + "<br />";
    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}

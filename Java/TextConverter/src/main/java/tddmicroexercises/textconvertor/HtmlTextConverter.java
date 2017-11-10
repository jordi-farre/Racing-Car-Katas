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
	private static final String NEW_LINE = "<br />";
	private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException{
    	return Files.lines(Paths.get(fullFilenameWithPath))
				.map(StringEscapeUtils::escapeHtml)
				.collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}

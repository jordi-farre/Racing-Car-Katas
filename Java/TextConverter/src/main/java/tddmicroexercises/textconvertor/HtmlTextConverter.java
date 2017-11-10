package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException{
    
	    try (FileReader fileReader = new FileReader(fullFilenameWithPath);
			 BufferedReader reader = new BufferedReader(fileReader)) {
			return reader.lines()
					.map(StringEscapeUtils::escapeHtml)
					.collect(Collectors.joining("<br />")) + "<br />";
		}
    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}

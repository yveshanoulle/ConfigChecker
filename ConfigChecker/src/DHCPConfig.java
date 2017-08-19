import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DHCPConfig {

	public boolean LineIsCommented(String line)
	{
		return LineStartsWithTestString(line,"#");
	}
	public boolean LineStartsWithHost(String line)
	{
		return LineStartsWithTestString(line,"host");
	}
	public boolean LineEndsWithSemiColon(String line)
	{
	return LineEndsWithTestString(line,";");
	}
	public boolean LineContainsOnlyOpenParenthese(String line)
	{
		return LineStartsWithOpenParenthese(line) &&LineEndsWithOpenParenthese(line);
	}
	public boolean LineContainsOnlyCloseParenthese(String line)

	{
		return LineStartsWithCloseParenthese(line) &&LineEndsWithCloseParenthese(line);
	}
	public boolean LineIsEmpty(String line)
	{
		return 0==line.trim().length();
	}
	public boolean LineIsCorrect(String line)
	{
		return 	LineIsCommented(line) ||
				LineStartsWithHost(line) ||
				LineEndsWithSemiColon(line) ||
				LineContainsOnlyOpenParenthese(line) ||
				LineContainsOnlyCloseParenthese(line) ||
				LineIsEmpty(line) ;
	}
	public boolean VerifyFile(String fileToCheck)
	{
		int lastErrorLine;
		
		lastErrorLine= FindLastErrorLineInFile(fileToCheck);
		
		
		return 0==lastErrorLine;
	}
	public int FindLastErrorLineInFile(String fileToCheck)
	{
		List<String> lines;
		lines= OpenFile (fileToCheck);
		int lastErrorLine=0;
		int lineNr=0;
		boolean errorFree=false;
		
		for (String line : lines) {
			lineNr=lineNr+1;
			errorFree= LineIsCorrect(line);
			if (! errorFree)
			{
				lastErrorLine=lineNr;
			}
		}
		
		
		return lastErrorLine;
	}
	
	public List<String> OpenFile(String fileToOpen)
	{
		 List<String> records = new ArrayList<String>();
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(fileToOpen));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		      records.add(line);
		    }
		    reader.close();
		    return records;
		  }
		  catch (Exception e)
		  {
		   // System.err.format("Exception occurred trying to read '%s'.", fileToOpen);
		   // e.printStackTrace();
		    return null;
		  }
		//return true;
	}
	private boolean LineStartsWithOpenParenthese(String line)
	{
		return LineStartsWithTestString(line,"{");
	}
	private boolean LineEndsWithOpenParenthese(String line)
	{
		return LineEndsWithTestString(line,"{");
	}
	private boolean LineStartsWithCloseParenthese(String line)
	{
		return LineStartsWithTestString(line,"}");
	}
	private boolean LineEndsWithCloseParenthese(String line)
	{
		return LineEndsWithTestString(line,"}");
	}
	private boolean LineStartsWithTestString(String line, String TestString)
	{
		int indexTag;
		
		indexTag=line.indexOf(TestString);
		
		return 0==indexTag;
	}
	private boolean LineEndsWithTestString(String line, String TestString)
	{
		int indexTag;
		
		indexTag=line.indexOf(TestString);
		
		return line.length()==(indexTag+1) ;
	}
}

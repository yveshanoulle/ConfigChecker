import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DHCPConfigTest {
	DHCPConfig myDHCPConfig;
	
	@Before
    public void setUp() throws Exception{
		myDHCPConfig = new DHCPConfig();
    }
	@Test
	public void LineIsCommentedTest() {
		assertTrue(myDHCPConfig.LineIsCommented("#Config"));
	}
	@Test
	public void CommentedLineIsCorrectTest() {
		assertTrue(myDHCPConfig.LineIsCorrect("#Config"));
	}
	@Test
	public void LineIsNotCommentedTest() {
		assertFalse(myDHCPConfig.LineIsCommented("Not Commented line"));
	}
	@Test
	public void LineIsHasCommentHalfwayTest() {
		assertFalse(myDHCPConfig.LineIsCommented("Not Commented line # Commented Part"));
	}
	@Test
	public void LineStartsWithHostTest() {
		
		DHCPConfig myDHCPConfig = new DHCPConfig();
		
		assertTrue(myDHCPConfig.LineStartsWithHost("host config"));
	}
	@Test
	public void LineStartsWithHostIsCorrectTest() {
		assertTrue(myDHCPConfig.LineIsCorrect("host config"));
	}
	@Test
	public void LineContainsNoHostTest() {
		
		DHCPConfig myDHCPConfig = new DHCPConfig();
		
		assertFalse(myDHCPConfig.LineStartsWithHost("A config file without the word we are looking for "));
	}
	@Test
	public void LineIsHasHostHalfwayTest() {
		assertFalse("Test allows host word halfway, we don't allow that.  ",myDHCPConfig.LineIsCommented("Line has host word halfway, we don't allow that."));
	}
	@Test
	public void LineEndsWithSemiColonTest() {
		assertTrue(myDHCPConfig.LineEndsWithSemiColon("Line end with ;"));
	}
	@Test
	public void LineEndsWithSemiColonIsCorrectTest() {
		assertTrue(myDHCPConfig.LineIsCorrect("Line end with ;"));
	}
	@Test
	public void LineDoesNotEndWithSemiColonTest() {
		assertFalse(myDHCPConfig.LineEndsWithSemiColon("Line does not end with ; We have extra info behind"));
	}
	@Test
	public void LineOnlyContainsOpenParentheseTest() {
		assertTrue(myDHCPConfig.LineContainsOnlyOpenParenthese("{"));
	}
	@Test
	public void LineOnlyContainsOpenParentheseIsCorrectTest() {
		assertTrue(myDHCPConfig.LineIsCorrect("{"));
	}
	@Test
	public void LineContainsTextBeforeOpenParentheseTest() {
		assertFalse(myDHCPConfig.LineContainsOnlyCloseParenthese("something else{"));
	}
	@Test
	public void LineContainsTextAfterOpenParentheseTest() {
		assertFalse("Line does start with parenthese",myDHCPConfig.LineContainsOnlyCloseParenthese("{more text "));
	}
	@Test
	public void LineOnlyContainsCloseParentheseTest() {
		assertTrue(myDHCPConfig.LineContainsOnlyCloseParenthese("}"));
	}
	@Test
	public void LineOnlyContainsCloseParentheseisCorrectTest() {
		assertTrue(myDHCPConfig.LineIsCorrect("}"));
	}
	@Test
	public void LineContainsTextBeforeCloseParentheseTest() {
		
		DHCPConfig myDHCPConfig = new DHCPConfig();
		
		assertFalse("Line does start with parenthese",myDHCPConfig.LineContainsOnlyCloseParenthese("something else}"));
	}
	@Test
	public void LineContainsTextAfterCloseParentheseTest() {
		assertFalse(myDHCPConfig.LineContainsOnlyCloseParenthese("} more text "));
	}
	@Test
	public void LineIsEmptyTest(){
		assertTrue(myDHCPConfig.LineIsEmpty("            "));
	}
	@Test
	public void EmptyLineIsCorrectTest(){
		assertTrue(myDHCPConfig.LineIsCorrect("            "));
	}
	@Test
	public void LineIsNotEmptyTest(){
		assertFalse(myDHCPConfig.LineIsEmpty("    A        "));

	}
	@Test
	public void OpenFileTest(){
		                     
		String FileLocation="dhcpdCorrectFile.conf";
		String Url;
		Url=DHCPConfigTest.class.getClassLoader().getResource( FileLocation).getPath();
		
		assertNotNull(myDHCPConfig.OpenFile(Url));

	}
	
	 
	@Test
	public void CorrectFileTest(){
		String FileLocation="dhcpdCorrectFile.conf";
		String Url;
		Url=DHCPConfigTest.class.getClassLoader().getResource( FileLocation).getPath();
		
		assertTrue(myDHCPConfig.VerifyFile(Url));

	}
	
	@Test
	public void LastErrorLineInCorrectFileisZeroTest(){
		String FileLocation="dhcpdCorrectFile.conf";
		String Url;
		Url=DHCPConfigTest.class.getClassLoader().getResource( FileLocation).getPath();
		
		assertEquals(0,myDHCPConfig.FindLastErrorLineInFile(Url));

	}
	
	
}

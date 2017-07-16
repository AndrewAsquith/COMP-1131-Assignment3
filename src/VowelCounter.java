//==============================================
// Andrew Asquith
// COMP 1131
// Assignment 3 
// Vowel Counter Class
//
// This is the working class for the vowel counter application.
// It accepts a string in it's constructor and counts the 
// number of lower case vowels contained within
// the results are available via the toString method
// 
//==============================================


public class VowelCounter {

	//number of lower case a found
	private int aCount = 0;
	
	//number of lower case e found
	private int eCount = 0;
	
	//number of lower case i found
	private int iCount = 0;
	
	//number of lower case o found
	private int oCount = 0;
	
	//number of lower case u found
	private int uCount = 0;
	
	//number of other characters found 
	//could have done the math with the length and all the vowels found, but we have to iterate anyways
	private int otherCount = 0;
	
	//string containing the input to parse
	private String theString;

	//constructor taking the string to parse
	public VowelCounter(String input) {
		

		//store the input so we can include it in the output
		theString = input;

		//iterate the whole string one character at a time
		for (int index = 0; index < input.length(); index++) {
			
			//increment the appropriate vowel if found
			switch (input.charAt(index)) {
			
			case 'a':
				aCount++;
				break;
				
			case 'e':
				eCount++;
				break;
				
			case 'i':
				iCount++;
				break;
				
			case 'o':
				oCount++;
				break;
				
			case 'u':
				uCount++;
				break;
				
			//increment the "other" counter if not a lower case vowel
			default:
				otherCount++;
				break;
			}
		}
	}

	//make it easy for the consuming class to pretty print the results
	public String toString() {

		//container to hold the result since we have to use conditionals for the "s"
		String prettyResult;

		//put the input on it's own line
		prettyResult = "\"" + theString + "\" has: " + System.lineSeparator();
		
		//write each count of the vowels, add an 's' where appropriate
		prettyResult += aCount + " 'a'";
		if (aCount != 1)
			prettyResult += "s";

		prettyResult += ", " + eCount + " 'e'";
		if (eCount != 1)
			prettyResult += "s";

		prettyResult += ", " + iCount + " 'i'";
		if (iCount != 1)
			prettyResult += "s";

		prettyResult += ", " + oCount + " 'o'";
		if (oCount != 1)
			prettyResult += "s";

		prettyResult += ", " + uCount + " 'u'";
		if (uCount != 1) {
			prettyResult += "s";
		}

		//and include the number of other characters
		prettyResult += " and " + otherCount + " other characters.";
		
		//return the whole "pretty" String to the caller
		return prettyResult;
	}
}
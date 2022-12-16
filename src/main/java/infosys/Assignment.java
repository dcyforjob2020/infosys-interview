package infosys;

import org.json.JSONObject;

/**
 * @author Jackie
 *
 */
public class Assignment {
	/**
	 * Returns a HashMap object that calculates length and substring of the longest
	 * substring of the input string without repeating characters
	 * 
	 * @author Jackie
	 * 
	 * @param s the input string
	 * @return JSONObject with two keys. key "maxLength" for the longest substring
	 *         length. key "maxSubString" for the longest substring
	 */
	private JSONObject longestSubstring(String s) {
		JSONObject jsonObj = new JSONObject();// return JSONObject

		int intputStringLength = s.length();// the length of the input string
		int maxLength = 0;// max length of the longest substring
		int maxStartIndex = 0;// the start index of the max substring
		int maxEndIndex = 0;// the end index of the max substring
		int startIndex = 0;// the start index of the substring

//		System.out.println("intputStringLength===>" + intputStringLength);

		for (int i = 0; i < intputStringLength; i++) {
			int iEndIndex = i + 1;// the end index of the substring
			String iCharacter = s.substring(i, iEndIndex);// the character
			String iSubstring = s.substring(startIndex, i);// the checking substring
			int iDuplicateIndex = iSubstring.indexOf(iCharacter);// the temporary start index of the substring

//			System.out.println("i===>" + i);
//			System.out.println("iCharacter===>" + iCharacter);
//			System.out.println("iSubstring===>" + iSubstring);
//			System.out.println("startIndex===>" + startIndex);
//			System.out.println("iDuplicateIndex===>" + iDuplicateIndex);

			if (iDuplicateIndex > -1) {
				// check if the substring has duplicate key
				startIndex = startIndex + iDuplicateIndex + 1;

				if (intputStringLength - startIndex - 1 < maxLength) {
					// no more longer substring
					break;
				}
			}

			int iMaxLength = iEndIndex - startIndex;// current substring length

			if (iMaxLength > maxLength) {
				// substring longer than current max length
				maxLength = iMaxLength;
				maxStartIndex = startIndex;
				maxEndIndex = iEndIndex;
			}
		}

		jsonObj.put("maxLength", maxLength);
		jsonObj.put("maxSubString", s.substring(maxStartIndex, maxEndIndex));

		return jsonObj;
	}

	public static void main(String[] args) {
		String s = "bbbbabcabcdcccccccccccccccccccccccccccabde";

		System.out.println(s.substring(1, 2));

		Assignment assignment = new Assignment();

		System.out.println(assignment.longestSubstring(s));
	}
}

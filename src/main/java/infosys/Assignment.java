package infosys;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class Assignment {

	/**
	 * Parsing log string into JSONArray
	 * 
	 * @author Jackie
	 * 
	 * @param s log string
	 * @return JSONArray
	 */
	private JSONArray parseLog(String s) {
		JSONArray jsonArr = new JSONArray();// return JSONArray

		String[] arrLine = s.split("\r?\n|\r");// split log to lines

		System.out.println(Arrays.toString(arrLine));

		for (int i = 0; i < arrLine.length; i++) {
			String[] iArr = arrLine[i].split("\\s+");
			JSONObject iJsonObj = new JSONObject();

			iJsonObj.put("url", iArr[0]);
			iJsonObj.put("time", Integer.parseInt(iArr[1]));
			iJsonObj.put("code", Integer.parseInt(iArr[2]));

			jsonArr.put(iJsonObj);
		}

		return jsonArr;
	}

	/**
	 * Count the number of occurrences of the domain grouping by http status code
	 * 
	 * @author Jackie
	 * 
	 * @param jsonLog log
	 * @return JSONObject
	 */
	private JSONObject countDomainGroupByCode(JSONArray jsonLog) {
		JSONObject jsonObj = new JSONObject();// return JSONObject

		for (int i = 0; i < jsonLog.length(); i++) {
			JSONObject iJsonObj = jsonLog.getJSONObject(i);//

			String iUrl = iJsonObj.getString("url");// request url
//			int iTime = iJsonObj.getInt("time");// response time
			int iCode = iJsonObj.getInt("code");// http status code
			URI iUri = null;// request url

			try {
				iUri = new URI(iUrl);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String iDomain = iUri.getHost();// the domain of the url

			if (jsonObj.isNull(iDomain)) {
				// if domain grouping by http status code is empty
				jsonObj.put(iDomain, new JSONObject());
			}

			JSONObject iJsonCode = jsonObj.getJSONObject(iDomain);// the number of occurrences of the domain grouping by
																	// http status code
			String iStrCode = String.valueOf(iCode);// http status code(string type)

			if (iJsonCode.isNull(iStrCode)) {
				// if domain grouping by http status code is empty
				iJsonCode.put(iStrCode, 0);
			}

			int iCount = iJsonCode.getInt(iStrCode);
			iCount++;
			iJsonCode.put(iStrCode, iCount);
		}

		return jsonObj;
	}

	/**
	 * Returns a JSONObject object that calculates length and substring of the
	 * longest substring of the input string without repeating characters
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
		// TODO Auto-generated method stub
//		char a = 'a';
//		Character character = 'a';
//
//		System.out.println(a == character);

		Assignment assignment = new Assignment();

		// test log parsing
		// @formatter:off
		String log = "http://www.yahoo.com/ 150 200\r\n" + 
				"https://www.yahoo.com/news/ 200 200\r\n" + 
				"https://sports.yahoo.com/ 10 200\r\n" + 
				"https://techcrunch.com/startups/ 30 200\r\n" + 
				"https://www.huffingtonpost.com/ 70 200\r\n" + 
				"https://www.huffingtonpost.co.uk/ 1000 200\r\n" + 
				"https://www.huffingtonpost.co.uk/entry/brexit-secretary?utm_hp_ref=uk-politics 500 404\r\n" + 
				"https://developer.github.com/apps/building-oauth-apps/ 40 200\r\n" + 
				"https://developer.github.com/v3/ 33 200\r\n" + 
				"https://developer.github.com:8080/v3/ 77 500\r\n";
		// @formatter:on

		// test longestSubstring
		JSONArray jsonLog = assignment.parseLog(log);
		System.out.println(assignment.countDomainGroupByCode(jsonLog));

		// test longestSubstring
//		String s = "bbbbabcabcdcccccccccccccccccccccccccccabde";
//		System.out.println(assignment.longestSubstring(s));

		int[] coins = { 25, 10, 5 };
//		System.out.println(assignment.MinimumNumberOfCoins(coins, 30));
	}
}

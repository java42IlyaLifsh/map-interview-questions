import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.Map.Entry;
class MapInterviewQuestionTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testOccurrencesCount() {
		String str = "lmn ab lmn aa; a, lmn ab.aa";
		String outputExp = "lmn -> 3\naa -> 2\nab -> 2\na -> 1\n";
		String outputActual = getOccurrences(str);
		assertEquals(outputExp, outputActual);
	}

	private String getOccurrences(String str) {
		String array[] = getWordsArray(str);
		Map<String, Integer> mapOccurrences = getMap(array);
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(mapOccurrences.entrySet());
		
		return getOutputString(list);
	}

	private String getOutputString(ArrayList<Entry<String, Integer>> list) {
		list.sort((e1, e2) -> e2.getValue() - e1.getValue());
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, Integer> entry: list) {
			builder.append(String.format("%s -> %d\n", entry.getKey(), entry.getValue()));
		}
		return builder.toString();
	}

	private Map<String, Integer> getMap(String[] array) {
		TreeMap<String, Integer> res = new TreeMap<>();
		for(String word: array) {
			Integer count = res.getOrDefault(word, 0);
			res.put(word, count + 1);
		}
		return res;
	}

	private String[] getWordsArray(String str) {
		String delimiter = "[^a-zA-Z]+";
		return str.split(delimiter);
	}

}

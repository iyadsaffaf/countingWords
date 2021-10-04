package wordcounter;

import java.util.*;

/*
 * The WordFrequencyAnalyzerImp class is made to analyze words frequency in a certain text
 *
 * @author Iyad Saffaf
 */

public class WordFrequencyAnalyzerImp implements WordFrequencyAnalyzer {

    /**
     * Comparator is added to treemap to sort the list by its frequency
     *
     * @param map A map containing the whole words in text
     * @return A sorted map by frequency
     */
    private static <K, V extends Comparable<V>> Map<K, V>
    Sort(final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            int comp = map.get(k2).compareTo(
                    map.get(k1));
            if (comp == 0)
                return 1;
            else
                return comp;
        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    /**
     * Calculate the highest frequency in text
     *
     * @param text A string containing the whole text
     * @return the number of the highest frequency .
     */
    @Override
    public int calculateHighestFrequency(String text) {
        Map<String, Integer> sortedMap = Sort(ConvertTextToWords(text));
        Map.Entry<String, Integer> highest = sortedMap.entrySet().iterator().next();
        return  highest.getValue();
    }

    /**
     * Calculate the highest frequency in text for a specific word
     *
     * @param text A string containing the whole text
     * @param word A string containing a search word
     * @return the frequency's number of specific word .
     */
    @Override
    public int calculateFrequencyForWord(String text, String word) {
        Map<String, Integer> sortedMap = ConvertTextToWords(text);
        sortedMap.get(word);
        return sortedMap.get(word);
    }

    /**
     * Calculate the most frequencies in text for a specific list of words
     *
     * @param text A string containing the whole text
     * @param n    A number specify the size of the list of the most frequent words
     * @return A list contains the most frequent words .
     */
    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        Map<String, Integer> sortedMap = Sort(ConvertTextToWords(text));

        Set<Map.Entry<String, Integer>> set = sortedMap.entrySet();
        Iterator<Map.Entry<String, Integer>> i = set.iterator();
        List<WordFrequency> wordFrequencies = new LinkedList<>();
        for (int j = 0; j < n; j++) {
            if (i.hasNext()) {
                Map.Entry<String, Integer> mp = i.next();
                wordFrequencies.add(new WordFrequencyImp(mp.getKey(), mp.getValue()));
            }
        }

        return wordFrequencies;
    }

    /**
     * Convert Text to array of string
     * the function starts with splitting the text to words then add all words to a sorted map.
     *
     * @param text A string containing the whole text
     * @return A map contains all the words in the text.
     */
    private Map<String, Integer> ConvertTextToWords(String text) {
        SortedMap<String, Integer> map = new TreeMap<>();
        String[] words = text.toLowerCase().split("[^a-zA-Z]+");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else
                map.put(word, 1);
        }
        return map;
    }
}

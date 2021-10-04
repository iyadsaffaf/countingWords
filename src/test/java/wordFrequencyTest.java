import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordcounter.WordFrequencyAnalyzerImp;
import wordcounter.WordFrequencyImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@DisplayName("A special test case for Ordina assignment")
public class wordFrequencyTest {

    private String text;
    private WordFrequencyAnalyzerImp wordFrequencyAnalyzerImp;

    @BeforeEach
    void init() {
        text = "Hi I  am a test test a,a,a,a hi";
        wordFrequencyAnalyzerImp = new WordFrequencyAnalyzerImp();
    }

    @Test
    void testCalculateHighestFrequency() {

        assertEquals(5, wordFrequencyAnalyzerImp.calculateHighestFrequency(text));
    }

    @Test
    void testCalculateHighestFrequencyWithDifferentDelimiters() {
        text=" Hi*hi%hI*hi";
        assertEquals(4, wordFrequencyAnalyzerImp.calculateHighestFrequency(text));
    }


    @Test
    void testCalculateMostFrequentNWordsArraySize() {
        text = "The sun shines over the lake";
        assertEquals(3, wordFrequencyAnalyzerImp.calculateMostFrequentNWords(text, 3).size());
    }

    @Test
    void testCalculateMostFrequentNWords() {
        text = "The sun shines over the lake the ";
        WordFrequencyImp wordFrequencyImp= new WordFrequencyImp("the",3);
        assertEquals(wordFrequencyImp, wordFrequencyAnalyzerImp.calculateMostFrequentNWords(text, 1).get(0));
    }

    @Test
    void testCalculateFrequencyForWord() {
        text = "The/sun?shines#over%the*lake";
        assertEquals(2, wordFrequencyAnalyzerImp.calculateFrequencyForWord(text, "the"));
    }
    @Test
    void testCalculateFrequencyForWordFail() {
        text = "The/sun?shines#over%the*lake";
        assertNotEquals(1, wordFrequencyAnalyzerImp.calculateFrequencyForWord(text, "the"));
    }
}

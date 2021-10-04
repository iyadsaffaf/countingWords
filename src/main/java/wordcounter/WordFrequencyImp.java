package wordcounter;

import java.util.Objects;

public class WordFrequencyImp implements WordFrequency {

    private final String word;
    private final int frequency;

    public WordFrequencyImp(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordFrequencyImp that = (WordFrequencyImp) o;
        return frequency == that.frequency && word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency);
    }

    @Override
    public String toString() {
        return "WordFrequencyImp{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}

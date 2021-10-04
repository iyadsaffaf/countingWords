package com.example.textanalyzer;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import wordcounter.WordFrequency;
import wordcounter.WordFrequencyAnalyzer;

import java.util.List;

@Path("/wordAnalyzer")

public class WordFrequencyAnalyzerResource {
    private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @Inject
    public WordFrequencyAnalyzerResource(WordFrequencyAnalyzer wordFrequencyAnalyzer) {
        this.wordFrequencyAnalyzer = wordFrequencyAnalyzer;
    }

    @GET
    @Path("/calculateHighestFrequency")
    @Produces("text/plain")
    public int calculateHighestFrequency(@QueryParam("text") String text) {
        return this.wordFrequencyAnalyzer.calculateHighestFrequency(text);
    }

    @GET
    @Path("/calculateFrequencyForWord/{word}")
    @Produces("text/plain")
    public int calculateFrequencyForWord(@PathParam("word") String word, @QueryParam("text") String text) {
        return this.wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
    }

    @GET
    @Path("/calculateMostFrequentNWords/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<WordFrequency> calculateMostFrequentNWords(@PathParam("n") int n, @QueryParam("text") String text) {

        return this.wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);
    }

}

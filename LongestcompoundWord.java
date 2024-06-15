import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

class LongestCompoundedWord {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String f1 = "C:\\Users\\SAHIL SINGH\\IdeaProjects\\trailProject\\src\\Input_01.txt";
        String f2 = "C:\\Users\\SAHIL SINGH\\IdeaProjects\\trailProject\\src\\Input_02.txt";

        List<String> words1 = readWords(f1);
        List<String> words2 = readWords(f2);
        List<String> allWords = new ArrayList<>(words1);
        allWords.addAll(words2);
        String[] result = findLongestCompoundedWords(allWords);

        long enTime = System.currentTimeMillis();
        long processingTime = enTime - startTime;

        System.out.println("Longest compounded word: " + result[0]);
        System.out.println("Second longest compounded word: " + result[1]);
        System.out.println("Time taken to process the input file: " + processingTime + " milliseconds");}
    public static List<String> readWords(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);}
        } catch (IOException e) {
            e.printStackTrace();}
        return words;
    }

    public static String[] findLongestCompoundedWords(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        List<String> compoundedWords = new ArrayList<>();
        HashMap<String, Boolean> memo = new HashMap<>();
        for (String word : words) {
            if (isCompoundedWord(word, wordSet, memo)) {
                compoundedWords.add(word);
            }
        }
        compoundedWords.sort((a, b) -> b.length() - a.length());
        String longest = compoundedWords.size() > 0 ? compoundedWords.get(0) : "";
        String secondLongest = compoundedWords.size() > 1 ? compoundedWords.get(1) : "";
        return new String[]{longest, secondLongest};
    }
    public static boolean isCompoundedWord(String word, Set<String> wordSet, HashMap<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);}
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (wordSet.contains(prefix)) {
                if (wordSet.contains(suffix) || isCompoundedWord(suffix, wordSet, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }
        memo.put(word, false);
        return false;
    }
}

Main Method:-
The main method initializes start time (startTime) using System.currentTimeMillis().
It defines two file paths (f1 and f2) pointing to text files containing words (Input_01.txt and Input_02.txt).
It reads the words from these files into words1 and words2 lists using the readWords method.
All words are combined into allWords list. Calls findLongestCompoundedWords with allWords to find and return the longest and second longest compounded words.
Calculates the processing time (processingTime) by subtracting startTime from the current time (enTime).
Finally, prints the results and processing time.

Reading Words from Files:
The readWords method takes a file path (filePath) as input.
It initializes an empty list words.
Uses a BufferedReader to read each line from the file and adds each line (representing a word) to the words list.
Catches and prints any IOException that may occur during file reading.
Returns the populated words list.

Finding Longest Compounded Words:
The findLongestCompoundedWords method takes a list of words (words) as input.
Converts words into a Set called wordSet to facilitate quick lookup operations.
Initializes an empty list compoundedWords to store found compounded words.
Uses a HashMap called memo to store previously computed results for efficiency.
Iterates through each word in words.
For each word, checks if it's a compounded word using the isCompoundedWord method.
If a word is compounded, adds it to compoundedWords.
Sorts compoundedWords in descending order based on word length.
Retrieves the longest and second longest compounded words from compoundedWords (or empty strings if not found).
Returns an array containing the longest and second longest compounded words.

Checking if a Word is Compounded:
The isCompoundedWord method checks if a given word is compounded using:
memo to cache results to avoid redundant computations.
Iterates through possible prefixes of the word.
For each prefix, checks if it exists in wordSet.
If a valid prefix is found, recursively checks if the remaining suffix (word.substring(i)) is either in wordSet or itself a compounded word (recursively using isCompoundedWord).
Updates memo with the result for each word.
Returns true if word is compounded, false otherwise.
Output:

In the Last, the main method prints:
The longest compounded word found (result[0]).
The second longest compounded word found (result[1]).

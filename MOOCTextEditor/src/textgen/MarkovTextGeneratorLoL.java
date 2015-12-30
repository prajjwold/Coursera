package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An implementation of the MTG interface that uses a list of lists.
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<WordNode> wordList;

	// The starting "word"
	private String starter;

	// The random number generator
	private Random rnGenerator;

	public MarkovTextGeneratorLoL(Random generator) {
		wordList = new LinkedList<WordNode>();
		starter = "";
		rnGenerator = generator;
	}

	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText) {
		// TODO: Implement this method
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile("[^ ]+");
		Matcher m = tokSplitter.matcher(sourceText);
		tokens.add("");
		while (m.find()) {
			tokens.add(m.group());
		}

		WordNode firstNode = new WordNode(starter);
		wordList.add(firstNode);

		WordNode node;
		WordNode newNode;
		for (int i = 0; i < tokens.size() - 1; i++) {
			boolean isFound = false;
			starter = tokens.get(i);
			for (int j = 0; j < wordList.size(); j++) {
				node = wordList.get(j);
				if (node.getWord().equals(starter)) {
					node.addNextWord(tokens.get(i + 1));
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				newNode = new WordNode(starter);
				newNode.addNextWord(tokens.get(i + 1));
				wordList.add(newNode);
			}
		}
		// WordNode lastNode = new WordNode(tokens.get(tokens.size() - 1));
		// lastNode.addNextWord("");
		// wordList.add(lastNode);
	}

	/**
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		starter = "";
		String output = "";

		if(wordList.size() <= 1){
			return output;
		}
		for (int i = 0; i < numWords; i++) {
			WordNode node = new WordNode(null);
			boolean isFound = false;
			for (int j = 0; j < wordList.size(); j++) {
				if (wordList.get(j).getWord().equals(starter)) {
					node = wordList.get(j);
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				node = wordList.get(0);
			}
			String randomWord = node.getRandomNextWord(new Random());
			output += randomWord + " ";
			starter = randomWord;
		}
		return output.trim();
	}

	// Can be helpful for debugging
	@Override
	public String toString() {
		String toReturn = "";
		for (WordNode n : wordList) {
			toReturn += n.toString();
		}
		return toReturn;
	}

	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText) {
		starter = "";
		wordList = new LinkedList<WordNode>();
		train(sourceText);
	}

	// TODO: Add any private helper methods you need here.

	/**
	 * This is a minimal set of tests. Note that it can be difficult to test
	 * methods/classes with randomized behavior.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		// String textString = "Hello. Hello there. This is a test. Hello there.
		// Hello Bob. Test again.";
		String textString = "hi there hi Leo";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(4));
	}

}

/**
 * Links a word to the next words in the list You should use this class in your
 * implementation.
 */
class WordNode {
	// The word that is linking to the next words
	private String word;

	// The next words that could follow it
	private List<String> nextWords;

	WordNode(String word) {
		this.word = word;
		nextWords = new LinkedList<String>();
	}

	public String getWord() {
		return word;
	}

	public void addNextWord(String nextWord) {
		nextWords.add(nextWord);
	}

	public String getRandomNextWord(Random generator) {
		int rand = generator.nextInt(nextWords.size());
		return nextWords.get(rand);
	}

	public String toString() {
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}

}

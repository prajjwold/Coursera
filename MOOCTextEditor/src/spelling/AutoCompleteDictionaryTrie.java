package spelling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An trie data structure that implements the Dictionary and the AutoComplete
 * ADT
 * 
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements Dictionary, AutoComplete {

	private TrieNode root;
	private int size;

	public AutoCompleteDictionaryTrie() {
		root = new TrieNode();
		size = 0;
	}

	/**
	 * Insert a word into the trie. For the basic part of the assignment (part
	 * 2), you should ignore the word's case. That is, you should convert the
	 * string to all lower case as you insert it.
	 */
	@Override
	public boolean addWord(String word) {
		// TODO: Implement this method.
		// char words[] = word.toLowerCase().toCharArray();
		// TrieNode currNode = root;
		// boolean newWord = false;
		// if (currNode == null)
		// return false;
		// for (char c : words) {
		// if (currNode.getChild(c) == null) {
		// TrieNode newNode = currNode.insert(c);
		// newNode.setEndsWord(false);
		// currNode = newNode;
		// newWord = true;
		// } else {
		// currNode = currNode.getChild(c);
		// }
		// }
		// // if(newWord){
		// // currNode.setEndsWord(true);
		// // size++;
		// // return newWord;
		// // }
		// currNode.setEndsWord(true);
		// size++;
		// return newWord;

		boolean result = false;
		TrieNode prevN = root;
		TrieNode nextN = null;
		word = word.toLowerCase();
		for (char ch : word.toCharArray()) {
			nextN = prevN.insert(ch);
			if (nextN == null) {
				nextN = prevN.getChild(ch);
			}
			prevN = nextN;
		}
		if (!nextN.endsWord()) {
			nextN.setEndsWord(true);
			size++;
			result = true;
		}
		return result;
	}

	/**
	 * Return the number of words in the dictionary. This is NOT necessarily the
	 * same as the number of TrieNodes in the trie.
	 */
	@Override
	public int size() {
		// TODO: Implement this method
		return size;
	}

	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) {
		// TODO: Implement this method
		char words[] = s.toLowerCase().toCharArray();
		TrieNode currNode = root;
		for (int i = 0; i < words.length; i++) {
			if (currNode.getChild(words[i]) == null) {
				return false;
			} else {
				currNode = currNode.getChild(words[i]);
			}
		}
		return currNode.endsWord();
	}

	/**
	 * * Returns up to the n "best" predictions, including the word itself, in
	 * terms of length If this string is not in the trie, it returns null.
	 * 
	 * @param text
	 *            The text to use at the word stem
	 * @param n
	 *            The maximum number of predictions desired.
	 * @return A list containing the up to n best predictions
	 */
	@Override
	public List<String> predictCompletions(String prefix, int numCompletions) {
		// TODO: Implement this method
		// This method should implement the following algorithm:
		// 1. Find the stem in the trie. If the stem does not appear in the
		// trie, return an
		// empty list
		// 2. Once the stem is found, perform a breadth first search to generate
		// completions
		// using the following algorithm:
		// Create a queue (LinkedList) and add the node that completes the stem
		// to the back
		// of the list.
		// Create a list of completions to return (initially empty)
		// While the queue is not empty and you don't have enough completions:
		// remove the first Node from the queue
		// If it is a word, add it to the completions list
		// Add all of its child nodes to the back of the queue
		// Return the list of completions
		TrieNode currNode = root;
		List<String> result = new ArrayList<String>();
		char words[] = prefix.toLowerCase().toCharArray();
		for (char c : words) {
			if (currNode.getChild(c) != null) {
				currNode = currNode.getChild(c);
			} else
				return result;
		}
		Queue<TrieNode> queue = new LinkedList<TrieNode>();
		if (currNode != null)
			queue.add(currNode);
		while (!queue.isEmpty() && result.size() < numCompletions) {
			TrieNode node = queue.remove();
			if (node.endsWord()) {
				result.add(node.getText());
			}
			for (Character c : node.getValidNextCharacters()) {
				queue.add(node.getChild(c));
			}
		}
		return result;
	}

	// For debugging
	public void printTree() {
		printNode(root);
	}

	/** Do a pre-order traversal from this node down */
	public void printNode(TrieNode curr) {
		if (curr == null)
			return;

		System.out.println(curr.getText());

		TrieNode next = null;
		for (Character c : curr.getValidNextCharacters()) {
			next = curr.getChild(c);
			printNode(next);
		}
	}
}
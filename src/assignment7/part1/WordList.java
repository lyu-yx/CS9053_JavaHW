package assignment7.part1;

import java.io.*;
import java.net.URL;
import java.text.Collator;
import java.util.*;

/**
 * A WordList is a set of words loaded from a file and searchable by
 * substring.  A word is defined as a sequence of letters
 * (upper case or lower case).  WordSets ignore alphabetic case when
 * comparing, searching, or sorting.
 */
public class WordList {
    private List words;

    /*
     * Rep invariant:
     *      words != null
     */

    /**
     * Make an empty WordList.
     */
    public WordList() {
    }

    public List getWords() {
        return words;
    }

    /**
     * Load a file into this word set.
     * @effects Removes all the words from this word set and replaces
     * them with the words found in the given file.
     * @param in File to load
     * @throws IOException if file cannot be opened
     */
    public void load(InputStream in) throws IOException {
        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);
        Set s = new TreeSet(c);

        StreamTokenizer tok = new StreamTokenizer(new InputStreamReader(in));
        tok.resetSyntax();
        tok.wordChars('a', 'z');
        tok.wordChars('A', 'Z');
        tok.wordChars('\'', '\'');

        while (tok.nextToken() != StreamTokenizer.TT_EOF) {
            if (tok.ttype == StreamTokenizer.TT_WORD)
                s.add(tok.sval);
        }

        words = new ArrayList(s);
    }

    /**
     * Find words containing a given substring.
     * @param s Substring to search for
     * @return list of words in this word set (sorted case-insensitively)
     * that contain the substring s (matched case-insensitively).  A
     * word appears at most once in the returned list.
     */
    public List find(String s) {
        if (s.length() == 0) {
            return Collections.unmodifiableList(words);
        }

        s = s.toLowerCase();
        List l = new ArrayList();
        for (Iterator i = words.iterator(); i.hasNext(); ) {
            String word = (String) i.next();
            if (word.toLowerCase().indexOf(s) != -1)
                l.add(word);
        }
        return l;
    }

    /**
     * Main method.  Demonstrates how to use this class.
     * @param args Command-line arguments.  Ignored.
     */
    public static void main(String[] args) {
        WordList words = new WordList ();

        // Create the word list from a resource.
        // The words file must be in the same directory (or jar file directory)
        // as this class.
        URL url = WordList.class.getResource("words");
        if (url == null)
            throw new RuntimeException("Missing resource: words");
        try {
            words.load(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print all the words containing "ph"
        List matches = words.find("holst");
        for (Iterator i = matches.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }
    }
}
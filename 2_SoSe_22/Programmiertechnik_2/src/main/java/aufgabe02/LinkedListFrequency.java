package aufgabe02;

import aufgabe01.AbstractFrequencyTable;
import aufgabe01.Word;

/**
 * @author Christopher Mogler
 * @since 30.03.2022
 */
public class LinkedListFrequency extends AbstractFrequencyTable {
    private int size = 0;
    private LinkedNode<Word> firstItem = null;
    private LinkedNode<Word> lastItem = null;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        size = 0;
        firstItem = null;
        lastItem = null;
    }

    private boolean compare(LinkedNode<Word> alpha, Word newWord) {
        if(alpha.data.getFrequency() < newWord.getFrequency()) {
            return true;
        }
        return false;
    }

    @Override
    public void add(String w, int f) {
        Word newWord = new Word(w, f);

        if (this.firstItem == null) {
            this.firstItem = new LinkedNode<Word>(newWord, null, null);
            ++this.size;
            return;
        }
        // Test if word exist in the list
            // when true, sort complete
        // when false, insert there where it is bigger
        boolean needMoreData = true;

        // Test if word exist in the list,
        LinkedNode<Word> forNode = this.firstItem;
        while (forNode != null) {
            if (forNode.data.equals(newWord)) {
                // the word exist in the list
                // it adds the frequency and seed needMoreData = false
                // it sorts the new value
                forNode.data.addFrequency(f);
                newWord = forNode.data;

                var alpha = forNode.prev;
                while (alpha != null && this.compare(alpha, newWord)) {
                    // Sorting...
                    alpha.switchWithNext();
                    if(alpha.prev == null) {
                        this.firstItem = alpha;
                        alpha = null;
                    } else {
                        alpha = alpha.prev;
                    }
                }

                needMoreData = false;
                break;
            }
            forNode = forNode.next;
        }

        if (needMoreData) {
            // if the word does not exist, insert the new word
            forNode = this.firstItem;
            while (forNode != null) {
                if (this.compare(forNode, newWord)) {
                    var t = forNode.insertBefore(newWord);
                    if(t.prev == null) {
                        this.firstItem = t;
                    }
                    break;
                }
                if (forNode.next == null) {
                    forNode.insertAfter(newWord);
                    break;
                }

                forNode = forNode.next;
            }
            ++this.size;
        }
    }

    @Override
    public Word get(int pos) throws IndexOutOfBoundsException{
        if (pos + 1 > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        LinkedNode<Word> curr = this.firstItem;
        if(pos > 0) {
            for (int i = 0; i < pos; ++i) {
                curr = curr.next;
                if(curr == null) {
                    return null;
                }
            }
        }
        return curr.getData();
    }

    @Override
    public int get(String w) {
        int res = 0;
        LinkedNode<Word> alpha = this.firstItem;
        while(alpha != null) {
            if (alpha.data.getWord().equals(w)) {
                res = alpha.data.getFrequency();
                break;
            }
            alpha = alpha.next;
        }
        return res;
    }
}

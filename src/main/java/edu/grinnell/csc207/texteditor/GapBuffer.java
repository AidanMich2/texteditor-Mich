package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    private int size;
    private int sizeOfArray;
    private static char[] arr;
    private int firstIndexGap;
    private int firstAfterGap;

    /**
     * Constructs a GapBuffer with 0 elemeents, but space for 4 elements.
     */

    public GapBuffer() {
        this.size = 0;
        this.sizeOfArray = 4;
        arr = new char[sizeOfArray];
        this.firstIndexGap = 0;
        this.firstAfterGap = sizeOfArray;
    }
    
    /**
     * Inserts a character at the position of the firstIndexGap
     * @param ch The character that is to be inserted
     */
    public void insert(char ch) {
        size++;
        if (size != sizeOfArray) {
            arr[firstIndexGap] = ch;
            firstIndexGap++;
        } else {
            expand();
            arr[firstIndexGap] = ch;
            firstIndexGap++;
        }
    }

    /**
     * Expands the capacity of the array by doubling it.
     */

    public void expand() {
        char[] newArray = new char[sizeOfArray * 2];
        for (int i = 0; i < firstIndexGap; i++) {
            newArray[i] = arr[i];
        }
        int temp = firstAfterGap;
        firstAfterGap += sizeOfArray;
        sizeOfArray = sizeOfArray * 2;
        for (int i = firstAfterGap; i < sizeOfArray; i++) {
            newArray[i] = arr[temp];
            temp++;
        }
        arr = newArray;
    }

    /**
     * Deletes the character that is before the cursor position.
     */
    public void delete() {
        if (size > 0) {
            if (firstIndexGap > 0) {
                firstIndexGap--;
                size--;
            }
        }
    }

    /**
     * Return the cursor position.
     * @return the cursor position.
     */
    public int getCursorPosition() {
        return firstIndexGap;
    }

    /**
     * Moves the cursor one space to the left.
     */
    public void moveLeft() {
        if (firstIndexGap == 0) {
            return;
        }
        arr[--firstAfterGap] = arr[--firstIndexGap];
    }

    /**
     * Moves the cursor one space to the right.
     */
    public void moveRight() {
        if (firstIndexGap == size) {
            return;
        }
        arr[firstIndexGap++] = arr[firstAfterGap++];
    }

    /**
     * Returns the size of the buffer.
     * @return the number of elements in the buffer.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the character at the specified index.
     * @param i the index.
     * @return the character at that index.
     */
    public char getChar(int i) {
        if (i >= 0 && i < size) {
            if (i < firstIndexGap) {
                return arr[i];
            } else {
                return arr[i + firstAfterGap-firstIndexGap];
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the full buffer as a string.
     * @return the buffer as string.
     */
    @Override
    public String toString() {
        if (getSize() == 0) {
            return "";
        }
        String str = "";
        for (int i = 0; i < firstIndexGap; i++) {
            str += arr[i];
        }
        for (int i = firstAfterGap; i < sizeOfArray; i++) {
            str += arr[i];
        }
        return str;
    }

    /**
     * Gets the FirstIndexGap.
     * @return the FirstIndexGap.
     */
    public int getFirstIndexGap() {
        return this.firstIndexGap;
    }

    /**
     * Gets the firstAfterGap.
     * @return the firstAfterGap.
     */
    public int getFirstAfterGap() {
        return this.firstAfterGap;
    }

    /**
     * Gets the sizeOfArray.
     * @return the sizeOfArray.
     */
    public int getSizeOfArray() {
        return this.sizeOfArray;
    }
}

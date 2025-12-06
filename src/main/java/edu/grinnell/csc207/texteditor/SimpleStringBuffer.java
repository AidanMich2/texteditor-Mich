package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    private int size;
    private int position;
    private String str;
    
    /**
     * Constructs a simple string buffer with all fields set to 0 or null.
     */
    public SimpleStringBuffer() {
        this.size = 0;
        this.position = 0;
        this.str = "";
    }
    
    /**
     * Inserts a character at the position of the cursor.
     * @param ch is the character we are inserting.
     */
    public void insert(char ch) {
        String newStr = "";
        for (int i = 0; i < position; i++) {
            newStr += str.charAt(i);
        }
        newStr += ch;
        for (int i = position; i < str.length(); i++) {
            newStr += str.charAt(i);
        }
        this.str = newStr;
        position++;
        size++;
    }

    /**
     * Deletes the character before the position of the cursor.
     */
    public void delete() {
        if (position != 0) {
            String newStr = "";
            for (int i = 0; i < position - 1; i++) {
                newStr += str.charAt(i);
            }
            for (int i = position; i < size; i++) {
                newStr += str.charAt(i);
            }
            this.str = newStr;
            position--;
            size--;
        }
    }

    /**
     * Gets the position of the cursor.
     * @return the position of the cursor.
     */
    public int getCursorPosition() {
        return position;
    }

    /**
     * Moves the cursor one space to the left.
     */
    public void moveLeft() {
        if (position == 0) {
            return;
        }
        position--;
    }

    /**
     * Moves the cursor one space to the right.
     */
    public void moveRight() {
        if (position == str.length()) {
            return;
        }
        position++;
    }

    /**
     * Gets the size of the buffer.
     * @return the size of buffer.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the character at a specified index.
     * @param i is the index.
     * @return the character at the index.
     */
    public char getChar(int i) {
        if (i >= 0 && i < str.length()) {
            return str.charAt(i);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the entire buffer as a string.
     * @return the buffer as string.
     */
    @Override
    public String toString() {
        if (str.equals(null)) {
            return "";
        } else {
            String newStr = "";
            for (int i = 0; i < size; i++) {
                newStr += str.charAt(i);
            }
            return newStr;   
        }   
    }
}

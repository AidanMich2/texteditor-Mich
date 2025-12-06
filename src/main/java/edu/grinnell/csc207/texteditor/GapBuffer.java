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

    public GapBuffer() {
        this.size = 0;
        this.sizeOfArray = 4;
        arr = new char[sizeOfArray];
        this.firstIndexGap = 0;
        this.firstAfterGap = sizeOfArray;
    }
    public void insert(char ch) {
        size++;
        if (size != sizeOfArray) {
            arr[firstIndexGap] = ch;
            firstIndexGap++;
        }
        else {
            expand();
            arr[firstIndexGap] = ch;
            firstIndexGap++;
        }
    }

    public void expand() {
        char [] newArray = new char[sizeOfArray * 2];
        for (int i = 0; i < firstIndexGap; i++) {
            newArray[i] = arr[i];
        }
        int temp = firstAfterGap;
        firstAfterGap += sizeOfArray;
        sizeOfArray = sizeOfArray *2;
        for (int i = firstAfterGap; i < sizeOfArray; i++) {
            newArray[i] = arr[temp];
            temp++;
        }
        arr = newArray;
    }

    public void delete() {
        if (size > 0) {
            if (firstIndexGap > 0) {
                firstIndexGap--;
                size--;
            }
        }
    }

    public int getCursorPosition() {
        return firstIndexGap;
    }

    public void moveLeft() {
        if (firstIndexGap == 0) {
            return;
        }
        arr[--firstAfterGap] = arr[--firstIndexGap];
    }

    public void moveRight() {
        if (firstIndexGap == size) {
            return;
        }
        arr[firstIndexGap++] = arr[firstAfterGap++];
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        if (i >= 0 && i < size) {
            if (i < firstIndexGap) {
                return arr[i];
            }
            else{
                return arr[i + firstAfterGap-firstIndexGap];
            }
        }
        else{
            throw new IndexOutOfBoundsException ();
        }
    }

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

    public int getFirstIndexGap() {
        return this.firstIndexGap;
    }

    public int getFirstAfterGap() {
        return this.firstAfterGap;
    }

    public int getSizeOfArray() {
        return this.sizeOfArray;
    }
}

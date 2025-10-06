package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    private int size;
    private int sizeOfArray;
    private char [] arr;
    private int firstIndexGap;
    private int firstAfterGap;
    private int position;

    public GapBuffer (){
        this.size = 0;
        this.sizeOfArray = 100;
        arr = new char [sizeOfArray];
        this.position = 0;
    }
    public void insert(char ch) {
        if (firstAfterGap - firstIndexGap > 0){
            arr[firstIndexGap] = ch;
            size++;
        }
        else{
            expand ();
            sizeOfArray = sizeOfArray *2;
            arr[firstIndexGap] = ch;
            size++;
        }
    }

    public void expand (){
        char [] newArray = new char [sizeOfArray * 2];
        for (int i = 0; i <= firstIndexGap; i++){
            newArray [i] = arr[i];
        }
        firstAfterGap = sizeOfArray + firstIndexGap;
        for (int i = firstAfterGap; i <= sizeOfArray; i++){
            newArray [i] = arr[i];
        }
        arr = newArray;
    }

    public void delete() {
        firstIndexGap--;
        size--;
    }

    public int getCursorPosition() {
        return position;
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        if (i >= 0 && i < size){
            return arr[i];
        }
        else{
            throw new IndexOutOfBoundsException ();
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i <firstIndexGap; i++){
            str += arr[i];
        }
        for(int i = firstAfterGap; i< sizeOfArray; i++){
            str += arr[i];
        }
        return str;
    }
}

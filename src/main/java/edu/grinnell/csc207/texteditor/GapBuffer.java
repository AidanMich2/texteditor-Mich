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

    public GapBuffer (){
        this.size = 0;
        this.sizeOfArray = 4;
        arr = new char [sizeOfArray];
        this.firstIndexGap = 0;
        this.firstAfterGap = sizeOfArray;
    }
    public void insert(char ch) {
        // if (firstAfterGap - firstIndexGap > 0){
        size++;
        if (size != sizeOfArray){
            arr[firstIndexGap] = ch;
            firstIndexGap++;
        }
        else{
            expand ();
            sizeOfArray = sizeOfArray *2;
            arr[firstIndexGap] = ch;
            firstIndexGap++;
        }
    }

    public void expand (){
        char [] newArray = new char [sizeOfArray * 2];
        for (int i = 0; i <= firstIndexGap; i++){
            newArray [i] = arr[i];
        }
        firstAfterGap = firstAfterGap *2;
        for (int i = firstAfterGap; i < sizeOfArray; i++){
            newArray [i] = arr[i];
        }
        arr = newArray;
    }

    public void delete() {
        firstIndexGap--;
        size--;
    }

    public int getCursorPosition() {
        return firstIndexGap;
    }

    public void moveLeft() {
        if (firstIndexGap == 0){
            return;
        }
        arr [--firstAfterGap] = arr[--firstIndexGap];
    }

    public void moveRight() {
        if (firstIndexGap == size){
            return;
        }
        arr [++firstIndexGap] = arr[++firstAfterGap];
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        if (i >= 0 && i < size){
            if (i < firstIndexGap){
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
        if (getSize ()== 0){
            return "▮";
        }
        String str = "";
        for (int i = 0; i <firstIndexGap; i++){
            str += arr[i];
        }
        str += "▮";
        for(int i = firstAfterGap; i< sizeOfArray; i++){
            str += arr[i];
        }
        return str;
    }
}

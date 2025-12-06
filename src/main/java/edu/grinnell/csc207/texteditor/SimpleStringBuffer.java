package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    // private SimpleStringBuffer buff;
    private int size;
    private int position;
    private String str;
    
    // private int
    public SimpleStringBuffer(){
        this.size = 0;
        this.position = 0;
        this.str = "";
    }
    
    public void insert(char ch) {
        String newStr = "";
        for(int i = 0; i < position; i++){
            newStr += str.charAt (i);
        }
        newStr += ch;
        for(int i = position; i < str.length (); i++){
            newStr += str.charAt (i);
        }
        this.str = newStr;
        position++;
        size++;
    }

    public void delete() {
        if (position != 0){
            String newStr = "";
            for(int i = 0; i < position-1; i++){
                newStr += str.charAt (i);
            }
            for(int i = position; i < size; i++){
                newStr += str.charAt (i);
            }
            this.str = newStr;
            position--;
            size--;
        }
    }

    public int getCursorPosition() {
        return position;
    }

    public void moveLeft() {
        if (position == 0){
            return;
        }
        position--;
    }

    public void moveRight() {
        if (position == str.length ()){
            return;
        }
        position++;
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        if (i >= 0 && i < str.length ()){
            return str.charAt (i);
        }
        else{
            throw new IndexOutOfBoundsException ();
        }
    }

    @Override
    public String toString() {
        if (str.equals (null)){
            return "";
        }
        else {
            String newStr = "";
            for(int i = 0; i < size; i++){
                newStr += str.charAt (i);
            }
            // for(int i = position; i < str.length (); i++){
            //     newStr += str.charAt (i);
            // }
            return newStr;   
        }   
    }
}

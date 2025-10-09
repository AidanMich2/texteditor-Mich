package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GapBufferTests {

     @Test
    public void emptyString (){
        GapBuffer gappy = new GapBuffer ();
        assertEquals ("▮", gappy.toString ());
    }

    @Test
    public void addOne (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        // gappy.insert ('b');

        assertEquals ("a▮", gappy.toString ());
    }

    @Test
    public void addMany (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');

        assertEquals ("abcd▮", gappy.toString ());
    }

    @Test
    public void checkSize (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');

        assertEquals (4, gappy.getSize());
    }

    @Test
    public void checkSizeEmptyCase (){
        GapBuffer gappy = new GapBuffer ();

        assertEquals (0, gappy.getSize());
    }

    @Test
    public void checkLeft (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');
        gappy.moveLeft ();
        assertEquals ("abc▮d", gappy.toString ());
    }

    @Test
    public void checkLeftExpanded (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');
        gappy.moveLeft ();
        gappy.insert ('e');
        gappy.insert ('f');
        gappy.insert ('g');
        gappy.insert ('h');
        assertEquals ("abcefgh▮d", gappy.toString ());
    }

    @Test
    public void checkRight (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');
        gappy.moveLeft ();
        gappy.moveLeft ();
        gappy.moveRight ();
        assertEquals ("abc▮d", gappy.toString ());
    }

    @Test
    public void checkLeftOutOfBounds (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.moveLeft ();
        gappy.moveLeft ();
        assertEquals ("▮a", gappy.toString ());
    }

    @Test
    public void checkRightOutOfBounds (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.moveRight ();
        assertEquals ("a▮", gappy.toString ());
    }

    @Test
    public void checkDelete (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');
        gappy.delete ();
        assertEquals ("abc▮", gappy.toString ());
    }

    @Test
    public void checkDeleteLastElement (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.delete ();
        assertEquals ("▮", gappy.toString ());
    }

    @Test
    public void checkDeleteEmpty (){
        GapBuffer gappy = new GapBuffer ();
        gappy.delete ();
        assertEquals ("▮", gappy.toString ());
    }

    @Test
    public void checkExpand (){
        GapBuffer gappy = new GapBuffer ();

        for (int i = 0; i < 6; i++){
            gappy.insert ('a');
        }
        assertEquals (6, gappy.getSize ());
    }

    @Test
    public void checkExpandCharacters (){
        GapBuffer gappy = new GapBuffer ();

        for (int i = 0; i < 9; i++){
            gappy.insert ('a');
        }
        assertEquals ("aaaaaaaaa▮", gappy.toString ());
    }

    @Test
    public void checkGetIndex (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.moveLeft();
        
        assertEquals ('c', gappy.getChar (2));
    }

    @Test
    public void checkGetIndexAfterExpansion (){
        GapBuffer gappy = new GapBuffer ();
        gappy.insert ('a');
        gappy.insert ('b');
        gappy.insert ('c');
        gappy.insert ('d');
        gappy.insert ('e');
        gappy.insert ('f');
        gappy.moveLeft();
        gappy.moveLeft();
        
        assertEquals ('f', gappy.getChar (5));
    }







}

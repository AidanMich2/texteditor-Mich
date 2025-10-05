package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class SimpleStringBufferTests {
    /** TODO: fill me in with unit and property tests! */

    @Test
    public void emptyString (){
        SimpleStringBuffer buffy = new SimpleStringBuffer ();
        assertEquals ("▮", buffy.toString ());
    }

    @Test
    public void addOne (){
        SimpleStringBuffer buffy = new SimpleStringBuffer ();
        buffy.insert ('a');
        assertEquals ("a▮", buffy.toString ());
    }

    @Test
    public void checkPosition (){
        SimpleStringBuffer buffy = new SimpleStringBuffer ();
        buffy.insert ('a');
        buffy.moveRight ();
        assertEquals ("a▮", buffy.toString ());
    }

    @Test
    public void checkLeft (){
        SimpleStringBuffer buffy = new SimpleStringBuffer ();
        buffy.insert ('a');
        buffy.moveLeft ();
        assertEquals ("▮a", buffy.toString ());
    }

    @Test
    public void delete (){
        SimpleStringBuffer buffy = new SimpleStringBuffer ();
        buffy.insert ('a');
        buffy.delete ();
        assertEquals ("▮", buffy.toString ());
    }

    @Test
    public void deleteAtZero (){
        SimpleStringBuffer buffy = new SimpleStringBuffer ();
        buffy.insert ('a');
        buffy.delete ();
        buffy.delete ();
        assertEquals ("▮", buffy.toString ());
    }

}

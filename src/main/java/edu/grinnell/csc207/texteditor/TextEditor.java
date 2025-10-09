package edu.grinnell.csc207.texteditor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
// import java.io.IOException;

// ...



/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {
    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     * @throws IOException 
     */
    public static String textEditorContent = "";

    public static void drawBuffer (GapBuffer buf, Screen screen) throws IOException{
        for (int i = 0; i < buf.getSize (); i++){
            screen.setCharacter(i, 0, TextCharacter.fromCharacter(buf.getChar (i)) [0]);
            // textEditorContent = String.valueOf (buf.getChar (i));//I Aidan, looked up this function on javadocs (forgot how to convert from char to String)
        }
        screen.setCursorPosition(new TerminalPosition(buf.getCursorPosition(), 0));
        screen.refresh ();
    }
    public static void main(String[] args) throws IOException{
        // TODO: fill me in with a text editor TUI!
        // if (args.length != 1) {
        //     System.err.println("Usage: java TextEditor <filename>");
        //     System.exit(1);
        // }
        // String path = args[0];
        // String fileStr = "";
        // fileStr = Files.readString(Paths.get(path));
        // System.out.format("Loading %s...\n", path);

        // Files.writeString(Paths.get(path), fileStr);



        GapBuffer buf = new GapBuffer();
        Screen screen = new DefaultTerminalFactory().createScreen();
        
        screen.startScreen();

        // for (int i = 0; i < fileStr.length (); i++){
        //     screen.setCharacter(i, 0, TextCharacter.fromCharacter(fileStr.charAt (i))[0]);
        // }
        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            // TODO: Process the key stroke!
            if (stroke.getKeyType ().equals (KeyType.Character)){
                buf.insert (stroke.getCharacter ());
            }
            else if (stroke.getKeyType ().equals (KeyType.ArrowLeft)){
                buf.moveLeft ();
            }
            else if (stroke.getKeyType ().equals (KeyType.ArrowRight)){
                buf.moveRight ();
            }
            else if (stroke.getKeyType ().equals (KeyType.Backspace)){
                buf.delete ();
                screen.clear();
            }
            else if (stroke.getKeyType ().equals (KeyType.Escape)){
                isRunning = false;
            }
            drawBuffer(buf, screen);
        }
    
        // Files.writeString(Paths.get(path), textEditorContent);
        
        
        screen.stopScreen();
        
    }
}

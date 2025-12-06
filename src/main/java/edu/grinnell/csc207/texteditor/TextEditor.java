package edu.grinnell.csc207.texteditor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

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

    /**
     * Draws the buffer on the screen.
     * @param buf is the specified buffer.
     * @param screen is the screen we are drawing to.
     * @throws IOException
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        for (int i = 0; i < buf.getSize(); i++) {
            screen.setCharacter(i, 0, TextCharacter.fromCharacter(buf.getChar(i))[0]);
        }
        screen.setCursorPosition(new TerminalPosition(buf.getCursorPosition(), 0));
        screen.refresh();
    }

    /**
     * Serves as an entry point for the program, is used to ultimately display the buffer
     * that was created.
     * @param args are command line arguments, but not used in this case.
     * @throws IOException if there is an error during the screen display process.
     */
    public static void main(String[] args) throws IOException {
        GapBuffer buf = new GapBuffer();
        Screen screen = new DefaultTerminalFactory().createScreen();   
        screen.startScreen();
        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            if (stroke.getKeyType().equals(KeyType.Character)) {
                buf.insert(stroke.getCharacter());
            } else if (stroke.getKeyType().equals(KeyType.ArrowLeft)) {
                buf.moveLeft();
            } else if (stroke.getKeyType().equals(KeyType.ArrowRight)) {
                buf.moveRight();
            } else if (stroke.getKeyType().equals(KeyType.Backspace)) {
                buf.delete();
                screen.clear();
            } else if (stroke.getKeyType().equals(KeyType.Escape)) {
                isRunning = false;
            }
            drawBuffer(buf, screen);
        }
        screen.stopScreen();        
    }
}

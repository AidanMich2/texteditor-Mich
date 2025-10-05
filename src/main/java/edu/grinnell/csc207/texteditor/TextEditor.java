package edu.grinnell.csc207.texteditor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

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
     */
    public static void main(String[] args) throws IOException{
        Screen screen = new DefaultTerminalFactory().createScreen();
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        

        // boolean isRunning = true;
        // while (isRunning) {
        //     KeyStroke stroke = screen.readInput();
        //     // TODO: Process the key stroke!
        //     drawBuffer(buf, screen);
        // }

        // TODO: fill me in with a text editor TUI!
        String path = args[0];
        System.out.format("Loading %s...\n", path);
    }
}

package org.example.ImplementacionProyecto;

public class LexicalError {
    private String message;
    private int line;
    private int position;

    public LexicalError(String message, int line, int position) {
        this.message = message;
        this.line = line;
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public int getLine() {
        return line;
    }

    public int getPosition() {
        return position;
    }
}
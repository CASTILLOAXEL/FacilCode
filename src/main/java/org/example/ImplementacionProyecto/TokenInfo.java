package org.example.ImplementacionProyecto;

public class TokenInfo {
    private int index;
    private String text;
    private String type;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TokenInfo(int index, String text, String type) {
        this.index = index;
        this.text = text;
        this.type = type;
    }

    // getters and setters
}




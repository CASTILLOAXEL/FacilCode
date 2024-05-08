package org.example.ImplementacionProyecto;

public class SymbolInfo {
    private String identifier;
    private String type;
    private String value;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SymbolInfo(String identifier, String type, String value) {
        this.identifier = identifier;
        this.type = type;
        this.value = value;
    }

    // getters and setters
}

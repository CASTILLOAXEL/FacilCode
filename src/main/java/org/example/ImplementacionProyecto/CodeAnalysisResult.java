package org.example.ImplementacionProyecto;


import java.util.List;

// La clase CodeAnalysisResult representa el resultado del análisis de código,
// incluyendo información sobre tokens, símbolos, errores, árbol de derivación,
// errores léxicos y errores sintácticos.
public class CodeAnalysisResult {
    // Listas que almacenan información sobre tokens, símbolos, errores, errores léxicos y errores sintácticos.
    private List<TokenInfo> tokenInfos;
    private List<SymbolInfo> symbolInfos;
    private List<String> errors;
    private String tree;
    private List<LexicalError> lexicalErrors;
    private List<SyntaxError> syntaxErrors;

    // Constructor que inicializa los campos de la clase.
    public CodeAnalysisResult(List<TokenInfo> tokenInfos, List<SymbolInfo> symbolInfos, List<String> errors, String tree, List<LexicalError> lexicalErrors, List<SyntaxError> syntaxErrors) {
        this.tokenInfos = tokenInfos;
        this.symbolInfos = symbolInfos;
        this.errors = errors;
        this.tree = tree;
        this.lexicalErrors = lexicalErrors;
        this.syntaxErrors = syntaxErrors;
    }

    // Métodos para obtener y establecer la lista de información de tokens.
    public List<TokenInfo> getTokenInfos() {
        return tokenInfos;
    }

    public void setTokenInfos(List<TokenInfo> tokenInfos) {
        this.tokenInfos = tokenInfos;
    }

    // Métodos para obtener y establecer la lista de información de símbolos.
    public List<SymbolInfo> getSymbolInfos() {
        return symbolInfos;
    }

    public void setSymbolInfos(List<SymbolInfo> symbolInfos) {
        this.symbolInfos = symbolInfos;
    }

    // Métodos para obtener y establecer la lista de errores.
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    // Métodos para obtener y establecer el árbol de derivación.
    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    // Métodos para obtener y establecer la lista de errores léxicos.
    public List<LexicalError> getLexicalErrors() {
        return lexicalErrors;
    }

    public void setLexicalErrors(List<LexicalError> lexicalErrors) {
        this.lexicalErrors = lexicalErrors;
    }

    // Métodos para obtener y establecer la lista de errores sintácticos.
    public List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

    public void setSyntaxErrors(List<SyntaxError> syntaxErrors) {
        this.syntaxErrors = syntaxErrors;
    }
}

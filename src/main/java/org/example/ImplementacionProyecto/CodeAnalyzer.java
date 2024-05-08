package org.example.ImplementacionProyecto;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.FacilCodeLexer;
import org.example.FacilCodeParser;

import java.util.ArrayList;
import java.util.List;

public class CodeAnalyzer {
    public CodeAnalysisResult analyzeCode(String codigo) {
        // Crear un CharStream a partir del código fuente
        CharStream input = CharStreams.fromString(codigo);

        // Crear un analizador léxico
        FacilCodeLexer lexer = new FacilCodeLexer(input);

        // Crear un flujo de tokens a partir del analizador léxico
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Crear un analizador sintáctico
        FacilCodeParser parser = new FacilCodeParser(tokens);

        // Agregar manejador de errores personalizado
        CustomErrorListener errorListener = new CustomErrorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        // Llamar a la regla de inicio de tu gramática
        ParseTree tree = parser.programa(); // Cambia 'prog' por el nombre de tu regla de inicio

        // Recopilar información sobre los tokens y los símbolos
        List<TokenInfo> tokenInfos = new ArrayList<>();
        List<SymbolInfo> symbolInfos = new ArrayList<>();
        List<String> errors = errorListener.getErrors();
        for (int i = 0; i < tokens.getTokens().size(); i++) {
            Token token = tokens.getTokens().get(i);
            tokenInfos.add(new TokenInfo(token.getTokenIndex(), token.getText(), FacilCodeLexer.VOCABULARY.getDisplayName(token.getType())));
            if (token.getType() == FacilCodeLexer.IDENTIFICADOR) {
                Token nextToken = tokens.get(i + 1);
                String type = nextToken.getText(); // Aquí necesitas la lógica para determinar el tipo del símbolo
                symbolInfos.add(new SymbolInfo(token.getText(), type, null));
            }
        }
return new CodeAnalysisResult(tokenInfos, symbolInfos, errors, tree.toStringTree(parser), new ArrayList<>(), new ArrayList<>());
    }
}
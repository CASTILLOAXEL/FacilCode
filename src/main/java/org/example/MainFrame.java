//package org.example;
//
//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.*;
//import java.util.List;
//
//
//
//
//
//public class MainFrame extends JFrame {
//    private JTextArea inputTextArea;
//    private JTextArea outputTextArea;
//    private JLabel statusLabel;
//    private JButton analyzeButton;
//    private JTextArea tokenTextArea;
//    private JTextArea errorTextArea;
//    private JTextArea symbolTextArea;
//    private JTextArea treeTextArea;
//
//    public MainFrame() {
//        setTitle("Analizador Léxico y Sintáctico");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        initComponents();
//    }
//
//    private void initComponents() {
//        // Componentes de la interfaz gráfica
//        inputTextArea = new JTextArea();
//        outputTextArea = new JTextArea();
//        statusLabel = new JLabel("Listo");
//        analyzeButton = new JButton("Analizar");
//        tokenTextArea = new JTextArea();
//        errorTextArea = new JTextArea();
//        symbolTextArea = new JTextArea();
//        treeTextArea = new JTextArea();
//
//        // Configuración del layout
//        setLayout(new BorderLayout());
//        JPanel topPanel = new JPanel(new BorderLayout());
//        topPanel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);
//        topPanel.add(analyzeButton, BorderLayout.EAST);
//        add(topPanel, BorderLayout.CENTER);
//
//        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
//        JPanel leftPanel = new JPanel(new BorderLayout());
//        leftPanel.add(new JScrollPane(tokenTextArea), BorderLayout.CENTER);
//        leftPanel.add(new JLabel("Tokens reconocidos"), BorderLayout.NORTH);
//        leftPanel.add(new JScrollPane(symbolTextArea), BorderLayout.SOUTH);
//        leftPanel.add(new JLabel("Tabla de símbolos"), BorderLayout.NORTH);
//        bottomPanel.add(leftPanel);
//
//        JPanel rightPanel = new JPanel(new BorderLayout());
//        rightPanel.add(new JScrollPane(errorTextArea), BorderLayout.CENTER);
//        rightPanel.add(new JLabel("Tabla de errores"), BorderLayout.NORTH);
//        rightPanel.add(new JScrollPane(treeTextArea), BorderLayout.SOUTH);
//        rightPanel.add(new JLabel("Árbol de derivación"), BorderLayout.NORTH);
//        bottomPanel.add(rightPanel);
//
//        add(bottomPanel, BorderLayout.SOUTH);
//        add(statusLabel, BorderLayout.NORTH);
//
//        // Acción del botón de análisis
//        analyzeButton.addActionListener(e -> analizarCodigo());
//    }
//
//    private void analizarCodigo() {
//        String codigo = inputTextArea.getText();
//
//        // Crear un CharStream a partir del código fuente
//        CharStream input = CharStreams.fromString(codigo);
//
//        // Crear un analizador léxico
//        FacilCodeLexer lexer = new FacilCodeLexer(input);
//
//        // Crear un flujo de tokens a partir del analizador léxico
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // Crear un analizador sintáctico
//        FacilCodeParser parser = new FacilCodeParser(tokens);
//
//        // Agregar manejador de errores personalizado
//        CustomErrorListener errorListener = new CustomErrorListener();
//        parser.removeErrorListeners();
//        parser.addErrorListener(errorListener);
//
//        // Llamar a la regla de inicio de tu gramática
//        ParseTree tree = parser.programa(); // Cambia 'prog' por el nombre de tu regla de inicio
//
//        // Recopilar información sobre los tokens y los símbolos
//        Map<Integer, Token> tokenMap = new HashMap<>();
//        Map<String, Symbol> symbolTable = new HashMap<>();
//        List<String> errors = errorListener.getErrors();
//        for (int i = 0; i < tokens.getTokens().size(); i++) {
//            Token token = tokens.getTokens().get(i);
//            tokenMap.put(token.getTokenIndex(), token);
//            if (token.getType() == FacilCodeLexer.IDENTIFICADOR) {
//                Token nextToken = tokens.get(i + 1);
//                String type = nextToken.getText(); // Aquí necesitas la lógica para determinar el tipo del símbolo
//                Symbol symbol = new Symbol(type, null);
//                symbolTable.put(token.getText(), symbol);
//            }
//        }
//
//        // Mostrar los tokens reconocidos en el área de texto correspondiente
//        tokenTextArea.setText("Tokens reconocidos:\n");
//        for (Token token : tokenMap.values()) {
//            tokenTextArea.append("Token: " + token.getText() + " - Tipo: " + FacilCodeLexer.VOCABULARY.getDisplayName(token.getType()) + "\n");
//        }
//
//        // Mostrar la tabla de errores en el área de texto correspondiente
//        errorTextArea.setText("Tabla de errores:\n");
//        for (String error : errors) {
//            errorTextArea.append(error + "\n");
//        }
//
//        // Mostrar la tabla de símbolos en el área de texto correspondiente
//        symbolTextArea.setText("Tabla de símbolos:\n");
//        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
//            symbolTextArea.append("Identificador: " + entry.getKey() + " - Tipo: " + entry.getValue().getType() + "\n");
//        }
//
//        // Mostrar el árbol de derivación en el área de texto correspondiente
//        treeTextArea.setText("Árbol de derivación:\n");
//        treeTextArea.append(expandirArbol(tree, parser, 0));
//
//        // Actualiza el estado en el statusLabel
//        statusLabel.setText("Análisis completado");
//    }
//
//    // Método para desglosar el árbol de derivación en varias líneas
//    private String expandirArbol(ParseTree tree, FacilCodeParser parser, int nivel) {
//        StringBuilder sb = new StringBuilder();
//        if (tree.getChildCount() == 0) {
//            // Si el nodo es una hoja, simplemente devuelve el texto del nodo
//            sb.append(tree.toString()).append("\n");
//        } else {
//            // Si el nodo tiene hijos, agrega el texto del nodo y luego procesa recursivamente a sus hijos
//            for (int i = 0; i < tree.getChildCount(); i++) {
//                ParseTree child = tree.getChild(i);
//                sb.append(repetirEspacios(nivel)).append(expandirArbol(child, parser, nivel + 1));
//            }
//        }
//        return sb.toString();
//    }
//
//    // Método para repetir espacios para cada nivel del árbol
//    private String repetirEspacios(int nivel) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < nivel; i++) {
//            sb.append("  ");
//        }
//        return sb.toString();
//    }
//
//    private static class CustomErrorListener extends BaseErrorListener {
//        private List<String> errors = new ArrayList<>();
//
//        public List<String> getErrors() {
//            return errors;
//        }
//
//        @Override
//        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
//                                int line, int charPositionInLine, String msg, RecognitionException e) {
//            errors.add("Error de sintaxis en línea " + line + ", posición " + charPositionInLine + ": " + msg);
//        }
//    }
//
//    private static class Symbol {
//        private String type;
//        private String value;
//
//        public Symbol(String type, String value) {
//            this.type = type;
//            this.value = value;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
//    }
//}
//

//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//import java.util.*;
//import java.util.List;
//
//public class MainFrame extends JFrame {
//    private JTextArea inputTextArea;
//    private JTextArea tokenTextArea;
//    private JTextArea errorTextArea;
//    private JTextArea symbolTextArea;
//    private JTextArea treeTextArea;
//    private JLabel statusLabel;
//    private JButton analyzeButton;
//
//    private static class CustomErrorListener extends BaseErrorListener {
//        private List<String> errors = new ArrayList<>();
//
//        public List<String> getErrors() {
//            return errors;
//        }
//
//        @Override
//        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
//                                int line, int charPositionInLine, String msg, RecognitionException e) {
//            errors.add("Error de sintaxis en línea " + line + ", posición " + charPositionInLine + ": " + msg);
//        }
//    }
//
//    private static class Symbol {
//        private String type;
//        private String value;
//
//        public Symbol(String type, String value) {
//            this.type = type;
//            this.value = value;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public MainFrame() {
//        setTitle("Analizador Léxico y Sintáctico");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        initComponents();
//    }
//
//    private void initComponents() {
//        // Componentes de la interfaz gráfica
//        inputTextArea = new JTextArea();
//        tokenTextArea = new JTextArea();
//        errorTextArea = new JTextArea();
//        symbolTextArea = new JTextArea();
//        treeTextArea = new JTextArea();
//        statusLabel = new JLabel("Listo");
//        analyzeButton = new JButton("Analizar");
//
//        // Configuración del layout
//        setLayout(new BorderLayout());
//
//        JPanel topPanel = new JPanel(new BorderLayout());
//        topPanel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);
//        topPanel.add(analyzeButton, BorderLayout.EAST);
//        add(topPanel, BorderLayout.NORTH);
//
//        JPanel centerPanel = new JPanel(new GridLayout(1, 4));
//
//        centerPanel.add(new JScrollPane(tokenTextArea));
//        centerPanel.add(new JScrollPane(errorTextArea));
//        centerPanel.add(new JScrollPane(symbolTextArea));
//        centerPanel.add(new JScrollPane(treeTextArea));
//
//        add(centerPanel, BorderLayout.CENTER);
//        add(statusLabel, BorderLayout.SOUTH);
//
//        // Acción del botón de análisis
//        analyzeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                analizarCodigo();
//            }
//        });
//    }
//
//    private void analizarCodigo() {
//        String codigo = inputTextArea.getText();
//
//        // Crear un CharStream a partir del código fuente
//        CharStream input = CharStreams.fromString(codigo);
//
//        // Crear un analizador léxico
//        FacilCodeLexer lexer = new FacilCodeLexer(input);
//
//        // Crear un flujo de tokens a partir del analizador léxico
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // Crear un analizador sintáctico
//        FacilCodeParser parser = new FacilCodeParser(tokens);
//
//        // Agregar manejador de errores personalizado
//        CustomErrorListener errorListener = new CustomErrorListener();
//        parser.removeErrorListeners();
//        parser.addErrorListener(errorListener);
//
//        // Llamar a la regla de inicio de tu gramática
//        ParseTree tree = parser.programa(); // Cambia 'prog' por el nombre de tu regla de inicio
//
//        // Recopilar información sobre los tokens y los símbolos
//        Map<Integer, Token> tokenMap = new HashMap<>();
//        Map<String, Symbol> symbolTable = new HashMap<>();
//        List<String> errors = errorListener.getErrors();
//        for (int i = 0; i < tokens.getTokens().size(); i++) {
//            Token token = tokens.getTokens().get(i);
//            tokenMap.put(token.getTokenIndex(), token);
//            if (token.getType() == FacilCodeLexer.IDENTIFICADOR) {
//                Token nextToken = tokens.get(i + 1);
//                String type = nextToken.getText(); // Aquí necesitas la lógica para determinar el tipo del símbolo
//                Symbol symbol = new Symbol(type, null);
//                symbolTable.put(token.getText(), symbol);
//            }
//        }
//
//        // Mostrar los tokens reconocidos en el área de texto correspondiente
//        tokenTextArea.setText("Tokens reconocidos:\n");
//        for (Token token : tokenMap.values()) {
//            tokenTextArea.append("Token: " + token.getText() + " - Tipo: " + FacilCodeLexer.VOCABULARY.getDisplayName(token.getType()) + "\n");
//        }
//
//        // Mostrar la tabla de errores en el área de texto correspondiente
//        errorTextArea.setText("Tabla de errores:\n");
//        for (String error : errors) {
//            errorTextArea.append(error + "\n");
//        }
//
//        // Mostrar la tabla de símbolos en el área de texto correspondiente
//        symbolTextArea.setText("Tabla de símbolos:\n");
//        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
//            symbolTextArea.append("Identificador: " + entry.getKey() + " - Tipo: " + entry.getValue().getType() + "\n");
//        }
//
//        // Mostrar el árbol de derivación en el área de texto correspondiente
//        treeTextArea.setText("Árbol de derivación:\n");
//        treeTextArea.append(tree.toStringTree(parser) + "\n");
//
//        // Actualiza el estado en el statusLabel
//        statusLabel.setText("Análisis completado");
//    }
//
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//    }
//}

//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//import java.util.*;
//
//public class MainFrame {
//    private static class CustomErrorListener extends BaseErrorListener {
//        private List<String> errors = new ArrayList<>();
//
//        public List<String> getErrors() {
//            return errors;
//        }
//
//        @Override
//        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
//                                int line, int charPositionInLine, String msg, RecognitionException e) {
//            errors.add("Error de sintaxis en línea " + line + ", posición " + charPositionInLine + ": " + msg);
//        }
//    }
//
//    private static class Symbol {
//        private String type;
//        private String value;
//
//        public Symbol(String type, String value) {
//            this.type = type;
//            this.value = value;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder codeBuilder = new StringBuilder();
//
//        // Pedir al usuario que ingrese el código línea por línea
//        System.out.println("Ingresa el código línea por línea (presiona Enter después de cada línea).");
//        System.out.println("Cuando hayas terminado de ingresar el código, escribe 'fin' en una línea nueva y presiona Enter.");
//
//        String line;
//        while (!(line = scanner.nextLine()).equals("fin")) {
//            codeBuilder.append(line).append("\n");
//        }
//
//        // Obtener el código completo ingresado por el usuario
//        String codigo = codeBuilder.toString();
//
//        // Crear un CharStream a partir del código fuente
//        CharStream input = CharStreams.fromString(codigo);
//
//        // Crear un analizador léxico
//        FacilCodeLexer lexer = new FacilCodeLexer(input);
//
//        // Crear un flujo de tokens a partir del analizador léxico
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // Crear un analizador sintáctico
//        FacilCodeParser parser = new FacilCodeParser(tokens);
//
//        // Agregar manejador de errores personalizado
//        CustomErrorListener errorListener = new CustomErrorListener();
//        parser.removeErrorListeners();
//        parser.addErrorListener(errorListener);
//
//        // Llamar a la regla de inicio de tu gramática
//        ParseTree tree = parser.programa(); // Cambia 'prog' por el nombre de tu regla de inicio
//
//        // Recopilar información sobre los tokens y los símbolos
//        Map<Integer, Token> tokenMap = new HashMap<>();
//        Map<String, Symbol> symbolTable = new HashMap<>();
//        List<String> errors = errorListener.getErrors();
//        for (int i = 0; i < tokens.getTokens().size(); i++) {
//            Token token = tokens.getTokens().get(i);
//            tokenMap.put(token.getTokenIndex(), token);
//            if (token.getType() == FacilCodeLexer.IDENTIFICADOR) {
//                Token nextToken = tokens.get(i + 1);
//                String type = nextToken.getText(); // Aquí necesitas la lógica para determinar el tipo del símbolo
//                Symbol symbol = new Symbol(type, null);
//                symbolTable.put(token.getText(), symbol);
//            }
//        }
//
//        // Mostrar los tokens reconocidos en la consola
//        System.out.println("Tokens reconocidos:");
//        for (Token token : tokenMap.values()) {
//            System.out.println("Token: " + token.getText() + " - Tipo: " + FacilCodeLexer.VOCABULARY.getDisplayName(token.getType()));
//        }
//
//        // Mostrar la tabla de errores en la consola
//        System.out.println("Tabla de errores:");
//        for (String error : errors) {
//            System.out.println(error);
//        }
//
//        // Mostrar la tabla de símbolos en la consola
//        System.out.println("Tabla de símbolos:");
//        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
//            System.out.println("Identificador: " + entry.getKey() + " - Tipo: " + entry.getValue().getType());
//        }
//
//        // Mostrar el árbol de derivación en la consola
//        System.out.println("Árbol de derivación:");
//        System.out.println(tree.toStringTree(parser));
//    }
//}


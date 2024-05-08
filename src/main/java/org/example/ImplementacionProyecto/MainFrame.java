package org.example.ImplementacionProyecto;
// Importaciones de paquetes necesarios para la interfaz gráfica y eventos
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Clase principal que representa la ventana principal de la aplicación
public class MainFrame extends JFrame {
    // Declaración de componentes de la interfaz gráfica
    private JTextArea inputTextArea;
    private JTextArea tokenTextArea;
    private JTextArea errorTextArea;
    private JTextArea symbolTextArea;
    private JTextArea treeTextArea;
    private JTextArea lexicalErrorTextArea;
    private JTextArea syntaxErrorTextArea;
    private JLabel statusLabel;
    private JButton analyzeButton;

    // Constructor de la clase MainFrame
    public MainFrame() {
        // Inicialización de los componentes de la interfaz
        inputTextArea = new JTextArea();
        tokenTextArea = new JTextArea();
        errorTextArea = new JTextArea();
        symbolTextArea = new JTextArea();
        treeTextArea = new JTextArea();
        lexicalErrorTextArea = new JTextArea();
        syntaxErrorTextArea = new JTextArea();
        statusLabel = new JLabel("Listo");
        analyzeButton = new JButton("Analizar");

        // Configuración del diseño de la ventana
        setLayout(new BorderLayout());
        add(inputTextArea, BorderLayout.NORTH);

        // Panel principal que contendrá las áreas de texto
        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        // Agregar áreas de texto con etiquetas al panel principal
        addLabeledTextArea(mainPanel, "Tokens reconocidos:", tokenTextArea);
        addLabeledTextArea(mainPanel, "Tabla de errores:", errorTextArea);
        addLabeledTextArea(mainPanel, "Tabla de símbolos:", symbolTextArea);
        addLabeledTextArea(mainPanel, "Árbol de derivación:", treeTextArea);
        addLabeledTextArea(mainPanel, "Errores léxicos:", lexicalErrorTextArea);
        addLabeledTextArea(mainPanel, "Errores sintácticos:", syntaxErrorTextArea);
        add(mainPanel, BorderLayout.CENTER);

        // Agregar la etiqueta de estado y el botón de análisis en la parte inferior de la ventana
        add(statusLabel, BorderLayout.SOUTH);
        add(analyzeButton, BorderLayout.SOUTH);

        // Configuración del comportamiento de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

        // Agregar un ActionListener al botón de análisis
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analizarCodigo();
            }
        });
    }

    // Método auxiliar para agregar áreas de texto con etiquetas a un panel
    private void addLabeledTextArea(JPanel panel, String labelText, JTextArea textArea) {
        JPanel subPanel = new JPanel(new BorderLayout());
        subPanel.add(new JLabel(labelText), BorderLayout.NORTH);
        subPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(subPanel);
    }

    // Método que se llama cuando se presiona el botón de análisis
    private void analizarCodigo() {
        String codigo = inputTextArea.getText();
        CodeAnalyzer analyzer = new CodeAnalyzer();
        CodeAnalysisResult result = analyzer.analyzeCode(codigo);

        // Actualización de las áreas de texto con los resultados del análisis
        updateTokenTextArea(result.getTokenInfos());
        updateErrorTextArea(result.getErrors());
        updateSymbolTextArea(result.getSymbolInfos());
        updateTreeTextArea(result.getTree());
        updateLexicalErrorTextArea(result.getLexicalErrors(), codigo);
        updateSyntaxErrorTextArea(result.getSyntaxErrors(), codigo);

        // Verificar si hay errores léxicos o sintácticos y mostrar mensaje de error si es necesario
        if (!result.getLexicalErrors().isEmpty() || !result.getSyntaxErrors().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Se encontraron errores léxicos o sintácticos. Verifica la pestaña correspondiente para más detalles.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Actualización del estado en la etiqueta de estado
        statusLabel.setText("Análisis completado");
    }

    // Métodos para actualizar las diferentes áreas de texto con los resultados del análisis
    private void updateTokenTextArea(List<TokenInfo> tokenInfos) {
        tokenTextArea.setText("Tokens reconocidos:\n");
        for (TokenInfo tokenInfo : tokenInfos) {
            tokenTextArea.append("Token: " + tokenInfo.getText() + " - Tipo: " + tokenInfo.getType() + "\n");
        }
    }

    private void updateErrorTextArea(List<String> errors) {
        errorTextArea.setText("Tabla de errores:\n");
        for (String error : errors) {
            errorTextArea.append(error + "\n");
        }
    }

    private void updateSymbolTextArea(List<SymbolInfo> symbolInfos) {
        symbolTextArea.setText("Tabla de símbolos:\n");
        for (SymbolInfo symbolInfo : symbolInfos) {
            symbolTextArea.append("Identificador: " + symbolInfo.getIdentifier() + " - Tipo: " + symbolInfo.getType() + "\n");
        }
    }

    private void updateTreeTextArea(String tree) {
        treeTextArea.setText("Árbol de derivación:\n");
        if (tree != null && !tree.isEmpty()) {
            String formattedTree = formatTree(tree, 0);
            treeTextArea.append(formattedTree);
        }
    }

    private String formatTree(String tree, int indentLevel) {
        StringBuilder formattedTree = new StringBuilder();

        String[] lines = tree.split("\n");
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length > 1) {
                String nodeName = parts[0].trim();
                String nodeValue = parts[1].trim();
                formattedTree.append(getIndentString(indentLevel)).append(nodeName).append(": ").append(nodeValue).append("\n");
            } else {
                formattedTree.append(getIndentString(indentLevel)).append(line.trim()).append("\n");
            }
        }

        return formattedTree.toString();
    }

    private String getIndentString(int indentLevel) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            indent.append("    "); // Puedes ajustar el número de espacios para la indentación
        }
        return indent.toString();
    }

    // Método para actualizar el área de texto de errores léxicos
    private void updateLexicalErrorTextArea(List<LexicalError> lexicalErrors, String codigo) {
        lexicalErrorTextArea.setText("Errores léxicos:\n");
        for (LexicalError error : lexicalErrors) {
            lexicalErrorTextArea.append("Error: " + error.getMessage() + "\n");
            lexicalErrorTextArea.append("En línea: " + error.getLine() + ", Posición: " + error.getPosition() + "\n");
            lexicalErrorTextArea.append("Código relacionado: " + getCodeSnippet(error.getLine(), error.getPosition(), 3, codigo.split("\n")) + "\n\n");
        }
        // Si hay errores léxicos, mostrar un mensaje de error
        if (!lexicalErrors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Se encontraron errores léxicos. Verifica la pestaña correspondiente para más detalles.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar el área de texto de errores sintácticos
    private void updateSyntaxErrorTextArea(List<SyntaxError> syntaxErrors, String codigo) {
        syntaxErrorTextArea.setText("Errores sintácticos:\n");
        for (SyntaxError error : syntaxErrors) {
            syntaxErrorTextArea.append("Error: " + error.getMessage() + "\n");
            syntaxErrorTextArea.append("En línea: " + error.getLine() + ", Posición: " + error.getPosition() + "\n");
            syntaxErrorTextArea.append("Código relacionado: " + getCodeSnippet(error.getLine(), error.getPosition(), 3, codigo.split("\n")) + "\n\n");
        }
        // Si hay errores sintácticos, mostrar un mensaje de error
        if (!syntaxErrors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Se encontraron errores sintácticos. Verifica la pestaña correspondiente para más detalles.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener un fragmento de código que rodea un error específico
    private String getCodeSnippet(int errorLine, int errorPosition, int linesAround, String[] code) {
        StringBuilder snippet = new StringBuilder();
        int startLine = Math.max(1, errorLine - linesAround);
        int endLine = Math.min(code.length, errorLine + linesAround);

        for (int i = startLine - 1; i < endLine; i++) {
            if (i + 1 == errorLine) {
                String errorLineText = code[i];
                snippet.append(errorLineText).append("\n");
                snippet.append(" ".repeat(Math.max(0, errorPosition - 1))).append("^").append("\n");
            } else {
                snippet.append(code[i]).append("\n");
            }
        }

        return snippet.toString();
    }

    // Método main para iniciar la aplicación
    public static void main(String[] args) {
        // Crear una instancia de MainFrame y mostrarla en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

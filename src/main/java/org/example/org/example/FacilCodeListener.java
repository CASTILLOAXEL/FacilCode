// Generated from D:/SEPTIMO SEMESTRE UMG/Programación III/FacilCode/src/main/java/org/example/FacilCode.g4 by ANTLR 4.13.1
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FacilCodeParser}.
 */
public interface FacilCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(FacilCodeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(FacilCodeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraciones(FacilCodeParser.DeclaracionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraciones(FacilCodeParser.DeclaracionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(FacilCodeParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(FacilCodeParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#tipo_dato}.
	 * @param ctx the parse tree
	 */
	void enterTipo_dato(FacilCodeParser.Tipo_datoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#tipo_dato}.
	 * @param ctx the parse tree
	 */
	void exitTipo_dato(FacilCodeParser.Tipo_datoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#lista_identificadores}.
	 * @param ctx the parse tree
	 */
	void enterLista_identificadores(FacilCodeParser.Lista_identificadoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#lista_identificadores}.
	 * @param ctx the parse tree
	 */
	void exitLista_identificadores(FacilCodeParser.Lista_identificadoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(FacilCodeParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(FacilCodeParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void enterSentencias(FacilCodeParser.SentenciasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#sentencias}.
	 * @param ctx the parse tree
	 */
	void exitSentencias(FacilCodeParser.SentenciasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(FacilCodeParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(FacilCodeParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(FacilCodeParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(FacilCodeParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#estructura_control}.
	 * @param ctx the parse tree
	 */
	void enterEstructura_control(FacilCodeParser.Estructura_controlContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#estructura_control}.
	 * @param ctx the parse tree
	 */
	void exitEstructura_control(FacilCodeParser.Estructura_controlContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(FacilCodeParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(FacilCodeParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(FacilCodeParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(FacilCodeParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(FacilCodeParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(FacilCodeParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(FacilCodeParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(FacilCodeParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(FacilCodeParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(FacilCodeParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#entero}.
	 * @param ctx the parse tree
	 */
	void enterEntero(FacilCodeParser.EnteroContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#entero}.
	 * @param ctx the parse tree
	 */
	void exitEntero(FacilCodeParser.EnteroContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(FacilCodeParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(FacilCodeParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacilCodeParser#operador}.
	 * @param ctx the parse tree
	 */
	void enterOperador(FacilCodeParser.OperadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacilCodeParser#operador}.
	 * @param ctx the parse tree
	 */
	void exitOperador(FacilCodeParser.OperadorContext ctx);
}
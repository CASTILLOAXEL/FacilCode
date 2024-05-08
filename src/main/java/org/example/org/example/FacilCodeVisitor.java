// Generated from D:/SEPTIMO SEMESTRE UMG/Programación III/FacilCode/src/main/java/org/example/FacilCode.g4 by ANTLR 4.13.1
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FacilCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FacilCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(FacilCodeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#declaraciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraciones(FacilCodeParser.DeclaracionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(FacilCodeParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#tipo_dato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_dato(FacilCodeParser.Tipo_datoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#lista_identificadores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_identificadores(FacilCodeParser.Lista_identificadoresContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(FacilCodeParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#sentencias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencias(FacilCodeParser.SentenciasContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(FacilCodeParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(FacilCodeParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#estructura_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructura_control(FacilCodeParser.Estructura_controlContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(FacilCodeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(FacilCodeParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(FacilCodeParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(FacilCodeParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(FacilCodeParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#entero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntero(FacilCodeParser.EnteroContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(FacilCodeParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacilCodeParser#operador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperador(FacilCodeParser.OperadorContext ctx);
}
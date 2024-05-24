
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu May 23 20:13:23 CST 2024
//----------------------------------------------------

package org.eqcatorce.segundaentregag.programas.ASAP;

import java_cup.runtime.*;

import java.util.*;

import static Programas.ASAP.parser.addMessage;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu May 23 20:13:23 CST 2024
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\007\000\002\002\004\000\002\002\003\000\002\003" +
    "\007\000\002\004\005\000\002\004\003\000\002\005\003" +
    "\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\004\004\004\001\002\000\004\012\010\001" +
    "\002\000\004\002\007\001\002\000\004\002\000\001\002" +
    "\000\004\002\001\001\002\000\006\005\ufffd\007\017\001" +
    "\002\000\004\005\012\001\002\000\006\010\013\011\015" +
    "\001\002\000\004\006\ufffc\001\002\000\004\006\016\001" +
    "\002\000\004\006\ufffb\001\002\000\004\002\uffff\001\002" +
    "\000\004\012\010\001\002\000\004\005\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\006\002\004\003\005\001\001\000\004\004" +
    "\010\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\005" +
    "\013\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\004\017\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    Stack            stack,
    int                        top)
    throws Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private static ArrayList<String> messages = new ArrayList<String>();

    @Override
    public void report_error(String message, Object info) {
        if (info instanceof Symbol) {
          Symbol symbol = (Symbol) info;
          messages.add("Error: " + message + " at line " + (symbol.left + 1) + ", column " + symbol.right);
        } else {
          messages.add("Error: " + message);
        }
      }

      @Override
      public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        throw new RuntimeException(message); // Detener el análisis en caso de error fatal
    }

    public static void addMessage(String message) {
        messages.add(message);
    }

    public ArrayList<String> getMessages() {
      return messages;
    }

    public void clearMessage() {
            messages.clear();
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // T ::= BOOLEAN 
            {
              Object RESULT =null;
		 Programas.ASAP.parser.addMessage("Tipo: boolean");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // T ::= INTEGER 
            {
              Object RESULT =null;
		 Programas.ASAP.parser.addMessage("Tipo: integer");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // V ::= ID 
            {
              Object RESULT =null;
		 Programas.ASAP.parser.addMessage("Variable");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("V",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // V ::= ID COMA V 
            {
              Object RESULT =null;
		 Programas.ASAP.parser.addMessage("Variable");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("V",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // D ::= VAR V DOSP T PYCOMA 
            {
              Object RESULT =null;
		 Programas.ASAP.parser.addMessage("Declaracion encoantrada");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("D",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= D 
            {
              Object RESULT =null;
		 Programas.ASAP.parser.addMessage("Analisis completado\n");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}


/* The following code was generated by JFlex 1.4.3 on 6/17/14 1:20 AM */

package com.dci.intellij.dbn.language.psql.dialect.postgres;

import com.dci.intellij.dbn.language.common.TokenTypeBundle;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 6/17/14 1:20 AM from the specification file
 * <tt>D:/Projects/DBN-13.0/src/com/dci/intellij/dbn/language/psql/dialect/postgres/PostgresPSQLParser.flex</tt>
 */
public final class PostgresPSQLParserFlexLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int DIV = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\7\1\2\1\1\1\0\1\2\1\1\16\7\4\0\1\2\1\26"+
    "\1\11\1\10\1\6\1\34\1\0\1\12\1\32\1\37\1\3\1\14"+
    "\1\25\1\5\1\17\1\4\12\15\1\22\1\40\1\33\1\23\1\27"+
    "\1\0\1\24\3\6\1\20\1\16\1\20\7\6\1\13\14\6\1\30"+
    "\1\0\1\35\1\0\1\6\1\0\3\6\1\20\1\16\1\20\7\6"+
    "\1\13\14\6\1\31\1\21\1\36\1\0\41\7\2\0\4\6\4\0"+
    "\1\6\2\0\1\7\7\0\1\6\4\0\1\6\5\0\27\6\1\0"+
    "\37\6\1\0\u01ca\6\4\0\14\6\16\0\5\6\7\0\1\6\1\0"+
    "\1\6\21\0\160\7\5\6\1\0\2\6\2\0\4\6\10\0\1\6"+
    "\1\0\3\6\1\0\1\6\1\0\24\6\1\0\123\6\1\0\213\6"+
    "\1\0\5\7\2\0\236\6\11\0\46\6\2\0\1\6\7\0\47\6"+
    "\11\0\55\7\1\0\1\7\1\0\2\7\1\0\2\7\1\0\1\7"+
    "\10\0\33\6\5\0\3\6\15\0\4\7\7\0\1\6\4\0\13\7"+
    "\5\0\53\6\37\7\4\0\2\6\1\7\143\6\1\0\1\6\10\7"+
    "\1\0\6\7\2\6\2\7\1\0\4\7\2\6\12\7\3\6\2\0"+
    "\1\6\17\0\1\7\1\6\1\7\36\6\33\7\2\0\131\6\13\7"+
    "\1\6\16\0\12\7\41\6\11\7\2\6\4\0\1\6\5\0\26\6"+
    "\4\7\1\6\11\7\1\6\3\7\1\6\5\7\22\0\31\6\3\7"+
    "\244\0\4\7\66\6\3\7\1\6\22\7\1\6\7\7\12\6\2\7"+
    "\2\0\12\7\1\0\7\6\1\0\7\6\1\0\3\7\1\0\10\6"+
    "\2\0\2\6\2\0\26\6\1\0\7\6\1\0\1\6\3\0\4\6"+
    "\2\0\1\7\1\6\7\7\2\0\2\7\2\0\3\7\1\6\10\0"+
    "\1\7\4\0\2\6\1\0\3\6\2\7\2\0\12\7\4\6\7\0"+
    "\1\6\5\0\3\7\1\0\6\6\4\0\2\6\2\0\26\6\1\0"+
    "\7\6\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7\1\0"+
    "\5\7\4\0\2\7\2\0\3\7\3\0\1\7\7\0\4\6\1\0"+
    "\1\6\7\0\14\7\3\6\1\7\13\0\3\7\1\0\11\6\1\0"+
    "\3\6\1\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0"+
    "\1\7\1\6\10\7\1\0\3\7\1\0\3\7\2\0\1\6\17\0"+
    "\2\6\2\7\2\0\12\7\1\0\1\6\17\0\3\7\1\0\10\6"+
    "\2\0\2\6\2\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6"+
    "\2\0\1\7\1\6\7\7\2\0\2\7\2\0\3\7\10\0\2\7"+
    "\4\0\2\6\1\0\3\6\2\7\2\0\12\7\1\0\1\6\20\0"+
    "\1\7\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6"+
    "\1\0\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3\0\14\6"+
    "\4\0\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0\1\7"+
    "\16\0\12\7\11\0\1\6\7\0\3\7\1\0\10\6\1\0\3\6"+
    "\1\0\27\6\1\0\12\6\1\0\5\6\3\0\1\6\7\7\1\0"+
    "\3\7\1\0\4\7\7\0\2\7\1\0\2\6\6\0\2\6\2\7"+
    "\2\0\12\7\22\0\2\7\1\0\10\6\1\0\3\6\1\0\27\6"+
    "\1\0\12\6\1\0\5\6\2\0\1\7\1\6\7\7\1\0\3\7"+
    "\1\0\4\7\7\0\2\7\7\0\1\6\1\0\2\6\2\7\2\0"+
    "\12\7\1\0\2\6\17\0\2\7\1\0\10\6\1\0\3\6\1\0"+
    "\51\6\2\0\1\6\7\7\1\0\3\7\1\0\4\7\1\6\10\0"+
    "\1\7\10\0\2\6\2\7\2\0\12\7\12\0\6\6\2\0\2\7"+
    "\1\0\22\6\3\0\30\6\1\0\11\6\1\0\1\6\2\0\7\6"+
    "\3\0\1\7\4\0\6\7\1\0\1\7\1\0\10\7\22\0\2\7"+
    "\15\0\60\6\1\7\2\6\7\7\4\0\10\6\10\7\1\0\12\7"+
    "\47\0\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0\1\6"+
    "\6\0\4\6\1\0\7\6\1\0\3\6\1\0\1\6\1\0\1\6"+
    "\2\0\2\6\1\0\4\6\1\7\2\6\6\7\1\0\2\7\1\6"+
    "\2\0\5\6\1\0\1\6\1\0\6\7\2\0\12\7\2\0\2\6"+
    "\42\0\1\6\27\0\2\7\6\0\12\7\13\0\1\7\1\0\1\7"+
    "\1\0\1\7\4\0\2\7\10\6\1\0\44\6\4\0\24\7\1\0"+
    "\2\7\5\6\13\7\1\0\44\7\11\0\1\7\71\0\53\6\24\7"+
    "\1\6\12\7\6\0\6\6\4\7\4\6\3\7\1\6\3\7\2\6"+
    "\7\7\3\6\4\7\15\6\14\7\1\6\17\7\2\0\46\6\12\0"+
    "\53\6\1\0\1\6\3\0\u0149\6\1\0\4\6\2\0\7\6\1\0"+
    "\1\6\1\0\4\6\2\0\51\6\1\0\4\6\2\0\41\6\1\0"+
    "\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\17\6\1\0"+
    "\71\6\1\0\4\6\2\0\103\6\2\0\3\7\40\0\20\6\20\0"+
    "\125\6\14\0\u026c\6\2\0\21\6\1\0\32\6\5\0\113\6\3\0"+
    "\3\6\17\0\15\6\1\0\4\6\3\7\13\0\22\6\3\7\13\0"+
    "\22\6\2\7\14\0\15\6\1\0\3\6\1\0\2\7\14\0\64\6"+
    "\40\7\3\0\1\6\3\0\2\6\1\7\2\0\12\7\41\0\3\7"+
    "\2\0\12\7\6\0\130\6\10\0\51\6\1\7\1\6\5\0\106\6"+
    "\12\0\35\6\3\0\14\7\4\0\14\7\12\0\12\7\36\6\2\0"+
    "\5\6\13\0\54\6\4\0\21\7\7\6\2\7\6\0\12\7\46\0"+
    "\27\6\5\7\4\0\65\6\12\7\1\0\35\7\2\0\13\7\6\0"+
    "\12\7\15\0\1\6\130\0\5\7\57\6\21\7\7\6\4\0\12\7"+
    "\21\0\11\7\14\0\3\7\36\6\12\7\3\0\2\6\12\7\6\0"+
    "\46\6\16\7\14\0\44\6\24\7\10\0\12\7\3\0\3\6\12\7"+
    "\44\6\122\0\3\7\1\0\25\7\4\6\1\7\4\6\1\7\15\0"+
    "\300\6\47\7\25\0\4\7\u0116\6\2\0\6\6\2\0\46\6\2\0"+
    "\6\6\2\0\10\6\1\0\1\6\1\0\1\6\1\0\1\6\1\0"+
    "\37\6\2\0\65\6\1\0\7\6\1\0\1\6\3\0\3\6\1\0"+
    "\7\6\3\0\4\6\2\0\6\6\4\0\15\6\5\0\3\6\1\0"+
    "\7\6\16\0\5\7\32\0\5\7\20\0\2\6\23\0\1\6\13\0"+
    "\5\7\5\0\6\7\1\0\1\6\15\0\1\6\20\0\15\6\3\0"+
    "\32\6\26\0\15\7\4\0\1\7\3\0\14\7\21\0\1\6\4\0"+
    "\1\6\2\0\12\6\1\0\1\6\3\0\5\6\6\0\1\6\1\0"+
    "\1\6\1\0\1\6\1\0\4\6\1\0\13\6\2\0\4\6\5\0"+
    "\5\6\4\0\1\6\21\0\51\6\u0a77\0\57\6\1\0\57\6\1\0"+
    "\205\6\6\0\4\6\3\7\16\0\46\6\12\0\66\6\11\0\1\6"+
    "\17\0\1\7\27\6\11\0\7\6\1\0\7\6\1\0\7\6\1\0"+
    "\7\6\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6\1\0"+
    "\40\7\57\0\1\6\u01d5\0\3\6\31\0\11\6\6\7\1\0\5\6"+
    "\2\0\5\6\4\0\126\6\2\0\2\7\2\0\3\6\1\0\132\6"+
    "\1\0\4\6\5\0\51\6\3\0\136\6\21\0\33\6\65\0\20\6"+
    "\u0200\0\u19b6\6\112\0\u51cc\6\64\0\u048d\6\103\0\56\6\2\0\u010d\6"+
    "\3\0\20\6\12\7\2\6\24\0\57\6\1\7\14\0\2\7\1\0"+
    "\31\6\10\0\120\6\2\7\45\0\11\6\2\0\147\6\2\0\4\6"+
    "\1\0\2\6\16\0\12\6\120\0\10\6\1\7\3\6\1\7\4\6"+
    "\1\7\27\6\5\7\20\0\1\6\7\0\64\6\14\0\2\7\62\6"+
    "\21\7\13\0\12\7\6\0\22\7\6\6\3\0\1\6\4\0\12\7"+
    "\34\6\10\7\2\0\27\6\15\7\14\0\35\6\3\0\4\7\57\6"+
    "\16\7\16\0\1\6\12\7\46\0\51\6\16\7\11\0\3\6\1\7"+
    "\10\6\2\7\2\0\12\7\6\0\27\6\3\0\1\6\1\7\4\0"+
    "\60\6\1\7\1\6\3\7\2\6\2\7\5\6\2\7\1\6\1\7"+
    "\1\6\30\0\3\6\43\0\6\6\2\0\6\6\2\0\6\6\11\0"+
    "\7\6\1\0\7\6\221\0\43\6\10\7\1\0\2\7\2\0\12\7"+
    "\6\0\u2ba4\6\14\0\27\6\4\0\61\6\u2104\0\u012e\6\2\0\76\6"+
    "\2\0\152\6\46\0\7\6\14\0\5\6\5\0\1\6\1\7\12\6"+
    "\1\0\15\6\1\0\5\6\1\0\1\6\1\0\2\6\1\0\2\6"+
    "\1\0\154\6\41\0\u016b\6\22\0\100\6\2\0\66\6\50\0\15\6"+
    "\3\0\20\7\20\0\7\7\14\0\2\6\30\0\3\6\31\0\1\6"+
    "\6\0\5\6\1\0\207\6\2\0\1\7\4\0\1\6\13\0\12\7"+
    "\7\0\32\6\4\0\1\6\1\0\32\6\13\0\131\6\3\0\6\6"+
    "\2\0\6\6\2\0\6\6\2\0\3\6\3\0\2\6\3\0\2\6"+
    "\22\0\3\7\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\1\1\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\7\1\10\2\0\1\36\1\37\1\40\1\41\1\42"+
    "\1\34\1\0\1\12\4\0\2\36\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[52];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\41\0\102\0\143\0\102\0\204\0\245\0\306"+
    "\0\102\0\347\0\u0108\0\u0129\0\102\0\u014a\0\u016b\0\u018c"+
    "\0\u01ad\0\102\0\102\0\102\0\102\0\102\0\102\0\102"+
    "\0\102\0\102\0\102\0\102\0\102\0\102\0\102\0\u01ce"+
    "\0\u01ef\0\102\0\u0210\0\u0231\0\u0252\0\u0273\0\102\0\102"+
    "\0\102\0\102\0\u0294\0\u02b5\0\u02d6\0\u02f7\0\u0318\0\u0339"+
    "\0\u035a\0\u035a\0\u0318\0\102";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[52];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\5\1\6\1\7\1\10\1\3\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\10\1\17\1\10"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\0\2\4\1\5\1\6\1\7\1\10\1\0\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\10\1\17\1\10"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\42\0\2\4\41\0\1\40\42\0\1\41\41\0\3\10"+
    "\2\0\1\10\1\0\2\10\1\0\1\10\20\0\11\12"+
    "\1\42\27\12\12\13\1\43\26\13\6\0\3\10\1\0"+
    "\1\13\1\10\1\0\2\10\1\0\1\10\35\0\1\16"+
    "\1\44\1\45\36\0\1\46\1\0\1\47\42\0\1\50"+
    "\41\0\1\51\1\52\15\0\41\53\1\41\1\0\37\41"+
    "\12\0\1\13\33\0\1\54\6\0\1\54\1\55\40\0"+
    "\1\46\40\0\1\46\1\56\1\0\1\57\20\0\3\53"+
    "\1\60\35\53\15\0\1\55\40\0\1\55\1\0\1\45"+
    "\26\0\1\61\6\0\1\61\1\62\24\0\2\63\36\0"+
    "\3\53\1\60\1\64\34\53\15\0\1\62\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[891];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\3\1\1\11\3\1\1\11"+
    "\4\1\16\11\2\1\1\11\1\1\2\0\1\1\4\11"+
    "\1\1\1\0\1\1\4\0\2\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[52];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private int braceCounter = 0;
    private TokenTypeBundle tt;
    public PostgresPSQLParserFlexLexer(TokenTypeBundle tt) {
        this.tt = tt;
    }


  public PostgresPSQLParserFlexLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public PostgresPSQLParserFlexLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2186) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { return tt.getCharacterTokenType(19);
          }
        case 35: break;
        case 21: 
          { return tt.getCharacterTokenType(10);
          }
        case 36: break;
        case 13: 
          { return tt.getCharacterTokenType(1);
          }
        case 37: break;
        case 32: 
          { return tt.getOperatorTokenType(0);
          }
        case 38: break;
        case 11: 
          { return tt.getCharacterTokenType(3);
          }
        case 39: break;
        case 5: 
          { return tt.getCharacterTokenType(12);
          }
        case 40: break;
        case 1: 
          { yybegin(YYINITIAL); return tt.getSharedTokenTypes().getIdentifier();
          }
        case 41: break;
        case 3: 
          { return tt.getCharacterTokenType(20);
          }
        case 42: break;
        case 31: 
          { return tt.getOperatorTokenType(2);
          }
        case 43: break;
        case 9: 
          { return tt.getCharacterTokenType(14);
          }
        case 44: break;
        case 17: 
          { return tt.getCharacterTokenType(5);
          }
        case 45: break;
        case 7: 
          { yybegin(YYINITIAL); return tt.getSharedTokenTypes().getQuotedIdentifier();
          }
        case 46: break;
        case 29: 
          { return tt.getSharedTokenTypes().getLineComment();
          }
        case 47: break;
        case 25: 
          { return tt.getCharacterTokenType(16);
          }
        case 48: break;
        case 6: 
          { return tt.getCharacterTokenType(7);
          }
        case 49: break;
        case 30: 
          { return tt.getSharedTokenTypes().getNumber();
          }
        case 50: break;
        case 10: 
          { return tt.getSharedTokenTypes().getInteger();
          }
        case 51: break;
        case 27: 
          { return tt.getCharacterTokenType(18);
          }
        case 52: break;
        case 20: 
          { return tt.getCharacterTokenType(9);
          }
        case 53: break;
        case 15: 
          { return tt.getCharacterTokenType(0);
          }
        case 54: break;
        case 22: 
          { return tt.getCharacterTokenType(11);
          }
        case 55: break;
        case 16: 
          { return tt.getCharacterTokenType(2);
          }
        case 56: break;
        case 34: 
          { return tt.getOperatorTokenType(1);
          }
        case 57: break;
        case 23: 
          { return tt.getCharacterTokenType(13);
          }
        case 58: break;
        case 14: 
          { return tt.getCharacterTokenType(4);
          }
        case 59: break;
        case 8: 
          { return tt.getSharedTokenTypes().getString();
          }
        case 60: break;
        case 12: 
          { return tt.getCharacterTokenType(21);
          }
        case 61: break;
        case 33: 
          { return tt.getOperatorTokenType(3);
          }
        case 62: break;
        case 24: 
          { return tt.getCharacterTokenType(15);
          }
        case 63: break;
        case 18: 
          { return tt.getCharacterTokenType(6);
          }
        case 64: break;
        case 2: 
          { return tt.getSharedTokenTypes().getWhiteSpace();
          }
        case 65: break;
        case 28: 
          { return tt.getSharedTokenTypes().getBlockComment();
          }
        case 66: break;
        case 26: 
          { return tt.getCharacterTokenType(17);
          }
        case 67: break;
        case 19: 
          { return tt.getCharacterTokenType(8);
          }
        case 68: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

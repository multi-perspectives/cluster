// $ANTLR 3.4

	package org.feature.model.constraint.resource.csl.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CslLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34=5;
    public static final int QUOTED_39_39=6;
    public static final int TEXT=7;
    public static final int WHITESPACE=8;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CslLexer() {} 
    public CslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Csl.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:15:6: ( 'excludes' )
            // Csl.g:15:8: 'excludes'
            {
            match("excludes"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:16:7: ( 'requires' )
            // Csl.g:16:9: 'requires'
            {
            match("requires"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:758:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Csl.g:759:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Csl.g:759:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Csl.g:759:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Csl.g:759:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Csl.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:762:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Csl.g:763:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:766:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Csl.g:767:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Csl.g:767:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Csl.g:767:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Csl.g:767:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;
                }
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Csl.g:767:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Csl.g:767:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Csl.g:767:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_39_39"
    public final void mQUOTED_39_39() throws RecognitionException {
        try {
            int _type = QUOTED_39_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:770:13: ( ( ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' ) ) )
            // Csl.g:771:2: ( ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' ) )
            {
            // Csl.g:771:2: ( ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' ) )
            // Csl.g:771:3: ( '\\'' ) (~ ( '\\'' ) )* ( '\\'' )
            {
            // Csl.g:771:3: ( '\\'' )
            // Csl.g:771:4: '\\''
            {
            match('\''); 

            }


            // Csl.g:771:9: (~ ( '\\'' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '&')||(LA3_0 >= '(' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Csl.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // Csl.g:771:19: ( '\\'' )
            // Csl.g:771:20: '\\''
            {
            match('\''); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_39_39"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Csl.g:773:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Csl.g:774:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Csl.g:774:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Csl.g:774:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Csl.g:774:3: ( '\"' )
            // Csl.g:774:4: '\"'
            {
            match('\"'); 

            }


            // Csl.g:774:8: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Csl.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // Csl.g:774:17: ( '\"' )
            // Csl.g:774:18: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // Csl.g:1:8: ( T__9 | T__10 | TEXT | WHITESPACE | LINEBREAK | QUOTED_39_39 | QUOTED_34_34 )
        int alt5=7;
        switch ( input.LA(1) ) {
        case 'e':
            {
            int LA5_1 = input.LA(2);

            if ( (LA5_1=='x') ) {
                int LA5_8 = input.LA(3);

                if ( (LA5_8=='c') ) {
                    int LA5_10 = input.LA(4);

                    if ( (LA5_10=='l') ) {
                        int LA5_12 = input.LA(5);

                        if ( (LA5_12=='u') ) {
                            int LA5_14 = input.LA(6);

                            if ( (LA5_14=='d') ) {
                                int LA5_16 = input.LA(7);

                                if ( (LA5_16=='e') ) {
                                    int LA5_18 = input.LA(8);

                                    if ( (LA5_18=='s') ) {
                                        int LA5_20 = input.LA(9);

                                        if ( (LA5_20=='-'||(LA5_20 >= '0' && LA5_20 <= '9')||(LA5_20 >= 'A' && LA5_20 <= 'Z')||LA5_20=='_'||(LA5_20 >= 'a' && LA5_20 <= 'z')) ) {
                                            alt5=3;
                                        }
                                        else {
                                            alt5=1;
                                        }
                                    }
                                    else {
                                        alt5=3;
                                    }
                                }
                                else {
                                    alt5=3;
                                }
                            }
                            else {
                                alt5=3;
                            }
                        }
                        else {
                            alt5=3;
                        }
                    }
                    else {
                        alt5=3;
                    }
                }
                else {
                    alt5=3;
                }
            }
            else {
                alt5=3;
            }
            }
            break;
        case 'r':
            {
            int LA5_2 = input.LA(2);

            if ( (LA5_2=='e') ) {
                int LA5_9 = input.LA(3);

                if ( (LA5_9=='q') ) {
                    int LA5_11 = input.LA(4);

                    if ( (LA5_11=='u') ) {
                        int LA5_13 = input.LA(5);

                        if ( (LA5_13=='i') ) {
                            int LA5_15 = input.LA(6);

                            if ( (LA5_15=='r') ) {
                                int LA5_17 = input.LA(7);

                                if ( (LA5_17=='e') ) {
                                    int LA5_19 = input.LA(8);

                                    if ( (LA5_19=='s') ) {
                                        int LA5_21 = input.LA(9);

                                        if ( (LA5_21=='-'||(LA5_21 >= '0' && LA5_21 <= '9')||(LA5_21 >= 'A' && LA5_21 <= 'Z')||LA5_21=='_'||(LA5_21 >= 'a' && LA5_21 <= 'z')) ) {
                                            alt5=3;
                                        }
                                        else {
                                            alt5=2;
                                        }
                                    }
                                    else {
                                        alt5=3;
                                    }
                                }
                                else {
                                    alt5=3;
                                }
                            }
                            else {
                                alt5=3;
                            }
                        }
                        else {
                            alt5=3;
                        }
                    }
                    else {
                        alt5=3;
                    }
                }
                else {
                    alt5=3;
                }
            }
            else {
                alt5=3;
            }
            }
            break;
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=3;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt5=4;
            }
            break;
        case '\n':
        case '\r':
            {
            alt5=5;
            }
            break;
        case '\'':
            {
            alt5=6;
            }
            break;
        case '\"':
            {
            alt5=7;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // Csl.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // Csl.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // Csl.g:1:21: TEXT
                {
                mTEXT(); 


                }
                break;
            case 4 :
                // Csl.g:1:26: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 5 :
                // Csl.g:1:37: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 6 :
                // Csl.g:1:47: QUOTED_39_39
                {
                mQUOTED_39_39(); 


                }
                break;
            case 7 :
                // Csl.g:1:60: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


 

}
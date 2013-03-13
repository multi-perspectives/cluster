// $ANTLR 3.4

	package org.feature.multi.perspective.classification.resource.clt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CltLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int COMMA=4;
    public static final int COMMENT=5;
    public static final int LINEBREAK=6;
    public static final int QUOTED_34_34=7;
    public static final int QUOTED_60_62=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

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

    public CltLexer() {} 
    public CltLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CltLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Clt.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:15:7: ( ':' )
            // Clt.g:15:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:16:7: ( 'afeatures' )
            // Clt.g:16:9: 'afeatures'
            {
            match("afeatures"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:17:7: ( 'alive' )
            // Clt.g:17:9: 'alive'
            {
            match("alive"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:18:7: ( 'autocomplete' )
            // Clt.g:18:9: 'autocomplete'
            {
            match("autocomplete"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:19:7: ( 'classification' )
            // Clt.g:19:9: 'classification'
            {
            match("classification"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:20:7: ( 'dead' )
            // Clt.g:20:9: 'dead'
            {
            match("dead"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:21:7: ( 'dfeatures' )
            // Clt.g:21:9: 'dfeatures'
            {
            match("dfeatures"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:22:7: ( 'feature' )
            // Clt.g:22:9: 'feature'
            {
            match("feature"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:23:7: ( 'featuremodel' )
            // Clt.g:23:9: 'featuremodel'
            {
            match("featuremodel"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:24:7: ( 'mapping' )
            // Clt.g:24:9: 'mapping'
            {
            match("mapping"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:25:7: ( 'on' )
            // Clt.g:25:9: 'on'
            {
            match("on"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:26:7: ( 'references' )
            // Clt.g:26:9: 'references'
            {
            match("references"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:27:7: ( 'stage' )
            // Clt.g:27:9: 'stage'
            {
            match("stage"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:28:7: ( 'stages' )
            // Clt.g:28:9: 'stages'
            {
            match("stages"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:29:7: ( 'ufeatures' )
            // Clt.g:29:9: 'ufeatures'
            {
            match("ufeatures"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:30:7: ( 'unbound' )
            // Clt.g:30:9: 'unbound'
            {
            match("unbound"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:31:7: ( 'views' )
            // Clt.g:31:9: 'views'
            {
            match("views"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:32:7: ( '{' )
            // Clt.g:32:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:33:7: ( '}' )
            // Clt.g:33:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:1551:6: ( ( ( ',' | ';' ) ) )
            // Clt.g:
            {
            if ( input.LA(1)==','||input.LA(1)==';' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:1554:8: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Clt.g:1555:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Clt.g:1555:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Clt.g:1555:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Clt.g:1555:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Clt.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
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
            	    break loop1;
                }
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
    // $ANTLR end "COMMENT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:1558:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Clt.g:1559:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Clt.g:1559:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Clt.g:1559:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Clt.g:1559:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Clt.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


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
            // Clt.g:1561:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Clt.g:1562:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Clt.g:1565:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Clt.g:1566:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Clt.g:1566:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Clt.g:1566:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Clt.g:1566:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;
                }
            }
            else if ( (LA3_0=='\n') ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Clt.g:1566:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Clt.g:1566:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Clt.g:1566:20: '\\n'
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

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:1569:13: ( ( ( '<' ) (~ ( '>' ) )* ( '>' ) ) )
            // Clt.g:1570:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            {
            // Clt.g:1570:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Clt.g:1570:3: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Clt.g:1570:3: ( '<' )
            // Clt.g:1570:4: '<'
            {
            match('<'); 

            }


            // Clt.g:1570:8: (~ ( '>' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '=')||(LA4_0 >= '?' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Clt.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
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


            // Clt.g:1570:17: ( '>' )
            // Clt.g:1570:18: '>'
            {
            match('>'); 

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
    // $ANTLR end "QUOTED_60_62"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:1572:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Clt.g:1573:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Clt.g:1573:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Clt.g:1573:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Clt.g:1573:3: ( '\"' )
            // Clt.g:1573:4: '\"'
            {
            match('\"'); 

            }


            // Clt.g:1573:8: (~ ( '\"' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Clt.g:
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
            	    break loop5;
                }
            } while (true);


            // Clt.g:1573:17: ( '\"' )
            // Clt.g:1573:18: '\"'
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
        // Clt.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | COMMA | COMMENT | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 )
        int alt6=26;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // Clt.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // Clt.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // Clt.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // Clt.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // Clt.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // Clt.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // Clt.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // Clt.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // Clt.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // Clt.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // Clt.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // Clt.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // Clt.g:1:82: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // Clt.g:1:88: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // Clt.g:1:94: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // Clt.g:1:100: T__26
                {
                mT__26(); 


                }
                break;
            case 17 :
                // Clt.g:1:106: T__27
                {
                mT__27(); 


                }
                break;
            case 18 :
                // Clt.g:1:112: T__28
                {
                mT__28(); 


                }
                break;
            case 19 :
                // Clt.g:1:118: T__29
                {
                mT__29(); 


                }
                break;
            case 20 :
                // Clt.g:1:124: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 21 :
                // Clt.g:1:130: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 22 :
                // Clt.g:1:138: TEXT
                {
                mTEXT(); 


                }
                break;
            case 23 :
                // Clt.g:1:143: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 24 :
                // Clt.g:1:154: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 25 :
                // Clt.g:1:164: QUOTED_60_62
                {
                mQUOTED_60_62(); 


                }
                break;
            case 26 :
                // Clt.g:1:177: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\2\uffff\12\20\11\uffff\10\20\1\53\15\20\1\uffff\11\20\1\102\11"+
        "\20\1\114\2\20\1\uffff\4\20\1\124\2\20\1\127\1\20\1\uffff\6\20\1"+
        "\137\1\uffff\2\20\1\uffff\4\20\1\147\1\150\1\20\1\uffff\1\20\1\153"+
        "\5\20\2\uffff\2\20\1\uffff\1\163\2\20\1\166\2\20\1\171\1\uffff\2"+
        "\20\1\uffff\1\20\1\175\1\uffff\3\20\1\uffff\1\u0081\1\20\1\u0083"+
        "\1\uffff\1\20\1\uffff\1\u0085\1\uffff";
    static final String DFA6_eofS =
        "\u0086\uffff";
    static final String DFA6_minS =
        "\1\11\1\uffff\1\146\1\154\2\145\1\141\1\156\1\145\1\164\1\146\1"+
        "\151\11\uffff\1\145\1\151\1\164\2\141\1\145\1\141\1\160\1\55\1\146"+
        "\1\141\1\145\1\142\1\145\1\141\1\166\1\157\1\163\1\144\1\141\1\164"+
        "\1\160\1\uffff\1\145\1\147\1\141\1\157\1\167\1\164\1\145\1\143\1"+
        "\163\1\55\1\164\1\165\1\151\1\162\1\145\1\164\1\165\1\163\1\165"+
        "\1\55\1\157\1\151\1\uffff\1\165\1\162\1\156\1\145\1\55\1\165\1\156"+
        "\1\55\1\162\1\uffff\1\155\1\146\1\162\1\145\1\147\1\156\1\55\1\uffff"+
        "\1\162\1\144\1\uffff\1\145\1\160\1\151\1\145\2\55\1\143\1\uffff"+
        "\1\145\1\55\1\163\1\154\1\143\1\163\1\157\2\uffff\1\145\1\163\1"+
        "\uffff\1\55\1\145\1\141\1\55\1\144\1\163\1\55\1\uffff\2\164\1\uffff"+
        "\1\145\1\55\1\uffff\1\145\1\151\1\154\1\uffff\1\55\1\157\1\55\1"+
        "\uffff\1\156\1\uffff\1\55\1\uffff";
    static final String DFA6_maxS =
        "\1\175\1\uffff\1\165\1\154\1\146\1\145\1\141\1\156\1\145\1\164\1"+
        "\156\1\151\11\uffff\1\145\1\151\1\164\2\141\1\145\1\141\1\160\1"+
        "\172\1\146\1\141\1\145\1\142\1\145\1\141\1\166\1\157\1\163\1\144"+
        "\1\141\1\164\1\160\1\uffff\1\145\1\147\1\141\1\157\1\167\1\164\1"+
        "\145\1\143\1\163\1\172\1\164\1\165\1\151\1\162\1\145\1\164\1\165"+
        "\1\163\1\165\1\172\1\157\1\151\1\uffff\1\165\1\162\1\156\1\145\1"+
        "\172\1\165\1\156\1\172\1\162\1\uffff\1\155\1\146\1\162\1\145\1\147"+
        "\1\156\1\172\1\uffff\1\162\1\144\1\uffff\1\145\1\160\1\151\1\145"+
        "\2\172\1\143\1\uffff\1\145\1\172\1\163\1\154\1\143\1\163\1\157\2"+
        "\uffff\1\145\1\163\1\uffff\1\172\1\145\1\141\1\172\1\144\1\163\1"+
        "\172\1\uffff\2\164\1\uffff\1\145\1\172\1\uffff\1\145\1\151\1\154"+
        "\1\uffff\1\172\1\157\1\172\1\uffff\1\156\1\uffff\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\12\uffff\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
        "\32\26\uffff\1\13\26\uffff\1\6\11\uffff\1\3\7\uffff\1\15\2\uffff"+
        "\1\21\7\uffff\1\16\7\uffff\1\10\1\12\2\uffff\1\20\7\uffff\1\2\2"+
        "\uffff\1\7\2\uffff\1\17\3\uffff\1\14\3\uffff\1\4\1\uffff\1\11\1"+
        "\uffff\1\5";
    static final String DFA6_specialS =
        "\u0086\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\21\1\22\1\uffff\1\21\1\22\22\uffff\1\21\1\uffff\1\24\11\uffff"+
            "\1\16\1\20\1\uffff\1\17\12\20\1\1\1\16\1\23\4\uffff\32\20\4"+
            "\uffff\1\20\1\uffff\1\2\1\20\1\3\1\4\1\20\1\5\6\20\1\6\1\20"+
            "\1\7\2\20\1\10\1\11\1\20\1\12\1\13\4\20\1\14\1\uffff\1\15",
            "",
            "\1\25\5\uffff\1\26\10\uffff\1\27",
            "\1\30",
            "\1\31\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40\7\uffff\1\41",
            "\1\42",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\115",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\22\20"+
            "\1\123\7\20",
            "\1\125",
            "\1\126",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\130",
            "",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\140",
            "\1\141",
            "",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\14\20"+
            "\1\146\15\20",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\151",
            "",
            "\1\152",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "",
            "\1\161",
            "\1\162",
            "",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\164",
            "\1\165",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\167",
            "\1\170",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\172",
            "\1\173",
            "",
            "\1\174",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\u0082",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\u0084",
            "",
            "\1\20\2\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | COMMA | COMMENT | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 );";
        }
    }
 

}
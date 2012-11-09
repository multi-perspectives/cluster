// $ANTLR 3.4

	package org.feature.multi.perspective.classification.resource.clt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CltLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
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
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34=5;
    public static final int QUOTED_60_62=6;
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

    public CltLexer() {} 
    public CltLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CltLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Clt.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:15:6: ( ':' )
            // Clt.g:15:8: ':'
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:16:7: ( 'alive' )
            // Clt.g:16:9: 'alive'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:17:7: ( 'autocomplete' )
            // Clt.g:17:9: 'autocomplete'
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:18:7: ( 'classification' )
            // Clt.g:18:9: 'classification'
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:19:7: ( 'dead' )
            // Clt.g:19:9: 'dead'
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:20:7: ( 'feature' )
            // Clt.g:20:9: 'feature'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:21:7: ( 'featuremodel' )
            // Clt.g:21:9: 'featuremodel'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:22:7: ( 'mapping' )
            // Clt.g:22:9: 'mapping'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:23:7: ( 'on' )
            // Clt.g:23:9: 'on'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:24:7: ( 'references' )
            // Clt.g:24:9: 'references'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:25:7: ( 'stage' )
            // Clt.g:25:9: 'stage'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:26:7: ( 'unbound' )
            // Clt.g:26:9: 'unbound'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:27:7: ( 'view' )
            // Clt.g:27:9: 'view'
            {
            match("view"); 



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
            // Clt.g:28:7: ( '{' )
            // Clt.g:28:9: '{'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:29:7: ( '}' )
            // Clt.g:29:9: '}'
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
    // $ANTLR end "T__23"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Clt.g:1110:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Clt.g:1111:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Clt.g:1111:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Clt.g:1111:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Clt.g:1111:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            // Clt.g:1114:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Clt.g:1115:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Clt.g:1118:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Clt.g:1119:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Clt.g:1119:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Clt.g:1119:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Clt.g:1119:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Clt.g:1119:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Clt.g:1119:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Clt.g:1119:20: '\\n'
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
            // Clt.g:1122:13: ( ( ( '<' ) (~ ( '>' ) )* ( '>' ) ) )
            // Clt.g:1123:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            {
            // Clt.g:1123:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Clt.g:1123:3: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Clt.g:1123:3: ( '<' )
            // Clt.g:1123:4: '<'
            {
            match('<'); 

            }


            // Clt.g:1123:8: (~ ( '>' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '=')||(LA3_0 >= '?' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    break loop3;
                }
            } while (true);


            // Clt.g:1123:17: ( '>' )
            // Clt.g:1123:18: '>'
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
            // Clt.g:1125:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Clt.g:1126:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Clt.g:1126:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Clt.g:1126:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Clt.g:1126:3: ( '\"' )
            // Clt.g:1126:4: '\"'
            {
            match('\"'); 

            }


            // Clt.g:1126:8: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    break loop4;
                }
            } while (true);


            // Clt.g:1126:17: ( '\"' )
            // Clt.g:1126:18: '\"'
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
        // Clt.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 )
        int alt5=20;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // Clt.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // Clt.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // Clt.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // Clt.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // Clt.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // Clt.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // Clt.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // Clt.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // Clt.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // Clt.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // Clt.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // Clt.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // Clt.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // Clt.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // Clt.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // Clt.g:1:99: TEXT
                {
                mTEXT(); 


                }
                break;
            case 17 :
                // Clt.g:1:104: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 18 :
                // Clt.g:1:115: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 19 :
                // Clt.g:1:125: QUOTED_60_62
                {
                mQUOTED_60_62(); 


                }
                break;
            case 20 :
                // Clt.g:1:138: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\2\uffff\12\16\7\uffff\6\16\1\44\12\16\1\uffff\7\16\1\66\5\16\1"+
        "\74\1\75\2\16\1\uffff\3\16\1\103\1\16\2\uffff\5\16\1\uffff\3\16"+
        "\1\116\1\117\1\16\1\121\3\16\2\uffff\1\16\1\uffff\7\16\1\135\3\16"+
        "\1\uffff\1\141\1\16\1\143\1\uffff\1\16\1\uffff\1\145\1\uffff";
    static final String DFA5_eofS =
        "\146\uffff";
    static final String DFA5_minS =
        "\1\11\1\uffff\2\154\2\145\1\141\1\156\1\145\1\164\1\156\1\151\7"+
        "\uffff\1\151\1\164\3\141\1\160\1\55\1\146\1\141\1\142\1\145\1\166"+
        "\1\157\1\163\1\144\1\164\1\160\1\uffff\1\145\1\147\1\157\1\167\1"+
        "\145\1\143\1\163\1\55\1\165\1\151\1\162\1\145\1\165\2\55\1\157\1"+
        "\151\1\uffff\1\162\1\156\1\145\1\55\1\156\2\uffff\1\155\1\146\1"+
        "\145\1\147\1\156\1\uffff\1\144\1\160\1\151\2\55\1\143\1\55\1\154"+
        "\1\143\1\157\2\uffff\1\145\1\uffff\1\145\1\141\1\144\1\163\2\164"+
        "\1\145\1\55\1\145\1\151\1\154\1\uffff\1\55\1\157\1\55\1\uffff\1"+
        "\156\1\uffff\1\55\1\uffff";
    static final String DFA5_maxS =
        "\1\175\1\uffff\1\165\1\154\2\145\1\141\1\156\1\145\1\164\1\156\1"+
        "\151\7\uffff\1\151\1\164\3\141\1\160\1\172\1\146\1\141\1\142\1\145"+
        "\1\166\1\157\1\163\1\144\1\164\1\160\1\uffff\1\145\1\147\1\157\1"+
        "\167\1\145\1\143\1\163\1\172\1\165\1\151\1\162\1\145\1\165\2\172"+
        "\1\157\1\151\1\uffff\1\162\1\156\1\145\1\172\1\156\2\uffff\1\155"+
        "\1\146\1\145\1\147\1\156\1\uffff\1\144\1\160\1\151\2\172\1\143\1"+
        "\172\1\154\1\143\1\157\2\uffff\1\145\1\uffff\1\145\1\141\1\144\1"+
        "\163\2\164\1\145\1\172\1\145\1\151\1\154\1\uffff\1\172\1\157\1\172"+
        "\1\uffff\1\156\1\uffff\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\12\uffff\1\16\1\17\1\20\1\21\1\22\1\23\1\24\21\uffff"+
        "\1\11\21\uffff\1\5\5\uffff\1\15\1\2\5\uffff\1\13\12\uffff\1\6\1"+
        "\10\1\uffff\1\14\13\uffff\1\12\3\uffff\1\3\1\uffff\1\7\1\uffff\1"+
        "\4";
    static final String DFA5_specialS =
        "\146\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\17\1\20\1\uffff\1\17\1\20\22\uffff\1\17\1\uffff\1\22\12\uffff"+
            "\1\16\2\uffff\12\16\1\1\1\uffff\1\21\4\uffff\32\16\4\uffff\1"+
            "\16\1\uffff\1\2\1\16\1\3\1\4\1\16\1\5\6\16\1\6\1\16\1\7\2\16"+
            "\1\10\1\11\1\16\1\12\1\13\4\16\1\14\1\uffff\1\15",
            "",
            "\1\23\10\uffff\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\76",
            "\1\77",
            "",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\104",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\14\16"+
            "\1\115\15\16",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\120",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "",
            "\1\125",
            "",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\136",
            "\1\137",
            "\1\140",
            "",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\142",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\1\144",
            "",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 );";
        }
    }
 

}
package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class IdentifierTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testIdentifier_1() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_2() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("42");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testIdentifier_3() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("42.42");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testIdentifier_4() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"TEXT\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testIdentifier_5() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "OF", "MY-RECORD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_6() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "IN", "MY-RECORD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_7() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "OF", "MY-RECORD-1", 
        "IN", "MY-RECORD-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_8() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "IN", "MY-RECORD-1", 
        "OF", "MY-RECORD-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_9() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "42", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_10() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "42.0", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_11() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "MY-INDEX", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_12() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "MY-INDEX", "+", 
        "42", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_13() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "MY-INDEX", "-", 
        "42", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_14() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "MY-INDEX", ":", 
        "42", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_15() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "MY-INDEX", ":", 
        "MY-LENGTH", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_16() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "42", ":", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_17() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "MY-INDEX", ":", 
        ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_18() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "1", "2", "3", 
        ")", "(", "42", ":", "11", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_19() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "A", "B", "C", 
        ")", "(", "MY-POSITION", ":", "MY-LENGTH", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_20() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-FIELD", "(", "A", "+", "1", 
        "B", "C", "-", "2", ")", "(", "42", ":", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_21() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_22() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "1", ":", 
        "7", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_23() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "3", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_24() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "3", ")", 
        "(", "1", ":", "7", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_25() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "3", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_26() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "3", ")", 
        "(", "1", ":", "7", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_27() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "3", "\" bottles of beer\"", 
        ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_28() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CAT", "(", "3", "\" bottles of beer\"", 
        ")", "(", "1", ":", "7", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_29() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "FOO", "(", "1", "FUNCTION", 
        "INC", "(", "1", ")", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_30() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CHAR", "(", "IND", 
        "(", "5", ")", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_31() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "CHAR", "(", "IND", 
        "(", "C", ")", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_32() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "NUMVAL", "(", "\"4738\"", 
        ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_33() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION", "MAX", "(", "WS-TABLE", 
        "(", "ALL", "ALL", "ALL", ")", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_34() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("AX-2", "IN", "AX", "(", "CX-SUB", 
        "OF", "CX", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentifier_35() {
      Parser parser = grammar.identifier();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNQUAL-ITEM", "(", "SUB1", "OF", 
        "SUBSCRIPTS", "OF", "SUBSCRIPTS-PART1", ")");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }
}
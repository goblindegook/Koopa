package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class CloseStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCloseStatement_1() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_2() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "MY-OTHER-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_3() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "MY-OTHER-FILE", 
        "MY-THIRD-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_4() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "WITH", "NO", 
        "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_5() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "NO", "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_6() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "WITH", "LOCK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_7() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "LOCK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_8() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "REEL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_9() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "REEL", "FOR", 
        "REMOVAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_10() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "REEL", "REMOVAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_11() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "UNIT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_12() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "UNIT", "FOR", 
        "REMOVAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_13() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "UNIT", "REMOVAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_14() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "FOR", "REMOVAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCloseStatement_15() {
      Parser parser = grammar.closeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CLOSE", "MY-FILE", "REMOVAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }
}
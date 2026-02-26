import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest{

    @Test
    void test_SpellCheck_Word_Number(){
        // 1. construct objects to be tested 
        SpellChecker checker = new SpellChecker();

        //2. Call the method being tested
        int words = checker.getNumberOfWords();

        // use assertions to verify results
        assertEquals(0, words);
    }


    @Test
    void test_Words_Increasing(){
        // 1. construct objects to be tested 
        SpellChecker checker = new SpellChecker();

        int wordsBefore = checker.getNumberOfWords();

        checker.addWord( "hi");

        int wordsAfter = checker.getNumberOfWords();

        assertEquals(wordsBefore + 1, wordsAfter);
    }

    @Test
    void test_Existed_Word_Added_Again(){
        
        SpellChecker checker = new SpellChecker();

        checker.addWord( "hi");
        int wordsBefore =  checker.getNumberOfWords();

        checker.addWord( "hi");
        int wordsAfter =  checker.getNumberOfWords();

        assertEquals(wordsBefore, wordsAfter);
    }

    @Test
    boolean test_word_correctly_spelled(){
        
        SpellChecker checker = new SpellChecker();

        boolean res = checker.checkSpelling("Apple");

        assertEquals(res, True);
    }

    @Test
    boolean test_word_INcorrectly_spelled(){
        
        SpellChecker checker = new SpellChecker();

        boolean res = checker.checkSpelling("Applexyz");

        assertEquals(res, False);
    }

    @Test
    boolean test_word_correctly_spelled_CAPS(){
        
        SpellChecker checker = new SpellChecker();

        boolean res = checker.checkSpelling("ApPlE");

        assertEquals(res, True);
    }


    @Test
    boolean test_word_INcorrectly_spelled_CAPS(){
        
        SpellChecker checker = new SpellChecker();

        boolean res = checker.checkSpelling("ApPleXyz");

        assertEquals(res, False);
    }

    @Test
    boolean test_reccomend_proper_spelling_incorrect_given(){
        
        SpellChecker checker = new SpellChecker();

        String rec = checker.recommend("bamk");

        assertEquals(rec, "bank");
    }

    @Test
    boolean test_reccomend_proper_spelling_correct_given(){
        
        SpellChecker checker = new SpellChecker();

        String rec = checker.recommend("bank");

        assertEquals(rec, "bank");
    }

    @Test // testing if you can add a word to the dictionary that is not actually a real word
    boolean test_word_added_to_dict(){
        
        SpellChecker checker = new SpellChecker();

        checker.addWordToDict("xyz");

        boolean res = checker.checkSpelling("xyz");

        assertEquals(res, True);
    }

    @Test // testing if you can remove a real word from the dictionary
    boolean test_word_removed_from_dict(){
        
        SpellChecker checker = new SpellChecker();

        checker.removeFromDict("apple");

        boolean res = checker.checkSpelling("apple");

        assertEquals(res, False);
    }
}
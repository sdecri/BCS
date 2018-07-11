/**
 * BestCommonSubsequenceCalculatorTest.java
 */
package com.sdc.bcs;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import com.sdc.bcs.api.BestCommonSequence;
import com.sdc.bcs.test.element.CharacterElement;
import com.sdc.bcs.test.element.CharacterWeightedElement;

import static org.hamcrest.Matchers.*;

/**
 * @author simone
 * Jul 11, 2018
 */
public class BestCommonSubsequenceCalculatorCharacterTest {

    @Test
    public void testNoWeigth() {
        
        CharacterElement[] s1 = new CharacterElement[] {
                new CharacterElement('g')
                , new CharacterElement('a')
                , new CharacterElement('c')
        };
        
        CharacterElement[] s2 = new CharacterElement[] {
                new CharacterElement('a')
                , new CharacterElement('g')
                , new CharacterElement('c')
                , new CharacterElement('a')
                , new CharacterElement('t')
        };
        
        BestCommonSubsequenceCalculator<CharacterElement> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 2.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<CharacterElement> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        
        List<CharacterElement> expectedList = Arrays.asList(new CharacterElement('g'), new CharacterElement('a'));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedList.toArray()));
        
    }
    
    @Test
    public void testWithWeigth1() {
        
        CharacterWeightedElement[] s1 = new CharacterWeightedElement[] {
                new CharacterWeightedElement('g', 1)
                , new CharacterWeightedElement('a', 4)
                , new CharacterWeightedElement('c', 5)
        };
        
        CharacterWeightedElement[] s2 = new CharacterWeightedElement[] {
                new CharacterWeightedElement('a', 4)
                , new CharacterWeightedElement('g', 1)
                , new CharacterWeightedElement('c', 5)
                , new CharacterWeightedElement('a', 4)
                , new CharacterWeightedElement('t', 3)
        };
        
        BestCommonSubsequenceCalculator<CharacterWeightedElement> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 9.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<CharacterWeightedElement> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        List<CharacterWeightedElement> expectedList =
                Arrays.asList(new CharacterWeightedElement('a', 4), new CharacterWeightedElement('c', 5));
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedList.toArray()));
        
    }
    
    @Test
    public void testWithWeigth2() {
        
        CharacterWeightedElement[] s1 = new CharacterWeightedElement[] {
                new CharacterWeightedElement('g', 10)
                , new CharacterWeightedElement('a', 1)
                , new CharacterWeightedElement('c', 3)
        };
        
        CharacterWeightedElement[] s2 = new CharacterWeightedElement[] {
                new CharacterWeightedElement('a', 1)
                , new CharacterWeightedElement('g', 10)
                , new CharacterWeightedElement('c', 3)
                , new CharacterWeightedElement('a', 1)
                , new CharacterWeightedElement('t', 20)
        };
        
        BestCommonSubsequenceCalculator<CharacterWeightedElement> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 13.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<CharacterWeightedElement> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        List<CharacterWeightedElement> expectedList =
                Arrays.asList(new CharacterWeightedElement('g', 10), new CharacterWeightedElement('c', 3));
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedList.toArray()));
        
    }
    
}

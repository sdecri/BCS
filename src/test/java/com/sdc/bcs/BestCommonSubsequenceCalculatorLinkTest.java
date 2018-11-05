/**
 * BestCommonSubsequenceCalculatorLinkTest.java
 */
package com.sdc.bcs;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import com.sdc.bcs.api.BestCommonSequence;
import com.sdc.bcs.api.SequenceIndexes;
import com.sdc.bcs.test.element.Link;

/**
 * @author simone
 * Jul 11, 2018
 */
public class BestCommonSubsequenceCalculatorLinkTest {

    @Test
    public void testLinkWeight() {
        
        Link[] s1 = new Link[] {
                new Link(8, 80, 100)
                , new Link(7, 70, 50)
                , new Link(1, 10, 1)
                , new Link(9, 90, 1)
                , new Link(5, 50, 1)
                , new Link(4, 40, 1)
                , new Link(1, 10, 1)
                , new Link(6, 60, 20)
                , new Link(2, 20, 3)
                
        };
        
        Link[] s2 = new Link[] {
                new Link(1, 10, 1)
                , new Link(2, 20, 3)
                , new Link(9, 90, 1)
                , new Link(5, 50, 1)
                , new Link(8, 80, 100)
                , new Link(4, 40, 1)
                , new Link(1, 10, 1)
                , new Link(7, 70, 20)
                , new Link(3, 30, 10)
        };
        
        BestCommonSubsequenceCalculator<Link> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 120.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<Link> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        
        List<Link> expectedSequence = 
                Arrays.asList(new Link(8, 80, 100), new Link(7, 70, 20));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedSequence.toArray()));

        List<SequenceIndexes> expectedSequenceIndexes = 
                Arrays.asList(new SequenceIndexes(0, 4), new SequenceIndexes(1, 7));
        assertThat(bcs.getSequenceIndexes(), IsIterableContainingInOrder.contains(expectedSequenceIndexes.toArray()));

        
    }
 
    @Test
    public void testSameLinkRepeatedInSequenceGreatesWeightBeforeOnSequence2() {
        
        Link[] s1 = new Link[] {
                new Link(8, 80, 100)
                , new Link(8, 80, 70)
                , new Link(7, 70, 50)
                , new Link(1, 10, 5)
                
        };
        
        Link[] s2 = new Link[] {
                new Link(1, 10, 1)
                , new Link(2, 20, 3)
                , new Link(9, 90, 1)
                , new Link(5, 50, 1)
                , new Link(8, 80, 100)
                , new Link(8, 80, 1)
                , new Link(1, 10, 1)
                , new Link(7, 70, 20)
                , new Link(3, 30, 10)
        };
        
        BestCommonSubsequenceCalculator<Link> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 121.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<Link> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        
        List<Link> expectedSequence = 
                Arrays.asList(new Link(8, 80, 100), new Link(8, 80, 1), new Link(7, 70, 20));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedSequence.toArray()));

        List<SequenceIndexes> expectedSequenceIndexes = 
                Arrays.asList(new SequenceIndexes(0, 4), new SequenceIndexes(1, 5), new SequenceIndexes(2, 7));
        assertThat(bcs.getSequenceIndexes(), IsIterableContainingInOrder.contains(expectedSequenceIndexes.toArray()));

        
    }
    
    
    @Test
    public void testSameLinkRepeatedInSequenceLowestWeightBeforeOnSequence2() {
        
        Link[] s1 = new Link[] {
                new Link(8, 80, 70)
                , new Link(8, 80, 50)
                , new Link(7, 70, 50)
                , new Link(1, 10, 5)
                
        };
        
        Link[] s2 = new Link[] {
                new Link(1, 10, 1)
                , new Link(2, 20, 3)
                , new Link(9, 90, 1)
                , new Link(5, 50, 1)
                , new Link(8, 80, 1)
                , new Link(8, 80, 100)
                , new Link(1, 10, 1)
                , new Link(7, 70, 20)
                , new Link(3, 30, 10)
        };
        
        BestCommonSubsequenceCalculator<Link> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 90.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<Link> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        
        List<Link> expectedSequence = 
                Arrays.asList(new Link(8, 80, 70), new Link(7, 70, 20));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedSequence.toArray()));

        List<SequenceIndexes> expectedSequenceIndexes = 
                Arrays.asList(new SequenceIndexes(0, 5), new SequenceIndexes(2, 7));
        assertThat(bcs.getSequenceIndexes(), IsIterableContainingInOrder.contains(expectedSequenceIndexes.toArray()));

        
    }
    
    
    @Test
    public void testConstantWeightSameLinkRepeatedInSequenceCase1() {
        
        Link[] s1 = new Link[] {
                new Link(8, 80, 1, 0.3)
                , new Link(8, 80, 1, 1)
                , new Link(7, 70, 1, 1)
                , new Link(1, 10, 1, 0.6)
                
        };
        
        Link[] s2 = new Link[] {
                new Link(1, 10, 1, 0.7)
                , new Link(2, 20, 1, 1)
                , new Link(9, 90, 1, 1)
                , new Link(5, 50, 1, 1)
                , new Link(8, 80, 1, 0.5)
                , new Link(8, 80, 1, 0.2)
                , new Link(1, 10, 1, 1)
                , new Link(7, 70, 1, 1)
                , new Link(3, 30, 1, 0.6)
        };
        
        BestCommonSubsequenceCalculator<Link> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 3.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<Link> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        
        List<Link> expectedSequence = 
                Arrays.asList(new Link(8, 80, 1, 0.5), new Link(8, 80, 1, 0.2), new Link(7, 70, 1, 1));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedSequence.toArray()));

        List<SequenceIndexes> expectedSequenceIndexes = 
                Arrays.asList(new SequenceIndexes(0, 4), new SequenceIndexes(1, 5), new SequenceIndexes(2, 7));
        assertThat(bcs.getSequenceIndexes(), IsIterableContainingInOrder.contains(expectedSequenceIndexes.toArray()));

        
    }
    
    
    @Test
    public void testConstantWeightSameLinkRepeatedInSequenceCase2() {
        
        Link[] s1 = new Link[] {
                new Link(8, 80, 1, 0.3)
                , new Link(7, 70, 1, 1)
                , new Link(4, 40, 1, 0.6)
                
        };
        
        Link[] s2 = new Link[] {
                new Link(1, 10, 1, 0.7)
                , new Link(2, 20, 1, 1)
                , new Link(9, 90, 1, 1)
                , new Link(5, 50, 1, 1)
                , new Link(8, 80, 1, 0.5)
                , new Link(8, 80, 1, 0.2)
                , new Link(1, 10, 1, 1)
                , new Link(7, 70, 1, 1)
                , new Link(3, 30, 1, 0.6)
        };
        
        BestCommonSubsequenceCalculator<Link> calculator =
                new BestCommonSubsequenceCalculator<>();
        
        double expectedBestWeight = 2.;
        
        assertThat(calculator.getBestWeight(s1, s2), is(equalTo(expectedBestWeight)));
        
        BestCommonSequence<Link> bcs = calculator.getBestCommonSubsequence(s1, s2);
        
        assertThat(bcs.getWeight(), is(equalTo(expectedBestWeight)));
        
        List<Link> expectedSequence = 
                Arrays.asList(new Link(8, 80, 1, 0.5), new Link(7, 70, 1, 1));
        assertThat(bcs.getSequence(), IsIterableContainingInOrder.contains(expectedSequence.toArray()));

        List<SequenceIndexes> expectedSequenceIndexes = 
                Arrays.asList(new SequenceIndexes(0, 4), new SequenceIndexes(1, 7));
        assertThat(bcs.getSequenceIndexes(), IsIterableContainingInOrder.contains(expectedSequenceIndexes.toArray()));

        
    }
    
}

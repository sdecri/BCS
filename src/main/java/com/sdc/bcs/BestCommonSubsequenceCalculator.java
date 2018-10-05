/**
 * BestCommonSubsequence.java
 */
package com.sdc.bcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdc.bcs.api.BestCommonSequence;
import com.sdc.bcs.api.SequenceIndexes;
import com.sdc.bcs.api.Weightable;
import com.sdc.bcs.api.WithKey;

/**
 * @author simone
 *         Jul 11, 2018
 * @param <T>
 */
public class BestCommonSubsequenceCalculator<T extends WithKey & Weightable> {

    private static final Logger LOG = LoggerFactory.getLogger(BestCommonSubsequenceCalculator.class);

    private double[][] computeWeightMatrix(T[] s1, T[] s2) {

        if (s1 == null) {
            LOG.warn("First sequence is null returning null");
            return null;
        }
        if (s2 == null) {
            LOG.warn("Second sequence is null returning null");
            return null;
        }

        double[][] wm = new double[s1.length + 1][s2.length + 1];

        for (int i = 0; i < wm.length; i++) {

            for (int j = 0; j < wm[i].length; j++) {

                if (i == 0 || j == 0)
                    wm[i][j] = 0;
                else {

                    if (s1[i-1].hasSameKey(s2[j-1]))
                        wm[i][j] = wm[i - 1][j - 1] + Math.min(s1[i-1].getWeigth(), s2[j-1].getWeigth());
                    else
                        wm[i][j] = wm[i - 1][j] >= wm[i][j - 1] 
                        ?  wm[i - 1][j] : wm[i][j - 1];

                }

            }
        }

        return wm;
    }

    /**
     * 
     * @param s1
     * @param s2
     * @return the greater weight given by a common subsequence
     */
    public double getBestWeight(T[] s1, T[] s2) {

        double[][] wm = computeWeightMatrix(s1, s2);
        if (wm != null)
            return wm[s1.length][s2.length];

        return 0;
    }

    public BestCommonSequence<T> getBestCommonSubsequence(T[] s1, T[] s2) {

        double[][] wm = computeWeightMatrix(s1, s2);

        if (wm != null) {

            int i = s1.length;
            int j = s2.length;

            BackTrackResult backTrackResult = backTrack(i, j, s1, s2, wm);
            
            return new BestCommonSequence<>(wm[i][j], backTrackResult.sequence, backTrackResult.sequenceIndexes);
            
        }
        else
            return new BestCommonSequence<>(0, Collections.emptyList(), Collections.emptyList());

    }

    private BackTrackResult backTrack(int i, int j, T[] s1, T[] s2, double[][] wm) {

        List<T> sequence = new ArrayList<>();
        List<SequenceIndexes> sequenceIndexes = new ArrayList<>();

        while(i > 0 && j > 0) {
            
            if (s1[i-1].hasSameKey(s2[j-1])) {
              
                sequence.add(s1[i-1].getWeigth() < s2[j-1].getWeigth() ? s1[i-1] : s2[j-1]);
                sequenceIndexes.add(new SequenceIndexes(i-1, j-1));
                i--;
                j--;
                
            } else {
                
                if (wm[i - 1][j] >= wm[i][j - 1])
                    i--;
                else
                    j--;
                
            }
            
        }
        
        Collections.reverse(sequence);
        Collections.reverse(sequenceIndexes);
        return new BackTrackResult(sequence, sequenceIndexes);
    }

    
    private class BackTrackResult{
        
        List<T> sequence;
        List<SequenceIndexes> sequenceIndexes;
        /**
         * @param sequence
         * @param sequenceIndexes
         */
        public BackTrackResult(List<T> sequence, List<SequenceIndexes> sequenceIndexes) {

            super();
            this.sequence = sequence;
            this.sequenceIndexes = sequenceIndexes;
        }
        
        
    }
    
}

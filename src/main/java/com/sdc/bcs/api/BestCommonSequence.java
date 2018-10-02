/**
 * BestCommonSequenceResult.java
 */
package com.sdc.bcs.api;

import java.util.List;

/**
 * @author simone
 * Jul 11, 2018
 * @param <T>
 */
public class BestCommonSequence<T extends WithKey & Weightable> {

    private double weight;
    private List<T> sequence;
    /**
     * The indexes of each element (included in the best common sub-sequence) in the source sequences.
     */
    private List<SequenceIndexes> sequenceIndexes;
    
    /**
     * @param weight
     * @param sequence
     * @param sequenceIndexes
     */
    public BestCommonSequence(double weight, List<T> sequence, List<SequenceIndexes> sequenceIndexes) {

        super();
        this.weight = weight;
        this.sequence = sequence;
        this.sequenceIndexes = sequenceIndexes;
    }

    
    /**
     * @return the {@link BestCommonSequence#weight}
     */
    public double getWeight() {
    
        return weight;
    }

    
    /**
     * @return the {@link BestCommonSequence#sequence}
     */
    public List<T> getSequence() {
    
        return sequence;
    }

    
    /**
     * @return the {@link BestCommonSequence#sequenceIndexes}
     */
    public List<SequenceIndexes> getSequenceIndexes() {
    
        return sequenceIndexes;
    }
    

    
    
    
    
    
    
}

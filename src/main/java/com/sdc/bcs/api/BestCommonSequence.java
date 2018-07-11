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
     * @param weight
     * @param sequence
     */
    public BestCommonSequence(double weight, List<T> sequence) {
        super();
        this.weight = weight;
        this.sequence = sequence;
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
    
    
    
    
    
    
    
}

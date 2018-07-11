/**
 * WeghtComparable.java
 */
package com.sdc.bcs.api;

/**
 * @author simone
 *         Jul 11, 2018
 */
public abstract class WeightComparable implements Comparable<WeightComparable>, Weightable {

    /**
    * {@inheritDoc}
    */
    @Override
    public int compareTo(WeightComparable o) {
    
        return Double.compare(getWeigth(), o.getWeigth());
        
    }
    
}

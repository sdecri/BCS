/**
 * SequenceIndexes.java
 */
package com.sdc.bcs.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Simone De Cristofaro
 * Oct 2, 2018
 */
public class SequenceIndexes {

    private int indexOnFirstSequence;
    private int indexOnSecondSequence;
    
    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(indexOnFirstSequence).append(indexOnSecondSequence).toHashCode();
        
    }
    
    @Override
    public boolean equals(Object obj) {

        if (obj == null || !obj.getClass().equals(getClass()))
            return false;
        if (obj == this)
            return true;

        SequenceIndexes other = (SequenceIndexes) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder
        .append(indexOnFirstSequence, other.indexOnFirstSequence)
        .append(indexOnSecondSequence, other.indexOnSecondSequence)
        ;
        return equalsBuilder.isEquals();
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
    
        return String.format("(%d, %d)", indexOnFirstSequence, indexOnSecondSequence);
        
    }
    
    /**
     * @param indexOnFirstSequence
     * @param indexOnSecondSequence
     */
    public SequenceIndexes(int indexOnFirstSequence, int indexOnSecondSequence) {

        super();
        this.indexOnFirstSequence = indexOnFirstSequence;
        this.indexOnSecondSequence = indexOnSecondSequence;
    }

    
    /**
     * @return the {@link SequenceIndexes#indexOnFirstSequence}
     */
    public int getIndexOnFirstSequence() {
    
        return indexOnFirstSequence;
    }

    
    /**
     * @return the {@link SequenceIndexes#indexOnSecondSequence}
     */
    public int getIndexOnSecondSequence() {
    
        return indexOnSecondSequence;
    }
    
    
    
}

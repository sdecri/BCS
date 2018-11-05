/**
 * Link.java
 */
package com.sdc.bcs.test.element;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.sdc.bcs.api.Weightable;
import com.sdc.bcs.api.WithKey;

/**
 * @author simone
 * Jul 11, 2018
 */
public class Link implements WithKey, Weightable {

    private long id;
    private long tail;
    private int length;
    private double driveableShare;
    
    
    

    /**
     * @param id
     * @param tail
     * @param length
     * @param driveableShare
     */
    public Link(long id, long tail, int length, double driveableShare) {

        super();
        this.id = id;
        this.tail = tail;
        this.length = length;
        this.driveableShare = driveableShare;
    }
    


    /**
     * @param id
     * @param tail
     * @param length
     */
    public Link(long id, long tail, int length) {
        this(id, tail, length, 1);
    }


    /**
    * {@inheritDoc}
    */
    @Override
    public double getWeigth() {

        return length;
        
    }



    /**
    * {@inheritDoc}
    */
    @Override
    public boolean hasSameKey(WithKey obj) {

        if (obj == null || !obj.getClass().equals(getClass()))
            return false;
        if (obj == this)
            return true;
        
        Link other = (Link) obj;
        
        return id == other.id && tail == other.tail;
        
    }
    
    
    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(id).append(tail).append(length).append(driveableShare).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    
        if (obj == null || !obj.getClass().equals(getClass()))
            return false;
        if (obj == this)
            return true;
    
        Link other = (Link) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder
        .append(id, other.id)
        .append(tail, other.tail)
        .append(length, other.length)
        .append(driveableShare, other.driveableShare)
        ;
        return equalsBuilder.isEquals();
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
    
        return String.format("ID: %d, TAIL: %s, WEIGHT: %f, DRIV-SHARE: %f", id, tail, getWeigth(), driveableShare);
        
    }
    
    /**
     * @return the {@link Link#id}
     */
    public long getId() {
    
        return id;
    }



    
    /**
     * @param id the {@link Link#id} to set
     */
    public void setId(long id) {
    
        this.id = id;
    }



    
    /**
     * @return the {@link Link#tail}
     */
    public long getTail() {
    
        return tail;
    }



    
    /**
     * @param tail the {@link Link#tail} to set
     */
    public void setTail(long tail) {
    
        this.tail = tail;
    }

    
    /**
     * @return the {@link Link#length}
     */
    public int getLength() {
    
        return length;
    }



    
    /**
     * @param length the {@link Link#length} to set
     */
    public void setLength(int length) {
    
        this.length = length;
    }



    
    /**
     * @return the {@link Link#driveableShare}
     */
    public double getDriveableShare() {
    
        return driveableShare;
    }



    
    /**
     * @param driveableShare the {@link Link#driveableShare} to set
     */
    public void setDriveableShare(double driveableShare) {
    
        this.driveableShare = driveableShare;
    }




    
    
    
}

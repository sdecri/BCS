/**
 * Link.java
 */
package com.sdc.bcs.test.element;

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
    

    /**
     * @param id
     * @param tail
     * @param length
     */
    public Link(long id, long tail, int length) {
        super();
        this.id = id;
        this.tail = tail;
        this.length = length;
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
    public boolean equals(Object obj) {

        if (obj == null || !obj.getClass().equals(getClass()))
            return false;
        if (obj == this)
            return true;

        Link other = (Link) obj;
        return hasSameKey(other);
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




    
    
    
}

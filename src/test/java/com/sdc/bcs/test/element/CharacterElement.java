/**
 * CharacterElement.java
 */
package com.sdc.bcs.test.element;

import com.sdc.bcs.api.Weightable;
import com.sdc.bcs.api.WithKey;

/**
 * @author simone
 * Jul 11, 2018
 */
public class CharacterElement implements WithKey, Weightable{

    private char character;
    
    /**
     * @param character
     */
    public CharacterElement(char character) {
        super();
        this.character = character;
    }
    
    @Override
    public boolean equals(Object obj) {

        if (obj == null || !obj.getClass().equals(getClass()))
            return false;
        if (obj == this)
            return true;

        CharacterElement other = (CharacterElement) obj;
        return hasSameKey(other);
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public double getWeigth() {

        return 1;
        
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
        
        return character == ((CharacterElement) obj).character;
        
    }

    
    
    /**
     * @return the {@link CharacterElement#character}
     */
    public char getCharacter() {
    
        return character;
    }



}

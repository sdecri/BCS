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
public class CharacterWeightedElement implements WithKey, Weightable{

    private char character;
    private int weigth;


    /**
     * @param character
     * @param weigth
     */
    public CharacterWeightedElement(char character, int weigth) {
        super();
        this.character = character;
        this.weigth = weigth;
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public double getWeigth() {

        return weigth;
        
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
        
        return character == ((CharacterWeightedElement) obj).character;
        
    }
    
    @Override
    public boolean equals(Object obj) {

        if (obj == null || !obj.getClass().equals(getClass()))
            return false;
        if (obj == this)
            return true;

        CharacterWeightedElement other = (CharacterWeightedElement) obj;
        return hasSameKey(other);
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
    
        return String.join(" - ", Character.toString(character), Integer.toString(weigth));
        
    }

    
    
    /**
     * @return the {@link CharacterWeightedElement#character}
     */
    public char getCharacter() {
    
        return character;
    }



}

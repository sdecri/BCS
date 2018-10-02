# BCS
Best Common Subsequence


This is an implementation of the generalized Longest Common Subsequence problem (https://en.wikipedia.org/wiki/Longest_common_subsequence_problem), with variable weights.

The standard LCS is indeed a special case (constant weights equals to 1) of the general problem.


## Example

The element to compare must implement the WithKey and Weightable interfaces:
```java
public class Link implements WithKey, Weightable {

    private long id;
    private long tail;
    private int length;
    
    public Link(long id, long tail, int length) {
        super();
        this.id = id;
        this.tail = tail;
        this.length = length;
    }

    @Override
    public double getWeigth() {

        return length;
        
    }

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

    public long getId() {
    
        return id;
    }

    public void setId(long id) {
    
        this.id = id;
    }
    
    public long getTail() {
    
        return tail;
    }
    
    public void setTail(long tail) {
    
        this.tail = tail;
    }
    
    public int getLength() {
    
        return length;
    }
    
    public void setLength(int length) {
    
        this.length = length;
    }   
}


public class Main{

    public static void main(Strin[]args){
    
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
                , new Link(7, 70, 50)
                , new Link(3, 30, 10)
        };
        
        BestCommonSubsequenceCalculator<Link> calculator = new BestCommonSubsequenceCalculator<>();
        
        BestCommonSequence<Link> bcs = calculator.getBestCommonSubsequence(s1, s2);
    }

}


```





The example below shows the resolved example involving elements with different weights (in red).
Notice that the element "L7" has different weight in the two sequences, in this case the minimum weight between the two objects is considered.

![Alt text](bcs.png?raw=true "Title")

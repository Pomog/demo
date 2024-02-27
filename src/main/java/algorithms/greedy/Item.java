package algorithms.greedy;

/**
 * Represents an item in the Fractional Knapsack problem.
 */
public class Item {
    // Fields to store weight, value, and index of the item
    double wt, val, ind;
    
    // Field to store the cost of the item (value per unit weight)
    Double cost;
    
    /**
     * Constructs an Item with the given weight, value, and index.
     *
     * @param wt  the weight of the item
     * @param val the value of the item
     * @param ind the index of the item
     */
    public Item(double wt, double val, double ind) {
        this.wt = wt;
        this.val = val;
        this.ind = ind;
        
        // Calculate the cost (value per unit weight)
        cost = Double.valueOf(val / wt);
    }
}

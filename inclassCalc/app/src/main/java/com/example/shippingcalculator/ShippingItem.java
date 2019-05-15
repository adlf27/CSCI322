package com.example.shippingcalculator;

public class ShippingItem {
    //constants
    static final Double BASE_AMOUNT = 3.00,
                        ADDED_COST = 0.50,
                        EXTRA_COST = 4.0;

    static final Integer BASE_WEIGHT = 16;

    private Integer weight;
    private Double baseCost, addedCost, totalCost;

    //constructor for shippingItem
    public ShippingItem() {
        //set the weight to zero
        weight = 0;
        //set the basecost to the predefines based amount
        baseCost = BASE_AMOUNT;
        //initialize added cost
        addedCost = 0.0;
        //initialize total cost
        totalCost = 0.0;
    }
    //set weight function. it accepts one argument the weight enter by the user to be calculated

    public void setWeight(Integer weight) {
        this.weight = weight;
        //calls the compute cost function
        computeCost();
    }
    //compute cost function. it calculates the total cost for the weight enter by the user
    public void computeCost()
    {
        baseCost = BASE_AMOUNT;
        //if the weight is a negative value
        if(weight <= 0)
            baseCost = 0.0;  //sets the base cost to zero

        addedCost = 0.0;
        //if the wieght is greater than
        if(weight > BASE_WEIGHT)
            addedCost = Math.ceil((weight - BASE_WEIGHT)/EXTRA_COST) * ADDED_COST;
        // adds the base cost and the added cost to the total variable
        totalCost = baseCost + addedCost;
    }

    //returns the base cost
    public Double getBaseCost() {
        return baseCost;
    }

    //returns the added cost
    public Double getAddedCost() {
        return addedCost;
    }

    //returns the total cost
    public Double getTotalCost() {
        return totalCost;
    }
}

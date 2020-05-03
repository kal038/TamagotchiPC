package Pet;
/*
 * Food enum to keep track of the different types of food
 */

public enum Food {

    APPLE(2), GRAPES(4), MEAT(1), WATER(8), ANT(3), GRASS(2);
    public final double foodMultiplier ;

    Food(double foodMultiplier) {
        this.foodMultiplier = foodMultiplier;
    }


    /**
     * gets the food multiplier
     * @return foodMultiplier
     */
    public double getFoodMultiplier() {
        return foodMultiplier;
    }
}

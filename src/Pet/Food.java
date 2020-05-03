package Pet;
/*
 * Food enum to keep track of the different types of food
 */

public enum Food {

    APPLE(0.2), GRAPES(0.4), MEAT(1), WATER(0.1), ANT(0.3), GRASS(0.2);
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

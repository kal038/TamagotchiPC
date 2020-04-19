/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Shrawak Lama
 * Section: 8 am
 * Date: 4/19/2020
 * Time: 6:29 PM
 *
 * Project: bixbyfinalproject
 * Package: Pet
 * Class: PetMain
 *
 * Description:
 *
 * ****************************************
 */
package
        Pet;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class PetMain {

    /**
     * stores the date when the pet was created
     */
    private Date dateCreated;

    /**
     * stores the date when the game is opened after creation
     */
    private Date curDate;

    /**
     * stores the date of when the pet was saved last
     */
    private Date savedDate;

    /**
     * Stores the name of the pet the user chooses
     */
    private String name;

    /**
     * Stores the age of the pet
     */
    private int age;

    /**
     * Stores the hunger meter for the pet, which tells the user how hungry the pet is
     */
    private int hunger;

    /**
     * Store the happiness meter for the pet, which tells the user how happy the pet is
     */
    private int happiness;

    /**
     * Stores the hygiene meter for the pet, which tells the user how clean the pet is
     */
    private int hygiene;

    /**
     * Stores the sleep meter for the pet, which tells the user how sleepy the pet is
     */
    private int sleep;

    /**
     * Stores the hunger meter for the pet, which tells the user how hungry the pet is
     */
    private double hungerRate;

    /**
     * Stores the happiness rate for the pet, which tells the program how fast the
     * happiness should decrease (between 0 - 0.99)
     */
    private double happinessRate;

    /**
     * Stores the hygiene rate for the pet, which tells the program how fast the
     * cleanliness should decrease (between 0 - 0.99)
     */
    private double hygieneRate;

    /**
     * Stores the sleepiness rate for the pet, which tells the program how fast
     * the sleepiness should decrease (between 0 - 0.99)
     */
    private double sleepinessRate;

    private final int MAX_STAT_VALUE = 100;
    private final double DEFAULT_RATE = 0.7;

    public PetMain(String name) {
        this.dateCreated = new Date();
        this.name = name;
        this.age = 0;
        this.hunger = MAX_STAT_VALUE;
        this.happiness = MAX_STAT_VALUE;
        this.hygiene = MAX_STAT_VALUE;
        this.sleep = MAX_STAT_VALUE;
        this.hungerRate = DEFAULT_RATE;
        this.happinessRate = DEFAULT_RATE;
        this.hygieneRate = DEFAULT_RATE;
        this.sleepinessRate = DEFAULT_RATE;
    }

    /**
     * increases the age of the pet by the number of days of the choice of the user
     *
     * @param days number of days the pet is to be aged
     */
    void updateAge(int days) {
        this.age += days;
    }

    /**
     * decrease the hunger rate by an amount specified
     *
     * @param decreaseBy amount to decrease hunger by
     */
    void decreaseHungerRate(double decreaseBy) {
        this.hungerRate -= decreaseBy;
    }

    /**
     * decrease happiness rate by an amount specified
     *
     * @param decreaseBy amount to decrease happiness by
     */
    void decreaseHappinessRate(double decreaseBy) {
        this.happinessRate -= decreaseBy;
    }

    /**
     * decrease hygiene rate by an amount specified
     *
     * @param decreaseBy amount to decrease hygiene by
     */
    void decreaseHygieneRate(double decreaseBy) {
        this.hygieneRate -= decreaseBy;
    }

    /**
     * decrease sleepiness rate by an amount specified
     *
     * @param decreaseBy amount to decrease sleepiness by
     */
    void decreaseSleepinessRate(double decreaseBy) {
        this.sleepinessRate -= decreaseBy;
    }

    /**
     * increase hunger rate by an amount specified
     *
     * @param increaseBy amount to increase hunger by
     */
    void increaseHungerRate(double increaseBy) {
        this.hungerRate += increaseBy;
    }

    /**
     * increase happiness rate by an amount specified
     *
     * @param increaseBy amount to increase happiness by
     */
    void increaseHappinessRate(double increaseBy) {
        this.happinessRate += increaseBy;
    }

    /**
     * increase hygiene rate by an amount specified
     *
     * @param increaseBy amount to increase hygiene rate by
     */
    void increaseHygieneRate(double increaseBy) {
        this.hygieneRate += increaseBy;
    }

    /**
     * increase sleepiness rate by an amount specified
     *
     * @param increaseBy amount to increase sleepiness by
     */
    void increaseSleepinessRate(double increaseBy) {
        this.sleepinessRate += increaseBy;
    }

    /**
     * saves the pets current state in a save file provided
     *
     * @param saveFile save file where all the pets attributes are stored
     */
    void saveState(File saveFile) {
        this.savedDate = new Date();
        //TODO = add other functionality to save other things such as happiness etc.
    }

    /**
     * reading attributes from the save file
     *
     * @param saveFile
     */
    void readAttributes(File saveFile) {
        //TODO - decide how to save stuff in the final
    }

    /**
     * helper function for saveState, which helps to write the attributes to the save file
     */
    void writeAttributes() {
        //TODO - same as readAttributes
    }

    public static void main(String[] args) {

    }
}


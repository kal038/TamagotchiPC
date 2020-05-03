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

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PetMain implements Serializable {


    /**
     * Store the image of the pet
     */
    private String petImage;

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
     * Stores the age of the pet (in days)
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
    private final double DEFAULT_RATE = 0.03;

    public PetMain(String name) {
        this.dateCreated = new Date();
        this.name = name;
        this.age = 1; // start value is 1 day
        this.hunger = MAX_STAT_VALUE;
        this.happiness = MAX_STAT_VALUE;
        this.hygiene = MAX_STAT_VALUE;
        this.sleep = MAX_STAT_VALUE;
        this.hungerRate = DEFAULT_RATE;
        this.happinessRate = DEFAULT_RATE;
        this.hygieneRate = DEFAULT_RATE;
        this.sleepinessRate = DEFAULT_RATE;
        PetAgeThread petThread = new PetAgeThread(this, this.dateCreated);
        Thread timethrd = new Thread(petThread);
        timethrd.start();

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public Date getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(Date savedDate) {
        this.savedDate = savedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public double getHungerRate() {
        return hungerRate;
    }

    public void setHungerRate(double hungerRate) {
        this.hungerRate = hungerRate;
    }

    public double getHappinessRate() {
        return happinessRate;
    }

    public void setHappinessRate(double happinessRate) {
        this.happinessRate = happinessRate;
    }

    public double getHygieneRate() {
        return hygieneRate;
    }

    public void setHygieneRate(double hygieneRate) {
        this.hygieneRate = hygieneRate;
    }

    public double getSleepinessRate() {
        return sleepinessRate;
    }

    public void setSleepinessRate(double sleepinessRate) {
        this.sleepinessRate = sleepinessRate;
    }

    public void setPetImage(String petImage) { this.petImage = petImage; }

    public String getPetImage() { return petImage; }


    /**
     * @param hungerIncrease hunger increase when being fed well
     */
    public void increaseHunger(double hungerIncrease) throws Exception {
        if (this.hunger + hungerIncrease <= MAX_STAT_VALUE) {
            this.hunger += hungerIncrease;
        } else {
            this.hunger = MAX_STAT_VALUE;
            throw new Exception("Statistic can not be greater than MAX value");
        }
    }

    /**
     * method to increase the actual sleep statistic when you put the pet to bed for a period of time
     * @param sleepIncrease
     * @throws Exception
     */
    public void increaseSleep(double sleepIncrease) throws Exception {
        if (this.sleep + sleepIncrease <= MAX_STAT_VALUE) {
            this.sleep += sleepIncrease;
        } else {
            this.sleep = MAX_STAT_VALUE;
            throw new Exception("Statistic can not be greater than MAX value");
        }
    }

    /**
     * method to increase the actual Happiness statistic of the pet when you pet or walk the pet
     * @param happinessIncrease
     * @throws Exception
     */
    public void increaseHappiness (double happinessIncrease) throws Exception {
        if (this.happiness + happinessIncrease <= MAX_STAT_VALUE) {
            this.happiness += happinessIncrease;
        } else {
            this.happiness = MAX_STAT_VALUE;
            throw new Exception("Statistic can not be greater than MAX value");
        }
    }

    private final int MAX_INCREASE = 10;

    public void decreaseHappiness (int decrease) throws Exception {
        if (this.happiness - decrease >= 0) {
            this.happiness -= decrease;
        }  else {
            throw new Exception("Statistic can not decrease below 0");
        }
    }

    public void decreaseHunger (int decrease) throws Exception {
        if (this.hunger - decrease >= 0) {
            this.hunger -= decrease;
        }  else {
            throw new Exception("Statistic can not decrease below 0");
        }
    }

    public void decreaseHygiene (int decrease) throws Exception {
        if (this.hygiene - decrease >= 0) {
            this.hygiene -= decrease;
        }  else {
            throw new Exception("Statistic can not decrease below 0");
        }
    }

    public void decreaseSleep (int decrease) throws Exception {
        if (this.sleep - decrease >= 0) {
            this.sleep -= decrease;
        }  else {
            throw new Exception("Statistic can not decrease below 0");
        }
    }

    /**
     * method that actually interacts with the GUI and main game's Pet instance, and feeds the pet
     * according to the amount of food (quantity) and the type of food (foodType)
     * @param foodType Enum of Food that has different foods with different multiplier values
     * @param quantity quantity of the Food that we are providing the pet
     */
    public void feedPet(Food foodType, int quantity) throws Exception {

        this.increaseHunger(foodType.getFoodMultiplier() * quantity);
    }

    /**
     * method that actually interacts with the GUI and main game's Pet instance, and makes the pet
     * happier according to the walk
     * @param walkTime Time that the pet is taken for a walk (can be max 10 minutes)
     */
    public void walkPet(double walkTime) throws Exception {

        if (walkTime <= MAX_INCREASE) {
            this.increaseHappiness(this.getHappinessRate() * walkTime);
        }
    }

    /**
     * method that actually interacts with the GUI and main game's Pet instance, and increases
     * the pets sleep status by putting the pet to sleep for an input amount of minutes
     * @param sleepTime Time that the pet is allowed to sleep (can be max 10 minutes)
     */
    public void sleepPet(double sleepTime) throws Exception {

        if (sleepTime <= MAX_INCREASE) {
            this.increaseSleep(this.getSleepinessRate() * sleepTime);
        }
    }

    /**
     * method that actually interacts with the GUI and main game's Pet instance, and increases
     *  the pets happiness status by petting it a number of times (max is 10)
     * @param numberOfPets the number of times the user pets the pet
     */
    public void petPet(double numberOfPets) throws Exception {

        if (numberOfPets <= MAX_INCREASE) {
            this.increaseHappiness(this.getHappinessRate() * numberOfPets);
        }
    }

    /**
     * saves the pets current state in a save file provided
     *
     */
    void saveState() {
        this.savedDate = new Date();
        try {
            FileOutputStream f = new FileOutputStream(new File("saveFile.txt") );
            ObjectOutputStream o = new ObjectOutputStream(f);

            Date newSaveDate = new Date();
            this.setSavedDate(newSaveDate);

            o.writeObject(this);

            o.close();
            f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException i) {
            System.out.println("Error initializing");
        }

    }

    /**
     * reading attributes from the save file
     *
     */
    void readAttributes() {
        try {
            FileInputStream fi = new FileInputStream(new File("saveFile.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            PetMain savedPet = (PetMain) oi.readObject();
            this.setDateCreated(savedPet.getDateCreated());
            this.setName(savedPet.getName());
            this.setAge(savedPet.getAge());
            this.setHunger(savedPet.getHunger());
            this.setHappiness(savedPet.getHappiness());
            this.setHygiene(savedPet.getHygiene());
            this.setSleep(savedPet.getSleep());
            this.setHungerRate(savedPet.getHungerRate());
            this.setHappinessRate(savedPet.getHappinessRate());
            this.setHygieneRate(savedPet.getHygieneRate());
            this.setSleepinessRate(savedPet.getSleepinessRate());
            this.setSavedDate(savedPet.getSavedDate());

            oi.close();
            fi.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        catch (IOException i) {
            System.out.println("Error initializing");
        }

        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

}

/**
 * Helper class that runs a thread to check the age of the pet and change the image of the pet accordingly
 */
class PetAgeThread implements Runnable {

    /**
     * Birth date of the pet
     */
    private Date startDate;

    /**
     * Pet object being tested
     */
    private PetMain pet;


    public PetAgeThread(PetMain pet, Date startDate) {
        this.pet = pet;
        this.startDate = startDate;
    }

    @Override
    public void run() {
//        long diff = 0;
        while (true) {
//            Date compareDate = new Date();
//            long diffInMillies = Math.abs(this.startDate.getTime() - compareDate.getTime());
//            diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (this.pet.getAge() < 20) {
                //System.out.println("image set");
                pet.setPetImage("bixby_pet.gif");
            } else
             {
                pet.setPetImage("bixby_pet2.gif");
            }
        }
    }

}
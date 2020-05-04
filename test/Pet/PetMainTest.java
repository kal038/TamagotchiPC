package Pet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetMainTest {

    /**
     * Initialize a PetMain object
     */
    private PetMain pet;

    @BeforeEach
    void setUp() {
        this.pet = new PetMain("Bixby");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void increaseHunger() throws Exception {
        // Assert that the pet starts at a full bar of 100 hunger
        assertEquals(100, pet.getHunger());

        // Set the hunger to 75 so that we can check the increaseHunger function
        this.pet.setHunger(75);

        // Hunger increased 5 from 75 so assert that hunger should now be 80
        pet.increaseHunger(5);
        assertEquals(80, pet.getHunger());
    }

    @Test
    void increaseSleep() throws Exception {
        // Assert that the pet starts at a full bar of 100 sleep
        assertEquals(100, pet.getSleep());

        // Set the sleep to 75 so that we can check the increaseSleep function
        this.pet.setSleep(75);

        // Sleep increased 5 from 75 so assert that sleep should now be 80
        pet.increaseSleep(5);
        assertEquals(80, pet.getSleep());
    }

    @Test
    void increaseHappiness() throws Exception {
        // Assert that the pet starts at a full bar of 100 happiness
        assertEquals(100, pet.getHappiness());

        // Set the happiness to 75 so that we can check the increaseHappiness function
        this.pet.setHappiness(75);

        // Sleep increased 5 from 75 so assert that happiness should now be 80
        pet.increaseHappiness(5);
        assertEquals(80, pet.getHappiness());
    }

    @Test
    void decreaseHappiness() throws Exception {
        // Assert that the pet starts at a full bar of 100 happiness
        assertEquals(100, pet.getHappiness());

        // Happiness decreased by 10 so assert that happiness should now be 90
        this.pet.decreaseHappiness(10);
        assertEquals(90, pet.getHappiness());
    }

    @Test
    void decreaseHunger() throws Exception {
        // Assert that the pet starts at a full bar of 100 hunger
        assertEquals(100, pet.getHunger());

        // Hunger decreased by 10 so assert that hunger should now be 90
        this.pet.decreaseHunger(10);
        assertEquals(90, pet.getHunger());
    }

    @Test
    void decreaseHygiene() throws Exception {
        // Assert that the pet starts at a full bar of 100 hygiene
        assertEquals(100, pet.getHygiene());

        // Hygiene decreased by 10 so assert that hygiene should now be 90
        this.pet.decreaseHygiene(10);
        assertEquals(90, pet.getHygiene());
    }

    @Test
    void decreaseSleep() throws Exception {
        // Assert that the pet starts at a full bar of 100 sleep
        assertEquals(100, pet.getSleep());

        // Sleep decreased by 10 so assert that sleep should now be 90
        this.pet.decreaseSleep(10);
        assertEquals(90, pet.getSleep());
    }

    @Test
    void saveState() {
        // Assert that the initialized pet's name is Bixby and give it unique states and save the state of that pet
        assertEquals("Bixby", pet.getName());
        pet.setHappiness(90);
        pet.setSleep(75);
        pet.saveState();

        // Create a new pet and assert that its name is Dancy
        PetMain newPet = new PetMain("Dancy");
        assertEquals("Dancy", newPet.getName());
        assertEquals(100, newPet.getHappiness());
        assertEquals(100, newPet.getSleep());

        // Read the saved attributes to the new pet object and assert that the new pet is now named Bixby and has loaded in all the same attributes from the old pet
        newPet.readAttributes();
        assertEquals("Bixby", newPet.getName());
        assertEquals(90, newPet.getHappiness());
        assertEquals(75, newPet.getSleep());

    }
}
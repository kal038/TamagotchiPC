/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 4/22/20
 * Time: 8:54 PM
 *
 * Project: BixbyFinalProject
 * Package: Pet
 * Class: Game
 *
 * Description:
 *
 * ****************************************
 */
package
        Pet;

import java.util.Calendar;
import java.util.Date;

public class Game {
    /*
     * This class simulates an instance of a Game
     */
    PetMain myPet ;
    Date startDate ;
    Date currDate;

    public Game(PetMain myPet) {
        this.myPet = myPet;
        this.startDate = new Date(); // this marks when the Game instance was first created
        this.currDate = new Date(); // this keeps tracks of the current Date
    }

    public void initPet(String petName) {
        this.myPet = new PetMain(petName);
    }

    public void advanceGameTime(int days) {
        this.myPet.updateAge(days);
        this.currDate = TimeUtil.skipAheadDays(days, this.currDate);
    }

}
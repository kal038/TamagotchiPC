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
    private PetMain myPet ;
    private Date startDate ;
    private Date currDate;
    private int dateCount ;
    private int status;
    private static int OFFLINE = 0;
    private static int ONLINE = 1;

    public Game(PetMain myPet) {
        this.myPet = myPet;
        this.startDate = new Date(); // this marks when the Game instance was first created
        this.currDate = new Date(); // this keeps tracks of the current Date
        this.dateCount = 1;
        this.status = ONLINE;
    }


    /**
     * Advance the current date by "days" number of days
     * @param days
     */
    public void advanceGameTime(int days) {
        // pet age is always in days
        this.myPet.updateAge(days);
        this.currDate = TimeUtil.skipAheadDays(days, this.currDate);
    }

    public PetMain getMyPet() {
        return myPet;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public int getDateCount() {
        return dateCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
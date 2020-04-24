/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 4/24/20
 * Time: 3:01 PM
 *
 * Project: BixbyFinalProject
 * Package: Pet
 * Class: TimeUtil
 *
 * Description:
 *
 * ****************************************
 */
package
        Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Util class to keep track of the current time of the game instance
 * Shows the correlation between actual time and the age of the Pet
 */
public final class TimeUtil {
    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");

    /**
     * Helper method to parse a date string into a date object. This is
     * really here just to show how to deal with an exception that may
     * be thrown in a method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    static Date strToDate(String sDate) throws ParseException {
        return dateFormatter.parse(sDate);
    }

    /**
     * Helper method to turn date object to their string representations
     * @param dDate
     * @return
     */
    static String dateToString(Date dDate) {
        return dateFormatter.format(dDate);
    }

    static Date skipAheadDays (int days, Date currDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(currDate);
        c.add(Calendar.DATE, days);
        return c.getTime();
        }

    }
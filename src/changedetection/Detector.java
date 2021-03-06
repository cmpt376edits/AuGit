package changedetection;

import java.util.ArrayList;

// TODO (rmartin) add some comments

public interface Detector {

    /**
     * This function takes the origin (last commited code), and current code and finds the newly defined or deleted
     * functions between the two and sets the detectors function list to a list of function description objects.
     *
     * @param origin
     * @param current
     */
    void detectFunctions(String origin, String current);

    /**
     * This function takes the origin (last commited code), and current code and finds the newly defined or deleted
     * classes between the two and sets the detectors class list to a list of class description objects.
     *
     * @param origin
     * @param current
     */
    void detectClasses(String origin, String current);

    /**
     * Gets a message to explain the added functions.
     *
     * @return the message
     */
    String getMessageFunctions();

    /**
     * Gets a message to explain the added classes.
     *
     * @return the message
     */
    String getMessageClasses();
}

/**
 * Enhanced interface for the VehicleMaintenanceTracker component.
 *
 * @author Amrit Mareddy
 */
public interface VehicleMaintenanceTracker
        extends VehicleMaintenanceTrackerKernel {

    /**
     * Reports whether a service exists in this tracker.
     *
     * @param service
     *            the service to search for
     * @return true if a record with the given service exists
     * @ensures hasService = (there exists a record in this with the given
     *          service)
     */
    boolean hasService(String service);

    /**
     * Reports the most recently added service.
     *
     * @return the most recent service
     * @requires this /= empty_set
     * @ensures mostRecentService = the service of the most recently added
     *          record
     */
    String mostRecentService();

    /**
     * Reports the mileage of the most recently added service.
     *
     * @return the mileage of the most recent service
     * @requires this /= empty_set
     * @ensures lastServiceMileage = the mileage of the most recently added
     *          record
     */
    int lastServiceMileage();

    /**
     * Removes all records from this tracker.
     *
     * @clears this
     * @ensures this = empty_set
     */
    void clearRecords();
}
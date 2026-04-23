package components.naturalnumber;

import components.standard.Standard;

/**
 * Kernel interface for the VehicleMaintenanceTracker component.
 *
 * @author Amrit Mareddy
 */
public interface VehicleMaintenanceTrackerKernel
        extends Standard<VehicleMaintenanceTracker> {

    /**
     * Adds a maintenance record to this tracker.
     *
     * @param service
     *            the service performed
     * @param mileage
     *            the mileage at which the service occurred
     * @param date
     *            the date of the service
     * @updates this
     * @requires mileage >= 0
     * @ensures this = #this with a new record (service, mileage, date) added
     */
    void addRecord(String service, int mileage, String date);

    /**
     * Removes and returns the most recently added maintenance record.
     *
     * @return the removed record
     * @updates this
     * @requires this /= empty_set
     * @ensures this = #this without its most recently added record
     */
    String removeRecord();

    /**
     * Reports the number of maintenance records stored.
     *
     * @return the number of records
     * @ensures size = |this|
     */
    int size();

    /**
     * Returns the maintenance record at the given position.
     *
     * @param index
     *            the position of the record
     * @return the record at the given index
     * @requires 0 <= index < |this|
     * @ensures recordAt = record at position index in this
     */
    String recordAt(int index);
}
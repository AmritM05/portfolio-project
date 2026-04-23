package components.naturalnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Kernel implementation for the VehicleMaintenanceTracker component.
 *
 * Convention: rep is not null, and every entry in rep is a record string in the
 * form "date | mileage mi | service".
 *
 * Correspondence: this = the sequence of maintenance records stored in rep, in
 * the same order as they appear in rep.
 *
 * @author Amrit Mareddy
 */
public class VehicleMaintenanceTracker1L
        extends VehicleMaintenanceTrackerSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of this tracker.
     */
    private List<String> rep;

    /**
     * Creates a new empty representation.
     */
    private void createNewRep() {
        this.rep = new ArrayList<>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public VehicleMaintenanceTracker1L() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final VehicleMaintenanceTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(VehicleMaintenanceTracker source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof VehicleMaintenanceTracker1L : ""
                + "Violation of: source is of dynamic type "
                + "VehicleMaintenanceTracker1L";

        VehicleMaintenanceTracker1L localSource = (VehicleMaintenanceTracker1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void addRecord(String service, int mileage, String date) {
        assert service != null : "Violation of: service is not null";
        assert date != null : "Violation of: date is not null";
        assert mileage >= 0 : "Violation of: mileage >= 0";

        String record = date + " | " + mileage + " mi | " + service;
        this.rep.add(record);
    }

    @Override
    public final String removeRecord() {
        assert this.rep.size() > 0 : "Violation of: this /= empty_set";

        return this.rep.remove(this.rep.size() - 1);
    }

    @Override
    public final int size() {
        return this.rep.size();
    }

    @Override
    public final String recordAt(int index) {
        assert index >= 0 : "Violation of: 0 <= index";
        assert index < this.rep.size() : "Violation of: index < |this|";

        return this.rep.get(index);
    }
}
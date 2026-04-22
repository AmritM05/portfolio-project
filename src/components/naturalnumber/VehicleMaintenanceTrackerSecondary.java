package components.naturalnumber;

/**
 * Secondary methods for the VehicleMaintenanceTracker component.
 *
 * @author Amrit Mareddy
 */
public abstract class VehicleMaintenanceTrackerSecondary
        implements VehicleMaintenanceTracker {

    /**
     * Returns the service portion of a record string.
     *
     * @param record
     *            the full record string
     * @return the service name
     */
    private static String getService(String record) {
        int lastBar = record.lastIndexOf("|");
        return record.substring(lastBar + 2);
    }

    /**
     * Returns the mileage portion of a record string.
     *
     * @param record
     *            the full record string
     * @return the mileage
     */
    private static int getMileage(String record) {
        int firstBar = record.indexOf("|");
        int miIndex = record.indexOf(" mi");
        String number = record.substring(firstBar + 2, miIndex);
        return Integer.parseInt(number);
    }

    @Override
    public boolean hasService(String service) {
        assert service != null : "Violation of: service is not null";

        boolean found = false;
        int i = 0;

        while (i < this.size() && !found) {
            String record = this.recordAt(i);
            if (getService(record).equalsIgnoreCase(service)) {
                found = true;
            }
            i++;
        }

        return found;
    }

    @Override
    public String mostRecentService() {
        assert this.size() > 0 : "Violation of: this /= empty_set";

        String record = this.recordAt(this.size() - 1);
        return getService(record);
    }

    @Override
    public int lastServiceMileage() {
        assert this.size() > 0 : "Violation of: this /= empty_set";

        String record = this.recordAt(this.size() - 1);
        return getMileage(record);
    }

    @Override
    public void clearRecords() {
        this.clear();
    }

    @Override
    public String toString() {
        String result = "[";
        int i = 0;

        while (i < this.size()) {
            if (i > 0) {
                result += ", ";
            }
            result += this.recordAt(i);
            i++;
        }

        result += "]";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;

        if (obj instanceof VehicleMaintenanceTracker) {
            VehicleMaintenanceTracker other = (VehicleMaintenanceTracker) obj;

            if (this.size() == other.size()) {
                isEqual = true;
                int i = 0;

                while (i < this.size() && isEqual) {
                    if (!this.recordAt(i).equals(other.recordAt(i))) {
                        isEqual = false;
                    }
                    i++;
                }
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit tests for secondary methods of VehicleMaintenanceTracker.
 *
 * @author Amrit Mareddy
 */
public final class VehicleMaintenanceTrackerTest {

    /**
     * Returns a tracker containing the given records.
     *
     * @return tracker with sample records
     */
    private VehicleMaintenanceTracker createSampleTracker() {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();
        t.addRecord("Oil Change", 10000, "Jan 2026");
        t.addRecord("Tire Rotation", 12000, "Feb 2026");
        t.addRecord("Oil Change", 16000, "Apr 2026");
        return t;
    }

    @Test
    public void testHasServiceTrue() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = this.createSampleTracker();

        assertEquals(true, t.hasService("Oil Change"));
        assertEquals(expected, t);
    }

    @Test
    public void testHasServiceFalse() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = this.createSampleTracker();

        assertEquals(false, t.hasService("Brake Inspection"));
        assertEquals(expected, t);
    }

    @Test
    public void testMostRecentService() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = this.createSampleTracker();

        assertEquals("Oil Change", t.mostRecentService());
        assertEquals(expected, t);
    }

    @Test
    public void testLastServiceMileage() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = this.createSampleTracker();

        assertEquals(16000, t.lastServiceMileage());
        assertEquals(expected, t);
    }

    @Test
    public void testClearRecords() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = new VehicleMaintenanceTracker1L();

        t.clearRecords();

        assertEquals(expected, t);
    }

    @Test
    public void testToStringEmpty() {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();

        assertEquals("[]", t.toString());
    }

    @Test
    public void testToStringNonEmpty() {
        VehicleMaintenanceTracker t = this.createSampleTracker();

        assertEquals("[Jan 2026 | 10000 mi | Oil Change, "
                + "Feb 2026 | 12000 mi | Tire Rotation, "
                + "Apr 2026 | 16000 mi | Oil Change]", t.toString());
    }

    @Test
    public void testEqualsSameValue() {
        VehicleMaintenanceTracker t1 = this.createSampleTracker();
        VehicleMaintenanceTracker t2 = this.createSampleTracker();

        assertEquals(true, t1.equals(t2));
    }

    @Test
    public void testEqualsDifferentValue() {
        VehicleMaintenanceTracker t1 = this.createSampleTracker();
        VehicleMaintenanceTracker t2 = new VehicleMaintenanceTracker1L();

        t2.addRecord("Oil Change", 10000, "Jan 2026");
        t2.addRecord("Tire Rotation", 12000, "Feb 2026");

        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void testHashCodeSameValue() {
        VehicleMaintenanceTracker t1 = this.createSampleTracker();
        VehicleMaintenanceTracker t2 = this.createSampleTracker();

        assertEquals(t1.hashCode(), t2.hashCode());
    }
}
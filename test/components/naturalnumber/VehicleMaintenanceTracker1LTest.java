import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit tests for kernel and Standard methods of VehicleMaintenanceTracker1L.
 *
 * @author Amrit Mareddy
 */
public final class VehicleMaintenanceTracker1LTest {

    /**
     * Returns a constructor reference.
     *
     * @return a new empty tracker
     */
    private VehicleMaintenanceTracker constructorTest() {
        return new VehicleMaintenanceTracker1L();
    }

    /**
     * Returns a tracker containing the given records.
     *
     * @return tracker with sample records
     */
    private VehicleMaintenanceTracker createSampleTracker() {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();
        t.addRecord("Oil Change", 10000, "Jan 2026");
        t.addRecord("Tire Rotation", 12000, "Feb 2026");
        t.addRecord("Brake Inspection", 15000, "Mar 2026");
        return t;
    }

    @Test
    public void testConstructor() {
        VehicleMaintenanceTracker t = this.constructorTest();
        VehicleMaintenanceTracker expected = new VehicleMaintenanceTracker1L();

        assertEquals(expected, t);
    }

    @Test
    public void testAddRecordEmpty() {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();
        VehicleMaintenanceTracker expected = new VehicleMaintenanceTracker1L();

        t.addRecord("Oil Change", 10000, "Jan 2026");
        expected.addRecord("Oil Change", 10000, "Jan 2026");

        assertEquals(expected, t);
    }

    @Test
    public void testAddRecordNonEmpty() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = this.createSampleTracker();

        t.addRecord("Battery Check", 18000, "Apr 2026");
        expected.addRecord("Battery Check", 18000, "Apr 2026");

        assertEquals(expected, t);
    }

    @Test
    public void testRemoveRecord() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = new VehicleMaintenanceTracker1L();
        String removed;

        expected.addRecord("Oil Change", 10000, "Jan 2026");
        expected.addRecord("Tire Rotation", 12000, "Feb 2026");

        removed = t.removeRecord();

        assertEquals("Mar 2026 | 15000 mi | Brake Inspection", removed);
        assertEquals(expected, t);
    }

    @Test
    public void testSizeEmpty() {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();

        assertEquals(0, t.size());
    }

    @Test
    public void testSizeNonEmpty() {
        VehicleMaintenanceTracker t = this.createSampleTracker();

        assertEquals(3, t.size());
    }

    @Test
    public void testRecordAtFirst() {
        VehicleMaintenanceTracker t = this.createSampleTracker();

        assertEquals("Jan 2026 | 10000 mi | Oil Change", t.recordAt(0));
        assertEquals(3, t.size());
    }

    @Test
    public void testRecordAtMiddle() {
        VehicleMaintenanceTracker t = this.createSampleTracker();

        assertEquals("Feb 2026 | 12000 mi | Tire Rotation", t.recordAt(1));
        assertEquals(3, t.size());
    }

    @Test
    public void testRecordAtLast() {
        VehicleMaintenanceTracker t = this.createSampleTracker();

        assertEquals("Mar 2026 | 15000 mi | Brake Inspection", t.recordAt(2));
        assertEquals(3, t.size());
    }

    @Test
    public void testNewInstance() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker newT = t.newInstance();
        VehicleMaintenanceTracker expected = new VehicleMaintenanceTracker1L();

        assertEquals(expected, newT);
    }

    @Test
    public void testClear() {
        VehicleMaintenanceTracker t = this.createSampleTracker();
        VehicleMaintenanceTracker expected = new VehicleMaintenanceTracker1L();

        t.clear();

        assertEquals(expected, t);
    }

    @Test
    public void testTransferFrom() {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();
        VehicleMaintenanceTracker source = this.createSampleTracker();
        VehicleMaintenanceTracker expectedTarget = this.createSampleTracker();
        VehicleMaintenanceTracker expectedSource = new VehicleMaintenanceTracker1L();

        t.transferFrom(source);

        assertEquals(expectedTarget, t);
        assertEquals(expectedSource, source);
    }
}
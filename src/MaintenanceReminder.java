import components.naturalnumber.VehicleMaintenanceTracker;
import components.naturalnumber.VehicleMaintenanceTracker1L;

public class MaintenanceReminder {
    public static void main(String[] args) {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();

        t.addRecord("Oil Change", 10000, "Jan 2026");

        if (t.lastServiceMileage() > 9000) {
            System.out.println("Time for another oil change soon.");
        }
    }
}
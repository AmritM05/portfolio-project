import components.naturalnumber.VehicleMaintenanceTracker;
import components.naturalnumber.VehicleMaintenanceTracker1L;

public class CarHistoryApp {
    public static void main(String[] args) {
        VehicleMaintenanceTracker t = new VehicleMaintenanceTracker1L();

        t.addRecord("Oil Change", 10000, "Jan 2026");
        t.addRecord("Tire Rotation", 12000, "Feb 2026");

        System.out.println("Maintenance History:");
        System.out.println(t);
    }
}
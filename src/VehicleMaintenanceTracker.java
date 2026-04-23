import java.util.ArrayList;
import java.util.List;

public final class VehicleMaintenanceTracker {
    private static class Record {
        private String service;
        private int mileage;
        private String date;

        Record(String service, int mileage, String date) {
            this.service = service;
            this.mileage = mileage;
            this.date = date;
        }

        @Override
        public String toString() {
            return this.date + " | " + this.mileage + " mi | " + this.service;
        }
    }

    private List<Record> records;

    public VehicleMaintenanceTracker() {
        this.records = new ArrayList<>();
    }

    public void addRecord(String service, int mileage, String date) {
        this.records.add(new Record(service, mileage, date));
    }

    public void removeRecord() {
        if (!this.records.isEmpty()) {
            this.records.remove(this.records.size() - 1);
        }
    }

    public int size() {
        return this.records.size();
    }

    public String recordAt(int index) {
        if (index < 0 || index >= this.records.size()) {
            return "Invalid index";
        }
        return this.records.get(index).toString();
    }

    public boolean hasService(String service) {
        for (Record r : this.records) {
            if (r.service.equalsIgnoreCase(service)) {
                return true;
            }
        }
        return false;
    }

    public String mostRecentService() {
        if (this.records.isEmpty()) {
            return "None";
        }
        return this.records.get(this.records.size() - 1).service;
    }

    public int lastServiceMileage() {
        if (this.records.isEmpty()) {
            return -1;
        }
        return this.records.get(this.records.size() - 1).mileage;
    }

    public void clearRecords() {
        this.records.clear();
    }

    public static void main(String[] args) {
        VehicleMaintenanceTracker tracker = new VehicleMaintenanceTracker();

        System.out.println("Vehicle Maintenance Tracker Demo");

        tracker.addRecord("Oil Change", 12000, "Aug 2025");
        tracker.addRecord("Tire Rotation", 15000, "Oct 2025");
        tracker.addRecord("Oil Change", 17000, "Jan 2026");

        System.out.println("Total records: " + tracker.size());
        System.out
                .println("Most recent service: " + tracker.mostRecentService());
        System.out.println("Last mileage: " + tracker.lastServiceMileage());
        System.out.println();

        System.out.println("All records:");
        for (int i = 0; i < tracker.size(); i++) {
            System.out.println(tracker.recordAt(i));
        }

        System.out.println();
        System.out
                .println("Has oil change? " + tracker.hasService("Oil Change"));
        tracker.removeRecord();
        System.out
                .println("After removing last record, size: " + tracker.size());
    }
}
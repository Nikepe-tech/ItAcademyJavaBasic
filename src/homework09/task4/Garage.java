package homework09.task4;

public class Garage<T extends Vehicle> {
    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleName() {
        return vehicle.getName();
    }
}

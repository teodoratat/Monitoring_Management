
public class DeviceData {
    private long timestamp;
    private String device_id;
    private double measurement_value;

    public DeviceData(long timestamp, String device_id, double measurement_value) {
        this.timestamp = timestamp;
        this.device_id = device_id;
        this.measurement_value = measurement_value;
    }
}
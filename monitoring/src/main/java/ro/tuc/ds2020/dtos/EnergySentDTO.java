package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.entities.Device;

import java.util.Date;
import java.util.UUID;

public class EnergySentDTO {

    private int id;
    private Date date;
    private double value;
    // replace deviceId with Device

    private UUID deviceId; // Assuming you want to include the device ID in the DTO
    private Device device;

    public EnergySentDTO(int id, Date date, double value, Device device) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.device = device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public EnergySentDTO() {
    }

    public EnergySentDTO(int id, Date date, double value, UUID deviceId) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.deviceId = deviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public Device getDevice() {
        return device;
    }
}

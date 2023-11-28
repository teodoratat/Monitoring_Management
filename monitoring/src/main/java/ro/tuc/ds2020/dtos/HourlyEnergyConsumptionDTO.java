package ro.tuc.ds2020.dtos;

import java.util.Date;
import java.util.UUID;

public class HourlyEnergyConsumptionDTO {

    private int id;
    private double totalConsumption;
    private UUID deviceId; // Assuming you want to include the device ID in the DTO
    private Date date;

    public HourlyEnergyConsumptionDTO() {
    }

    public HourlyEnergyConsumptionDTO(int id, double totalConsumption, UUID deviceId, Date date) {
        this.id = id;
        this.totalConsumption = totalConsumption;
        this.deviceId = deviceId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

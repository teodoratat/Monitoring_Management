package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.EnergySentRepository;
import ro.tuc.ds2020.repositories.HourlyEnergyConsumptionRepository;

@Service
public class MeasurementService {
    private final DeviceRepository deviceRepository;
    private final EnergySentRepository energySentRepository;
    private final HourlyEnergyConsumptionRepository hourlyEnergyConsumptionRepository;
    @Autowired
    public MeasurementService(DeviceRepository deviceRepository, EnergySentRepository energySentRepository, HourlyEnergyConsumptionRepository hourlyEnergyConsumptionRepository) {
        this.deviceRepository = deviceRepository;
        this.energySentRepository = energySentRepository;
        this.hourlyEnergyConsumptionRepository = hourlyEnergyConsumptionRepository;
    }



}

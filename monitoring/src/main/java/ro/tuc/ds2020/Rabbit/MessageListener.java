package ro.tuc.ds2020.Rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.EnergySent;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.EnergySentRepository;

import java.util.Date;
import java.util.UUID;

@Component
public class MessageListener {

    private final EnergySentRepository energySentService;
    private final DeviceRepository deviceRepository;
    @Autowired
    public MessageListener(EnergySentRepository energySentService, DeviceRepository deviceRepository) {
        this.energySentService = energySentService;
        this.deviceRepository = deviceRepository;
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(CustomMessage message) {
        System.out.println("Received message: " + message);

        // Extract relevant information from the message and create an EnergySent object
        UUID deviceId = UUID.fromString(message.getDevice_id()); // Assuming device_id is a string representation of UUID
        System.out.println("Device id: " + deviceId
        );
        double measurementValue = message.getMeasurement_value();
        Date timestamp = new Date(message.getTimestamp()); // Adjust based on your message format

        Device device = deviceRepository.findById(deviceId).orElse(null);
        System.out.println("Device: " + device);
        EnergySent energySent = new EnergySent();
        energySent.setDate(timestamp);
        energySent.setValue(measurementValue);
        energySent.setDevice(device);

        // Save the EnergySent object using the service
        energySentService.save(energySent);
    }
}

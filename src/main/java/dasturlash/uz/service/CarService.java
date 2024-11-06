package dasturlash.uz.service;

import dasturlash.uz.dto.CarDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private List<CarDTO> carList = new LinkedList<>();

    public CarService() {
        CarDTO car1 = new CarDTO();
        car1.setId(UUID.randomUUID().toString());
        car1.setName("Nexia");
        car1.setModel("Nexia 3");
        car1.setYear(2020);
        carList.add(car1);

        CarDTO car2 = new CarDTO();
        car2.setId(UUID.randomUUID().toString());
        car2.setName("Cobalt");
        car2.setModel("LTZ");
        car2.setYear(2024);
        carList.add(car2);

        CarDTO car3 = new CarDTO();
        car3.setId(UUID.randomUUID().toString());
        car3.setName("Damas");
        car3.setModel("Damas 2");
        car3.setYear(2018);
        carList.add(car3);
    }

    public List<CarDTO> getAll() {
        return carList;
    }

    public CarDTO getById(String id) {
        for (CarDTO car : carList) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public CarDTO create(CarDTO car) {
        car.setId(UUID.randomUUID().toString());
        carList.add(car);
        return car;
    }

    public boolean update(String id, CarDTO car) {
        for (CarDTO dto : carList) {
            if (dto.getId().equals(id)) {
                dto.setName(car.getName());
                dto.setModel(car.getModel());
                dto.setYear(car.getYear());
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        return carList.removeIf(car -> car.getId().equals(id));
    }
}

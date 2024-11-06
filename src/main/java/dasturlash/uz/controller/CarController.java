package dasturlash.uz.controller;

import dasturlash.uz.dto.CarDTO;
import dasturlash.uz.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getAll")
    public List<CarDTO> getCarList() {
        return carService.getAll();
    }

    @GetMapping("/byId/{id}")
    public CarDTO getCarById(@PathVariable("id") String id) {
        return carService.getById(id);
    }

    @PostMapping("/create")
    public CarDTO createCar(@Valid @RequestBody CarDTO car) {
        return carService.create(car);
    }

    @PutMapping("/update/{id}")
    public boolean updateCar(@Valid @PathVariable("id") String id,
                             @RequestBody CarDTO car) {
        return carService.update(id,car);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCar(@PathVariable("id") String id) {
        return carService.delete(id);
    }


}

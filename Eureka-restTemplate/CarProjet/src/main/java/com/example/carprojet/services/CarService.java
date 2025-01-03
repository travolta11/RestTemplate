package com.example.carprojet.services;

import com.example.carprojet.entities.Car;
import com.example.carprojet.entities.Client;
import com.example.carprojet.models.CarResponse;
import com.example.carprojet.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8888/SERVICE-CLIENT";

    public List<CarResponse> findAll() {
        List<Car> cars = carRepository.findAll();
        ResponseEntity<Client[]> response = restTemplate.getForEntity(this.URL + "/api/client", Client[].class);
        Client[] clients = response.getBody();
        return cars.stream().map(car -> mapToCarResponse(car, clients)).toList();
    }

    // This function converts a Car entity to a CarResponse model
    private CarResponse mapToCarResponse(Car car, Client[] clients) {
        Client foundClient = Arrays.stream(clients)
                .filter(client -> client.getId().equals(car.getClient_id()))
                .findFirst()
                .orElse(null);

        return new CarResponse.Builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .matricue(car.getMatricule())
                .client(foundClient)
                .build();
    }

    public CarResponse findById(Long id) throws Exception {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new Exception("Invalid Car Id"));

        Client client = restTemplate.getForObject(this.URL + "/api/client/" + car.getClient_id(), Client.class);

        return new CarResponse.Builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .matricue(car.getMatricule())
                .client(client)
                .build();
    }
}

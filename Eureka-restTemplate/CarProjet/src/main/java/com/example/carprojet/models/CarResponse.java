package com.example.carprojet.models;

import com.example.carprojet.entities.Client;

public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String matricue;
    private Client client;

    // Private constructor for the builder
    private CarResponse(Builder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.matricue = builder.matricue;
        this.client = builder.client;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMatricue() {
        return matricue;
    }

    public void setMatricue(String matricue) {
        this.matricue = matricue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Static Builder class
    public static class Builder {
        private Long id;
        private String brand;
        private String model;
        private String matricue;
        private Client client;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder matricue(String matricue) {
            this.matricue = matricue;
            return this;
        }

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public CarResponse build() {
            return new CarResponse(this);
        }
    }
}

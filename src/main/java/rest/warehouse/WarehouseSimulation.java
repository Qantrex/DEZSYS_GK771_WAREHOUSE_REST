package rest.warehouse;

import net.datafaker.Faker;
import rest.model.Product;
import rest.model.WarehouseData;

import java.util.Locale;
import java.util.Random;

public class WarehouseSimulation {

    private final Random random = new Random();
    private final Faker faker = new Faker(new Locale("de-AT"));

    private double getRandomDouble(int inMinimum, int inMaximum) {
        double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
        return Math.round(number * 100.0) / 100.0;
    }

    private int getRandomInt(int inMinimum, int inMaximum) {
        return random.nextInt((inMaximum - inMinimum) + 1) + inMinimum;
    }

    /**
     * Generate simulated WarehouseData with random attributes and products.
     */
    public WarehouseData getData(String inID) {
        WarehouseData data = new WarehouseData();

        data.setWarehouseID(inID);
        data.setWarehouseName("Lagerhaus " + faker.company().name());
        data.setWarehouseAddress(faker.address().streetAddress());
        data.setWarehousePostalCode(faker.address().zipCode());
        data.setWarehouseCity(faker.address().cityName());
        data.setWarehouseCountry("Austria");

        int productCount = getRandomInt(2, 5);
        for (int i = 0; i < productCount; i++) {
            data.addProduct(generateRandomProduct());
        }

        return data;
    }

    /**
     * Generate a random Product with faker and random numbers.
     */
    private Product generateRandomProduct() {
        String productID = String.format("%02d-%06d", getRandomInt(0, 99), getRandomInt(100000, 999999));
        String productName = faker.commerce().productName();
        String productCategory = faker.commerce().department();
        int productQuantity = getRandomInt(50, 5000);
        String productUnit = getRandomUnit();

        return new Product(productID, productName, productCategory, productQuantity, productUnit);
    }

    /**
     * Provide a random unit type.
     */
    private String getRandomUnit() {
        String[] units = {
                "Packung 1L", "Packung 2L", "Packung 700G",
                "Packung 1KG", "Karton 6x0.5L", "Beutel 500G"
        };
        return units[random.nextInt(units.length)];
    }
}
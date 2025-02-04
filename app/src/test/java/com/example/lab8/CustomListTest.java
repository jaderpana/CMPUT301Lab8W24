package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * @return create a mocklist for my citylist
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();

        // cities
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Toronto", "Ontario");

        // only add city1
        list.addCity(city1);

        // hasCity calls
        assertTrue(list.hasCity(city1)); // should be true
        Assertions.assertFalse(list.hasCity(city2)); // should be false
    }

    @Test
    void testDeleteCity(){
        list = MockCityList();

        // add a city to the list and assert it is in list
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertTrue(list.hasCity(city));

        // call delete and assert it is not in list
        list.delete(city);
        Assertions.assertFalse(list.hasCity(city));
    }

    @Test
    void testCountCities(){
        list = MockCityList();

        // add Calgary, only Edmonton and Calgary are in list (2 cities)
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertEquals(1, list.countCities());

        // delete and check is list is only Edmonton (1 city)
        list.delete(city);
        assertEquals(0, list.countCities());
    }

}

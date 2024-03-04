package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {
    @Test
    void testDelete(){
        City c1=new City("Toronto","Ontario");
        City c2=new City("Vancouver"," British Columbia");
        City c3=new City("Sydney","New South Wales");
        City c4=new City("Melbourne","Victoria");
        CityList cityList= new CityList();
        cityList.add(c1);
        cityList.add(c2);
        cityList.add(c3);
        cityList.add(c4);
        cityList.delete(c2);
        assertEquals(3,cityList.count());
    }
    @Test
    void testDeleteException(){
        City c1=new City("Toronto","Ontario");
        City c2=new City("Vancouver"," British Columbia");
        City c3=new City("Sydney","New South Wales");
        City c4=new City("Melbourne","Victoria");
        City c5=new City("Los Angeles","California");
        CityList cityList= new CityList();
        cityList.add(c1);
        cityList.add(c2);
        cityList.add(c3);
        cityList.add(c4);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(c5);
        });
    }

    @Test
    void testCount(){
        City c1=new City("Toronto","Ontario");
        City c2=new City("Vancouver"," British Columbia");
        City c3=new City("Sydney","New South Wales");
        City c4=new City("Melbourne","Victoria");
        CityList cityList= new CityList();
        cityList.add(c1);
        cityList.add(c2);
        cityList.add(c3);
        cityList.add(c4);
        assertEquals(4,cityList.count());
    }
    @Test
    void testSort(){
        City c1=new City("Toronto","Ontario");
        City c2=new City("Vancouver"," British Columbia");
        City c3=new City("Sydney","New South Wales");
        City c4=new City("Melbourne","Victoria");
        CityList cityList= new CityList();
        cityList.add(c1);
        cityList.add(c2);
        cityList.add(c3);
        cityList.add(c4);
        assertEquals("Melbourne",cityList.getCitiesNameSorted().get(0).getCityName());
        assertEquals("Sydney",cityList.getCitiesNameSorted().get(1).getCityName());
        assertEquals("Toronto",cityList.getCitiesNameSorted().get(2).getCityName());
        assertEquals("Vancouver",cityList.getCitiesNameSorted().get(3).getCityName());
    }

}
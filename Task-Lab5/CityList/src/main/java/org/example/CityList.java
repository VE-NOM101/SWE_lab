package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCitiesNameSorted() {
        List<City> cityList = new ArrayList<>(cities);

        for (int i = 0; i < cityList.size() - 1; i++) {
            for (int j = 0; j < cityList.size() - i - 1; j++) {
                if (cityList.get(j).getCityName().compareTo(cityList.get(j + 1).getCityName()) > 0) {
                    City temp = cityList.get(j);
                    cityList.set(j, cityList.get(j + 1));
                    cityList.set(j + 1, temp);
                }
            }
        }

        return cityList;
    }

    /**
     * This deletes a specific city from city-list
     * @param city
     *            The city should be removed
     */
    void delete(City city){
        boolean found = false;
        for (Iterator<City> iterator = cities.iterator(); iterator.hasNext();) {
            City i = iterator.next();
            if (i.getCityName().equals(city.getCityName())) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("City not found");
        }
    }

    /**
     * This function counts the number of cities in city-list
     * @return
     *      The count of city-list
     */
    int  count(){
        int c = 0 ;
        for(City i : cities){
            c++ ;
        }
        return c ;
    }

    /**
     * This function sorts the city-list(Changes the original Arraylist)
     */
    void sort(){
        Collections.sort(cities);
    }

    void display(){
        for(City c : cities){
            System.out.println("State: "+c.getCityName()+", Province: "+c.getProvinceName());
        }
    }


    public static void main(String[] args) {
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
        cityList.display();
        System.out.println();
        cityList.delete(c2);
        cityList.display();
        System.out.println(cityList.count());
        List<City> ct= cityList.getCitiesNameSorted();
        for(City c : ct){
            System.out.println("State: "+c.getCityName()+", Province: "+c.getProvinceName());
        }

    }

}
package org.example;

public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * This is a constructor
     * @param city
     *          name of city
     * @param province
     *          name of province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the city name(String)
     * @return
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Returns the province name(String)
     * @return
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * It's mainly used in sorting operation
     * @param city the object to be compared.
     * @return
     */

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}

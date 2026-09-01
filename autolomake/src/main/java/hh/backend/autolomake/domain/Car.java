package hh.backend.autolomake.domain;

public class Car {
    //attribuutit
    private String brand;
    private Long year;
    
    //konstruktorit
    public Car(String brand, Long year) {
        super();
        this.brand = brand;
        this.year = year;
    }
    //Parametriton
    public Car() {
        super();
        this.brand = null;
        this.year = null;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Long getYear() {
        return year;
    }
    public void setYear(Long year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", year=" + year + "]";
    }
}

package academy.belhard;

public class Address {

    private int id;
    private String city;
    private String street;
    private int houseNumber;
    private int building;
    private int flat;

    public Address(int id, String city, String street, int houseNumber, int building, int flat) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.building = building;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getBuilding() {
        return building;
    }

    public int getFlat() {
        return flat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return city + " " + street + " " + houseNumber + "/" + building + " kv. " + flat + "\n";
    }
}

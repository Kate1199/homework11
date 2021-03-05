package academy.belhard;

public class Main {

    public static void main(String[] args) {

        Address a1 = new Address(1, "Minsk","ul.Myansikova", 32, 1, 23);
        Address a2 = new Address(2, "Minsk","ul.Korolya",2, 9, 28);
        Address a3 = new Address(3, "Minsk","ul.Burdeinogo",31,1,56 );
        Address a4 = new Address(4, "Minsk","ul.Leshinskogo", 8, 1, 89);
        Address a5 = new Address(5, "Minsk","ul.Chichurina",4, 1, 156);

        AddressConnector.add(a1);
        AddressConnector.add(a2);
        AddressConnector.add(a3);
        AddressConnector.add(a4);
        AddressConnector.add(a5);

        System.out.println(AddressConnector.readAll().toString());

        a1.setStreet("ul.Masukovshina");
        a2.setHouseNumber(15);

        AddressConnector.update(a1);
        AddressConnector.update(a2);

        AddressConnector.delete(3);
        AddressConnector.delete(4);
    }
}

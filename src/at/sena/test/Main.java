package at.sena.test;

public class Main {
    public static void main(String[] args){
        TrafficController controller = new TrafficController();

        Passenger p1 = new Passenger("Sena","Özcan");
        Passenger p2 = new Passenger("Dorotea", "Milic");

        Plane plane1 = new Plane("Maria", new Position(10,20));

        controller.addPlanes(plane1);
        controller.printAllPlanes();
        plane1.addPassenger(p1);
        p2.inform();
        plane1.informPassengers();
        controller.informPeopleOnAllPlanes();
    }
}

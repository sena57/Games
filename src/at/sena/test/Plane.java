package at.sena.test;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private String name;
    private Position position;
    private List<Passenger> passengers;

    public Plane(String name, Position position) {
        this.name = name;
        this.position = position;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passengers){ this.passengers.add(passengers);}
    public List<Passenger> getPassengers() { return passengers; }


    public void informPassengers(){
        for (Passenger passengers: this.passengers) {
            passengers.inform(); }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

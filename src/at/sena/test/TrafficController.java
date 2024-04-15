package at.sena.test;

import java.util.ArrayList;
import java.util.List;

public class TrafficController {
    private List<Plane> planes;

    public TrafficController() {
        this.planes = new ArrayList<>();
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public void addPlanes(Plane planes){ this.planes.add(planes);}

    public void printAllPlanes(){
        for (Plane planes: this.planes) {
            System.out.println("Plane: " + planes.getName() + " " + planes.getPosition().getLatitude()); }
    }

    public void informPeopleOnAllPlanes(){
        for (Plane planes: this.planes) {
            planes.informPassengers(); }
    }
}

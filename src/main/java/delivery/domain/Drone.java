package delivery.domain;

import java.util.ArrayList;

public class Drone {
    private String id;

    private Position currentPosition;

    private ArrayList<Position> routeTraveled;

    public Drone(String id, Position currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public ArrayList<Position> getRouteTraveled() {
        return routeTraveled;
    }

    public void setRouteTraveled(ArrayList<Position> routeTraveled) {
        this.routeTraveled = routeTraveled;
    }
}

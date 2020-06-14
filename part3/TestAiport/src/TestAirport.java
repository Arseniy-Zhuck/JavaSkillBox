import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.Iterator;
import java.util.List;

public class TestAirport {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Aircraft> aircraftList = airport.getAllAircrafts();
        Iterator iterator;
        iterator = aircraftList.iterator();
        System.out.println("We have " + aircraftList.size() + " aircrafts");
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}

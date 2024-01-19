// The code is defining a Java interface called `RadioInter`. An interface in Java is a collection of
// abstract methods that can be implemented by classes.
public interface RadioInter {

    void turnOn();

    void turnOff();

    void changeFrequency();

    void scanStations();

    void saveStation(int button);

    void selectStation(int button);

    Band getBand();

    void setBand(Band band);
}
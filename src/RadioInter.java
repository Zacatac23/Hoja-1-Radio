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
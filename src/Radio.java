public class Radio implements RadioInter {

   // These are instance variables of the `Radio` class.
    private boolean isOn;
    private double frequency;
    private int currentButton;
    private double[] savedStations;
    private Band band;

    // The `public Radio()` constructor is initializing the instance variables of the `Radio` class.
    public Radio() {
        this.isOn = false;
        this.frequency = 87.9; // Frecuencia predeterminada de FM
        this.currentButton = 1;
        this.savedStations = new double[12];
        this.band = Band.FM; // Inicializar la banda a FM
    }

    /**
     * The turnOn() function turns on the radio and prints a message indicating that it has been turned
     * on.
     */
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Radio encendida.");
    }

    /**
     * The turnOff() function turns off the radio and prints a message indicating that the radio has
     * been turned off.
     */
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Radio apagada.");
    }

    /**
     * The function changes the frequency of a radio, either increasing it by 10 for AM or by 0.2 for
     * FM, and switches the band if the frequency exceeds the maximum value.
     */
    @Override
    public void changeFrequency() {
        if (!isOn) {
            System.out.println("La radio está apagada. Enciéndela primero.");
        } else {
            if (band == Band.AM) {
                frequency += 10;
                if (frequency > 1610) {
                    frequency = 530; // Cambiar a AM
                    band = Band.AM;
                    System.out.println("Cambiando a la banda de AM. Frecuencia cambiada a: " + frequency);
                } else {
                    System.out.println("Frecuencia cambiada a: " + frequency);
                }
            } else {
                frequency += 0.2; // Incrementar en 0.2 para FM
                if (frequency > 107.9) {
                    frequency = 87.9;
                    System.out.println("Cambiando a la banda de FM. Frecuencia cambiada a: " + frequency);
                } else {
                    System.out.println("Frecuencia cambiada a: " + frequency);
                }
            }
        }
    }

    /**
     * The scanStations() function scans for radio stations within a specified frequency range and
     * prints the found stations.
     */
    @Override
    public void scanStations() {
        if (isOn) {
            System.out.println("Escaneando emisoras...");
            for (double currentFrequency = frequency; currentFrequency <= 1610; currentFrequency += 10) {
                if (currentFrequency > 107.9) {
                    currentFrequency = 87.9; // Reiniciar al llegar al final del dial FM
                }
                System.out.println("Encontrada emisora en frecuencia: " + currentFrequency);
            }
        } else {
            System.out.println("La radio está apagada. Enciéndela primero.");
        }
    }

   /**
    * The function saves the current radio station frequency to a specified button if the radio is on
    * and the button is valid.
    * 
    * @param button The "button" parameter represents the button number on the radio where the station
    * will be saved.
    */
    @Override
    public void saveStation(int button) {
        if (isOn && button >= 1 && button <= 12) {
            currentButton = button;
            savedStations[currentButton - 1] = frequency;
            System.out.println("Emisora guardada en el botón " + currentButton);
        } else {
            System.out.println("Botón inválido o la radio está apagada.");
        }
    }

    /**
     * The selectStation function selects a station based on the button pressed, if the radio is on and
     * the button is valid.
     * 
     * @param button The parameter "button" represents the button number that the user wants to select.
     * It is an integer value.
     */
    @Override
    public void selectStation(int button) {
        if (isOn && button >= 1 && button <= 12) {
            if (savedStations[button - 1] != 0) {
                frequency = savedStations[button - 1];
                currentButton = button;
                System.out.println("Seleccionada emisora desde el botón " + currentButton);
                System.out.println("Frecuencia actual: " + frequency);
            } else {
                System.out.println("No hay emisora guardada en el botón " + button);
            }
        } else {
            System.out.println("Botón inválido o la radio está apagada.");
        }
    }

    /**
     * The function returns the band associated with an object.
     * 
     * @return The method is returning an object of type Band.
     */
    @Override
    public Band getBand() {
        return band;
    }

    // The `@Override` annotation is used to indicate that the method `setBand` is overriding a method
    // from the superclass or implementing an interface method.
    @Override
    public void setBand(Band band) {
        this.band = band;
        System.out.println("Banda cambiada a: " + band);
    }
}

// Enumeración para representar las bandas de la radio
enum Band {
    AM,
    FM
}
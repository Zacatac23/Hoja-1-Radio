public class Radio implements RadioInter {

    private boolean isOn;
    private double frequency;
    private int currentButton;
    private double[] savedStations;
    private Band band;

    public Radio() {
        this.isOn = false;
        this.frequency = 87.9; // Frecuencia predeterminada de FM
        this.currentButton = 1;
        this.savedStations = new double[12];
        this.band = Band.FM; // Inicializar la banda a FM
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Radio encendida.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Radio apagada.");
    }

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

    @Override
    public Band getBand() {
        return band;
    }

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
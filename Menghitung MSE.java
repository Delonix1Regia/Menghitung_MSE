// Menghitung MSE


public class PBO_TUGAS4 {
    private double MSE;
    private double[] data = {106.74, 103.01, 102.14, 100.24, 91.45, 98.73, 94.06, 157.5, 152.33, 149.2, 149.04, 142.9, 151.62, 144.96, 152.85, 151.08, 143.33, 150.81, 153.24, 144.95};
    private double[] ramal;
    private double[] salah;
    private double[] salahkuadrat;

    public PBO_TUGAS4() {
        this.ramal = new double[data.length];
        this.salah = new double[data.length];
        this.salahkuadrat = new double[data.length];
    }

    public void hitungRamalan() {
        ramal[0] = data[0];

        for (int i = 1; i < data.length; i++) {
            double sum = 0.0;
            for (int j = 0; j <= i; j++) {
                sum += data[j];
            }
            ramal[i] = sum / (double) (i + 1);
        }
    }

    public void hitungSalah() {
        for (int i = 0; i < data.length; i++) {
            salah[i] = data[i] - ramal[i];
        }
    }

    public void hitungSalahKuadrat() {
        for (int i = 0; i < data.length; i++) {
            salahkuadrat[i] = Math.pow(salah[i], 2);
        }
    }

    public void hitungMSE() {
        double kesalahankuadrat = 0.0;
        for (int i = 0; i < data.length; i++) {
            kesalahankuadrat += salahkuadrat[i];
        }
        MSE = kesalahankuadrat / (double) data.length;
    }

    public void cetak() {
        System.out.println("Data\tRamalan\tKesalahan");

        for (int i = 0; i < data.length; i++) {
            System.out.println(Math.round(data[i]) + "\t\t" + Math.round(ramal[i]) + "\t\t" + Math.round(salah[i]));
        }
        System.out.println("MSE = "+MSE);
        System.out.println("MSE = "+Math.round(MSE));
    }

    public static void main(String[] args) {
        PBO_TUGAS4 meramal = new PBO_TUGAS4();
        meramal.hitungRamalan();
        meramal.hitungSalah();
        meramal.hitungSalahKuadrat();
        meramal.hitungMSE();
        meramal.cetak();
    }
}
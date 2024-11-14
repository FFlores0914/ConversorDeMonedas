import java.io.IOException;

public class Conversion {
    private final API conversor;

    public Conversion() {
        this.conversor = new API();
    }

    public double convert(String from, String to, double amount) throws IOException, InterruptedException {
        double rate = conversor.getExchangeRate(from, to);
        return amount * rate;
    }
}

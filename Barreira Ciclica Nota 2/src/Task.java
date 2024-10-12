import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final Map<Financeiro, Map<String, Double>> results;
    private final Financeiro tipo;
    private final List<String> lines;

    public Task(CyclicBarrier cyclicBarrier, Map<Financeiro, Map<String, Double>> results, Financeiro tipo, Path file) {
        this.cyclicBarrier = cyclicBarrier;
        this.results = results;
        this.tipo = tipo;

        try {
            this.lines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        HashMap<String, Double> finances = new HashMap<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");

            String date = data[0];
            String value = data[1].strip().replace("\"", "");

            Double currentValue = finances.getOrDefault(date, 0.0);
            finances.put(date, currentValue + Double.parseDouble(value));
        }

        results.put(tipo, finances);

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

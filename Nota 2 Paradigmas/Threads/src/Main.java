import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int TOTAL_THREADS = 4;
    public static final AtomicInteger sum = new AtomicInteger(0);
    public static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("Threads/src/new_calibration_text.txt").toAbsolutePath();
        List<String> calibrations = Files.readAllLines(path);

        final int INTERVALO = Math.floorDiv(calibrations.size(), TOTAL_THREADS);

        long tempoInicial = System.currentTimeMillis();
        try (ExecutorService executor = Executors.newFixedThreadPool(TOTAL_THREADS)) {
            for (int i = 0; i < TOTAL_THREADS; i++) {
                int start = INTERVALO * i;
                int end = Math.min(start + INTERVALO, calibrations.size());

                if (start < end) {
                    Tarefa tarefa = new Tarefa(calibrations, start, end);
                    executor.submit(tarefa);
                }
            }
        }

        System.out.println("A soma dos valores é: " + sum);
        System.out.println("Total de linhas: " + count);

        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }
}
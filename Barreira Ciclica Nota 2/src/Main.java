import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int NUM_WORKERS = 3;

    public static void main(String[] args) {
        Map<Financeiro, Map<String, Double>> results = Collections.synchronizedMap(new HashMap<>());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new GroupingTask(results));

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            executor.submit(new Task(cyclicBarrier, results, Financeiro.DESPESA, Path.of("C:\\Users\\Diego Gadelha\\Desktop\\Nova pasta (3)\\src\\despesas.csv")));
            executor.submit(new Task(cyclicBarrier, results, Financeiro.PROVISAO, Path.of("C:\\Users\\Diego Gadelha\\Desktop\\Nova pasta (3)\\src\\provisao.csv")));
            executor.submit(new Task(cyclicBarrier, results, Financeiro.RECEITA, Path.of("C:\\Users\\Diego Gadelha\\Desktop\\Nova pasta (3)\\src\\receitas.csv")));
        }
    }
}
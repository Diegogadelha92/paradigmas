import java.util.HashMap;
import java.util.Map;

public class GroupingTask implements Runnable {
    private final Map<Financeiro, Map<String, Double>> results;

    public GroupingTask(Map<Financeiro, Map<String, Double>> results) {
        this.results = results;
    }

    @Override
    public void run() {

    }
}

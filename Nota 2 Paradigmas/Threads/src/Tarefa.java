import java.util.List;

public class Tarefa implements Runnable {
    private final List<String> calibrations;
    private final int start;
    private final int end;

    public Tarefa(List<String> calibrations, int start, int end) {
        this.calibrations = calibrations;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            Main.sum.getAndAdd(Calibration.value(calibrations.get(i)));
            Main.count.getAndIncrement();
        }
    }
}

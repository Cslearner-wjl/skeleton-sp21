package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int m = 10000;

        for ( int n = 1000; n <= 128000; n *= 2){
            SLList<Integer> SL = new SLList<>();

            for (int i = 0; i < n; i += 1){
                SL.addLast(i);
            }

            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < m; i += 1){
                SL.getLast();
            }
            double time = sw.elapsedTime();
            Ns.addLast(n);
            times.addLast(time);
            opCounts.addLast(m);
        }
        printTimingTable(Ns, times, opCounts);
    }

}

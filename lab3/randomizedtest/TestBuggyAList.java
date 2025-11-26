package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);
        buggy.addLast(4);
        buggy.addLast(5);
        buggy.addLast(6);

        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.size(), B.size());
            } else if (operationNumber == 1) {
                // size
                int L_size = L.size();
                int B_size = B.size();
                assertEquals(L_size, B_size);
            } else if (operationNumber == 2) {
                //getLast
                if(L.size() > 0){
                    int L_last = L.getLast();
                    int B_last = B.getLast();
                    assertEquals(L_last, B_last);
                } else {
                    assertEquals(0,B.size());
                }
            } else if (operationNumber == 3) {
                //removeLast
                if(L.size() > 0){
                    int L_removed = L.removeLast();
                    int B_removed = B.removeLast();
                    assertEquals(L_removed, B_removed);
                } else {
                    assertEquals(0,B.size());
                }
            }
        }
    }
}

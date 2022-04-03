/*
* L is a linked list
* 1. process p = L.removeFirst( )
* 2. Give a time slice to process p
* 3. L.addLast(p)
* */

import java.util.ArrayList;
import java.util.Random;

public class RoundRobin {
    private static final int nrProcesses = 10;
    public static void main(String[] args) throws InterruptedException {
        CircularlyLinkList<Process> processes = new CircularlyLinkList<>();
        for(int i=0; i<nrProcesses; i++){
            processes.append(new Process(i+1));
        }
        Random random = new Random();
        while (!processes.isEmpty()) {
            int workToDo = random.nextInt(0, 50);
            processes.head().doWork(workToDo);
            Thread.sleep(100);
            if (processes.head().isFinished())
                processes.popFirst();
            else processes.rotate();
            updateProgressBar(processes.toList());
        }
    }

    private static void updateProgressBar(ArrayList<Process> list) {

        int scale = 10;
        int workLeft = list.stream().map(Process::getWorkToDo).reduce(Integer::sum).orElse(0);
        int workDone = nrProcesses*100 - workLeft;
        String result = "| " + "/".repeat(Math.max(0, workDone / scale)) +
                " ".repeat(Math.max(0, workLeft / scale)) +
                " | %d/%d (%.2f %c)\r";
        System.out.printf(result, workDone, nrProcesses*100, workDone*1./nrProcesses, '%');
    }
}

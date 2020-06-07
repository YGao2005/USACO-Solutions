/*
ID: gaoyang8
LANG: JAVA
PROG: milk2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int farmerNum = Integer.parseInt(f.readLine());
        ArrayList<Integer> completeStartList = new ArrayList<>();
        ArrayList<Integer> completeEndList = new ArrayList<>();
        int largestBreak = 0;
        int biggestCheckTerm;
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < farmerNum; i++) {
            String currentTime = f.readLine();
            int startTime = Integer.parseInt(currentTime.substring(0, currentTime.indexOf(' ')));
            int endTime = Integer.parseInt(currentTime.substring(currentTime.indexOf(' ') + 1));
            pairs.add(new int[]{startTime, endTime});
        }
        pairs.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });
        int count = 0;
        while (count < farmerNum) {
            if (count == 0 || pairs.get(count)[0] > completeEndList.get(completeEndList.size() - 1)) {
                completeStartList.add(pairs.get(count)[0]);
                completeEndList.add(pairs.get(count)[1]);
            } else {
                int lastEndValue = completeEndList.get(completeEndList.size() - 1);
                completeEndList.remove(completeEndList.size() -1);
                completeEndList.add(Math.max(lastEndValue, pairs.get(count)[1]));
            }
            count++;
        }
        int largestMilking = 0;
        for (int i3 = 0; i3 < completeEndList.size(); i3++) {
            int testCount = completeEndList.get(i3) - completeStartList.get(i3);
            if (largestMilking < testCount) {
                largestMilking = testCount;
            }
        }
        for (int i4 = 0; i4 < completeEndList.size() - 1; i4++) {
            int countTest = completeStartList.get(i4 + 1) - completeEndList.get(i4);
            if(countTest < 0){
                biggestCheckTerm = Math.abs(countTest - 1);
                if(biggestCheckTerm == largestMilking){
                    largestBreak = 0;
                    break;
                }
            }
            if (largestBreak < countTest) {
                largestBreak = countTest;
            }

        }
        if(farmerNum == 1){
            largestMilking = pairs.get(0)[1] - pairs.get(0)[0];
            out.println(largestMilking + " 0");
            out.close();
        }
        else{
            out.println(largestMilking + " " + largestBreak);
            out.close();
        }
    }
}

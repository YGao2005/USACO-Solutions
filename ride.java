/*
ID: gaoyang8
LANG: JAVA
PROG: ride
*/
import java.io.*;
        import java.util.ArrayList;
        import java.util.List;


public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String firstLine = f.readLine();
        int count = firstLine.charAt(0) - 64;
        for(int i = 1; i< firstLine.length(); i++){
            count = count * (firstLine.charAt(i) -64);
        }
        String secondLine = f.readLine();
        int count2 = secondLine.charAt(0) - 64;
        for(int i = 1; i< secondLine.length(); i++){
            count2 = count2 * (secondLine.charAt(i) -64);
        }
        if(count % 47 == count2 % 47){
            out.println("GO");
        }
        else{
            out.println("STAY");
        }
        out.close();
    }
}

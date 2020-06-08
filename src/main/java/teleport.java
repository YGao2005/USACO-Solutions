import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class teleport {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        String allValues = f.readLine();
        List<Integer> intValues = new ArrayList<>();
        for (String value : allValues.split(" ")) {
            intValues.add(Integer.parseInt(value));
        }

    }

}

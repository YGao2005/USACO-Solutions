/*
ID: gaoyang8
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.Scanner;

class beads{
    public static void main (String args []) throws Exception
    {
        Scanner in = new Scanner (new File("beads.in"));
        PrintWriter out = new PrintWriter("beads.out");
        int beads = in.nextInt();
        in.nextLine();
        String necklace = in.nextLine();
        necklace += necklace;
        int max = 0;
        for (int i = 0; i < beads; i++){
            int current = countBeads(necklace,i);
            if (current > max){
                if (current >= beads){
                    max = beads;
                }
                else{
                    max = current;
                }
            }
        }
        out.println(max);
        out.close();
    }
    public static int countBeads(String necklace, int index){
        char [] beadedNecklace = necklace.toCharArray();
        int count = 0;
        if (beadedNecklace[index] == 'w'){
            for (int i = index; i < beadedNecklace.length; i++){
                if (beadedNecklace[i] != 'w'){
                    break;
                }
                else{
                    count++;
                    index++;
                }
            }
        }
        if (index < beadedNecklace.length){
            if (beadedNecklace[index] == 'r'){
                for (int i = index; i < beadedNecklace.length; i++){
                    if (beadedNecklace[i] == 'b'){
                        break;
                    }
                    else{
                        count++;
                        index++;
                    }
                }
                for (int i = index; i < beadedNecklace.length; i++){
                    if (beadedNecklace[i] == 'r'){
                        break;
                    }
                    else{
                        count++;
                    }
                }
            }
            else if (beadedNecklace[index] == 'b'){
                for (int i = index; i < beadedNecklace.length; i++){
                    if (beadedNecklace[i] == 'r'){
                        break;
                    }
                    else{
                        count++;
                        index++;
                    }
                }
                for (int i = index; i < beadedNecklace.length; i++){
                    if (beadedNecklace[i] == 'b'){
                        break;
                    }
                    else{
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


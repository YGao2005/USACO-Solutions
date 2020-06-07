/*
ID: gaoyang8
LANG: JAVA
PROG: namenum
*/
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class namenum {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        int cowNum = Integer.parseInt(f.readLine());
        ArrayList<String> dictionary = new ArrayList<>();
        for(int i = 0; i < 4617; i++){
            dictionary.add(d.readLine());
        }
        HashMap<Integer, String> numMap = new HashMap<>();
        numMap.put(2, "ABC");
        numMap.put(3, "DEF");
        numMap.put(4, "GHI");
        numMap.put(5, "JKL");
        numMap.put(6, "MNO");
        numMap.put(7, "PRS");
        numMap.put(8, "TUV");
        numMap.put(9, "WXY");
        ArrayList<String> nameList = new ArrayList<>();

            String currentString = numMap.get(cowNum / 1000);
            for(int i1 = 0; i1 < 27; i1++){
                nameList.add(String.valueOf(currentString.charAt(0)));
            }
            for(int i2 = 0; i2 < 27; i2++){
                nameList.add(String.valueOf(currentString.charAt(1)));
            }
            for(int i3 = 0; i3 < 27; i3++){
                nameList.add(String.valueOf(currentString.charAt(2)));
            }


            String current2String = numMap.get((cowNum%1000)/100);
            for(int i5 = 0; i5 < 3; i5++){
                for(int i4 = 0; i4 < 8; i4++){
                    String temp = nameList.get(i4 + (27 * i5));
                    nameList.set(i4 + (27 * i5), temp + current2String.charAt(0));
                }
                for(int i4 = 8; i4 < 17; i4++){
                    String temp = nameList.get(i4 + (27 * i5));
                    nameList.set(i4  + (27 * i5), temp + current2String.charAt(1));
                }
                for(int i4 = 17; i4 < 27; i4++){
                    String temp = nameList.get(i4 + (27 * i5));
                    nameList.set(i4 + (27 * i5), temp + current2String.charAt(2));
                }
            }


        String current3String = numMap.get((cowNum%100)/10);
        for(int i5 = 0; i5 < 9; i5++){
            for(int i4 = 0; i4 < 3; i4++){
                String temp = nameList.get(i4 + (9 * i5));
                nameList.set(i4 + (9 * i5), temp + current3String.charAt(0));
            }
            for(int i4 = 3; i4 < 6; i4++){
                String temp = nameList.get(i4 + (9 * i5));
                nameList.set(i4  + (9 * i5), temp + current3String.charAt(1));
            }
            for(int i4 = 6; i4 < 9; i4++){
                String temp = nameList.get(i4 + (9 * i5));
                nameList.set(i4 + (9 * i5), temp + current3String.charAt(2));
            }
        }


        String current4String = numMap.get((cowNum%10));
        for(int i5 = 0; i5 < 27; i5++){
            for(int i4 = 0; i4 < 1; i4++){
                String temp = nameList.get(i4 + (3 * i5));
                nameList.set(i4 + (3 * i5), temp + current4String.charAt(0));
            }
            for(int i4 = 1; i4 < 2; i4++){
                String temp = nameList.get(i4 + (3 * i5));
                nameList.set(i4  + (3 * i5), temp + current4String.charAt(1));
            }
            for(int i4 = 2; i4 < 3; i4++){
                String temp = nameList.get(i4 + (3 * i5));
                nameList.set(i4 + (3 * i5), temp + current4String.charAt(2));
            }
        }
        ArrayList<String> ansArray = new ArrayList<>();
        boolean checkStatement = false;
    for(int i6 = 0; i6 < 81; i6++){
        if(dictionary.contains(nameList.get(i6))){
            ansArray.add(nameList.get(i6));
            checkStatement = true;
        }
    }
    if(checkStatement == false){
        out.println("NONE");
        out.close();
    }
    else{
        for(int i7 = 0; i7 < ansArray.size(); i7++){
            out.println(ansArray.get(i7));
        }
        out.close();
    }
}
}

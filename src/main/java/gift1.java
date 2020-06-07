/*
ID: gaoyang8
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.ArrayList;


public class gift1 {
    public static void main(String[] args) throws IOException {
            BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        String line;
        ArrayList<String> nameArray = new ArrayList<>();
        while((line = f.readLine()) != null){
            nameArray.add(line);
        } //creates an array list with each string inside each box is a line inside the file
        int amountOfPeople = Integer.parseInt(nameArray.get(0));
        String[] nameList = new String[amountOfPeople];
        for(int i3 =0; i3 < amountOfPeople; i3++){
            nameList[i3] = nameArray.get(1+i3);
        }
        int[] cashBalance = new int[amountOfPeople];
        for(int i =1; i < nameArray.size(); i++){
            String lineString = nameArray.get(i);
            boolean testCode = false;
            for(int i1 = 0; i1 < lineString.length(); i1++){ //goes through the current string to see if there is any number inside
                if(Character.isDigit(lineString.charAt(i1))){
                    testCode = true;
                }
            }
            if(testCode){
                int spaceLine = nameArray.get(i).indexOf(' ');
                int moneyGiven = Integer.parseInt(nameArray.get(i).substring(0, spaceLine));
                int peopleGiven = Integer.parseInt(nameArray.get(i).substring(spaceLine+1));
                String givingPerson = nameArray.get(i-1);
                int count = 0;
                while(peopleGiven > count){
                    String currentName = nameArray.get(i+count+1);
                    for(int i4 = 0; i4 < nameList.length; i4++){
                        if(nameList[i4].equalsIgnoreCase(currentName)){
                            cashBalance[i4] = cashBalance[i4] + moneyGiven/peopleGiven;
                        }

                    }
                    count++;
                }
                for(int i5 = 0; i5 < nameList.length; i5++){
                    if(nameList[i5].equalsIgnoreCase(givingPerson) && peopleGiven != 0){
                        cashBalance[i5] = cashBalance[i5] + moneyGiven%peopleGiven - moneyGiven;
                    }
                }
            }
        }
        for(int i6 = 0; i6 < nameList.length; i6++){
            out.println(nameList[i6] + " " + cashBalance[i6]);
        }
        out.close();
    }
}

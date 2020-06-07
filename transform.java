/*
ID: gaoyang8
LANG: JAVA
PROG: transform
*/
import java.io.*;

public class transform {
    public static void main(String[] args) throws IOException{
        //makes the first and second matrix
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int lengthSize = Integer.parseInt(f.readLine());
        char[][] firstMatrix = new char[lengthSize][lengthSize];
        for(int i2 = 0; i2 < lengthSize; i2++){
            String currentLine = f.readLine();
            for(int i = 0; i < lengthSize; i++){
                firstMatrix[i2][i] = currentLine.charAt(i);
            }
        }
        char[][] secondMatrix = new char[lengthSize][lengthSize];
        for(int i3 = 0; i3 < lengthSize; i3++){
            String currentLine = f.readLine();
            for(int i4 = 0; i4 < lengthSize; i4++){
                secondMatrix[i3][i4] = currentLine.charAt(i4);
            }
        }

        //testing to see if rotating 90 will do anything
        char[][] ninetyMatrix = new char[lengthSize][lengthSize];
        if(lengthSize/2 != lengthSize/2.0){
            ninetyMatrix[lengthSize/2][lengthSize/2] = firstMatrix[lengthSize/2][lengthSize/2];
        }
        for (int i5 = 0; i5 < lengthSize / 2; i5++)
        {
            for (int j = i5; j < lengthSize - i5 - 1; j++)
            {
                ninetyMatrix[i5][j] = firstMatrix[lengthSize - 1 - j][i5];
                ninetyMatrix[lengthSize - 1 - j][i5] = firstMatrix[lengthSize - 1 - i5][lengthSize - 1 - j];
                ninetyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j] = firstMatrix[j][lengthSize - 1 - i5];
                ninetyMatrix[j][lengthSize - 1 - i5] = firstMatrix[i5][j];
            }
        }

        //test to see if rotating 180 will do anything
        char[][] oneEightyMatrix = new char[lengthSize][lengthSize];
        if(lengthSize/2 != lengthSize/2.0){
            oneEightyMatrix[lengthSize/2][lengthSize/2] = firstMatrix[lengthSize/2][lengthSize/2];
        }
        for (int i5 = 0; i5 < lengthSize / 2; i5++)
        {
            for (int j = i5; j < lengthSize - i5 - 1; j++)
            {
                oneEightyMatrix[i5][j] = ninetyMatrix[lengthSize - 1 - j][i5];
                oneEightyMatrix[lengthSize - 1 - j][i5] = ninetyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j];
                oneEightyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j] = ninetyMatrix[j][lengthSize - 1 - i5];
                oneEightyMatrix[j][lengthSize - 1 - i5] = ninetyMatrix[i5][j];
            }
        }


        //270 degree transformation
        char[][] twoSeventyMatrix = new char[lengthSize][lengthSize];
        if(lengthSize/2 != lengthSize/2.0){
            twoSeventyMatrix[lengthSize/2][lengthSize/2] = firstMatrix[lengthSize/2][lengthSize/2];
        }
        for (int i5 = 0; i5 < lengthSize / 2; i5++)
        {
            for (int j = i5; j < lengthSize - i5 - 1; j++)
            {
                twoSeventyMatrix[i5][j] = oneEightyMatrix[lengthSize - 1 - j][i5];
                twoSeventyMatrix[lengthSize - 1 - j][i5] = oneEightyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j];
                twoSeventyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j] = oneEightyMatrix[j][lengthSize - 1 - i5];
                twoSeventyMatrix[j][lengthSize - 1 - i5] = oneEightyMatrix[i5][j];
            }
        }

        //testing to see if reflecting will do anything
        char[][] reflectedMatrix = new char[lengthSize][lengthSize];
        //the middle row will never change during transformation
        if(lengthSize/2 != lengthSize/2.0){
            for(int j0 = 0; j0 < lengthSize; j0++){
                reflectedMatrix[j0][lengthSize/2] = firstMatrix[j0][lengthSize/2];
            }
        }
        for (int j1 = 0; j1 < lengthSize; j1++)
        {
            for (int j2 = 0; j2 < lengthSize; j2++){
                reflectedMatrix[j1][j2] = firstMatrix[j1][lengthSize - 1 - j2];
                reflectedMatrix[lengthSize - 1 - j1][j2] = firstMatrix[lengthSize - 1 - j1][lengthSize - 1 - j2];
            }
        }

        char[][] combinedNinetyMatrix = new char[lengthSize][lengthSize];
        if(lengthSize/2 != lengthSize/2.0){
            combinedNinetyMatrix[lengthSize/2][lengthSize/2] = reflectedMatrix[lengthSize/2][lengthSize/2];
        }
        for (int i5 = 0; i5 < lengthSize / 2; i5++)
        {
            for (int j = i5; j < lengthSize - i5 - 1; j++)
            {
                combinedNinetyMatrix[i5][j] = reflectedMatrix[lengthSize - 1 - j][i5];
                combinedNinetyMatrix[lengthSize - 1 - j][i5] = reflectedMatrix[lengthSize - 1 - i5][lengthSize - 1 - j];
                combinedNinetyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j] = reflectedMatrix[j][lengthSize - 1 - i5];
                combinedNinetyMatrix[j][lengthSize - 1 - i5] = reflectedMatrix[i5][j];
            }
        }

        //test to see if rotating 180 will do anything
        char[][] combinedOneEightyMatrix = new char[lengthSize][lengthSize];
        if(lengthSize/2 != lengthSize/2.0){
            combinedOneEightyMatrix[lengthSize/2][lengthSize/2] = firstMatrix[lengthSize/2][lengthSize/2];
        }
        for (int i5 = 0; i5 < lengthSize / 2; i5++)
        {
            for (int j = i5; j < lengthSize - i5 - 1; j++)
            {
                combinedOneEightyMatrix[i5][j] = combinedNinetyMatrix[lengthSize - 1 - j][i5];
                combinedOneEightyMatrix[lengthSize - 1 - j][i5] = combinedNinetyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j];
                combinedOneEightyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j] = combinedNinetyMatrix[j][lengthSize - 1 - i5];
                combinedOneEightyMatrix[j][lengthSize - 1 - i5] = combinedNinetyMatrix[i5][j];
            }
        }


        //270 degree transformation
        char[][] combinedTwoSeventyMatrix = new char[lengthSize][lengthSize];
        if(lengthSize/2 != lengthSize/2.0){
            combinedTwoSeventyMatrix[lengthSize/2][lengthSize/2] = firstMatrix[lengthSize/2][lengthSize/2];
        }
        for (int i5 = 0; i5 < lengthSize / 2; i5++)
        {
            for (int j = i5; j < lengthSize - i5 - 1; j++)
            {
                combinedTwoSeventyMatrix[i5][j] = combinedOneEightyMatrix[lengthSize - 1 - j][i5];
                combinedTwoSeventyMatrix[lengthSize - 1 - j][i5] = combinedOneEightyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j];
                combinedTwoSeventyMatrix[lengthSize - 1 - i5][lengthSize - 1 - j] = combinedOneEightyMatrix[j][lengthSize - 1 - i5];
                combinedTwoSeventyMatrix[j][lengthSize - 1 - i5] = combinedOneEightyMatrix[i5][j];
            }
        }
        String ninetyString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                ninetyString = ninetyString + ninetyMatrix[i][j];
            }
        }
        String oneEightyString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                oneEightyString = oneEightyString + oneEightyMatrix[i][j];
            }
        }
        String twoSeventyString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                twoSeventyString = twoSeventyString + twoSeventyMatrix[i][j];
            }
        }
        String combinedNinetyString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                combinedNinetyString = combinedNinetyString + combinedNinetyMatrix[i][j];
            }
        }
        String combinedOneEightyString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                combinedOneEightyString = combinedOneEightyString + combinedOneEightyMatrix[i][j];
            }
        }
        String combinedTwoSeventyString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                combinedTwoSeventyString = combinedTwoSeventyString + combinedTwoSeventyMatrix[i][j];
            }
        }
        String firstString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                firstString = firstString + firstMatrix[i][j];
            }
        }
        String secondString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                secondString = secondString + secondMatrix[i][j];
            }
        }
        String reflectedString = "";
        for(int i = 0; i < lengthSize; i++){
            for(int j = 0; j < lengthSize; j++){
                reflectedString = reflectedString + reflectedMatrix[i][j];
            }
        }
        if(ninetyString.equalsIgnoreCase(secondString)){
            out.println("1");
            out.close();
        }
        else if (oneEightyString.equalsIgnoreCase(secondString)){
            out.println("2");
            out.close();
        }
        else if(twoSeventyString.equalsIgnoreCase(secondString)){
            out.println("3");
            out.close();
        }
        else if(reflectedString.equalsIgnoreCase(secondString)){
            out.println("4");
            out.close();
        }
        else if(combinedNinetyString.equalsIgnoreCase(secondString)){
            out.println("5");
            out.close();
        }
        else if(combinedOneEightyString.equalsIgnoreCase(secondString)){
            out.println("5");
            out.close();
        }
        else if(combinedTwoSeventyString.equalsIgnoreCase(secondString)){
            out.println("5");
            out.close();
        }
        else if(firstString.equalsIgnoreCase(secondString)){
            out.println("6");
            out.close();
        }
        else{
            out.println("7");
            out.close();
        }
    }
}

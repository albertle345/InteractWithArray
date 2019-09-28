package com.company;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Main {
    public static final int MAX_ROW = 2, MAX_COL =  3;

    public static void main(String[] args) {
        // write your code here
        Scanner read = new Scanner(System.in);
        int a[] = {33, 11, 22, 21, 12, 19};
        int matrix[][] = {{1,3,4},{3,4,5}};
        int matrix2[][] = new int[3][3];
        int aCopy[] = copyArray(a, a.length);
        int pos = 3, val = 21;
        System.out.println("The First Array: " + Arrays.toString(a));
        System.out.println("The Copy Array: " + Arrays.toString(aCopy));
        System.out.println("in ma tran");
        printArray(matrix);
        System.out.println("nhap mang moi");
        importArray(matrix2, read);
        printArray(matrix2);
        int newArray[] = insertAnElement(a, 3, 17);
        System.out.println("The  Array after inserted " + Arrays.toString(newArray));
        int eraseElement[] = removeAnElement(a ,val);
        System.out.println("The  Array after erase element " + Arrays.toString(eraseElement));
        int firstPart[] = part_1(a);
        System.out.println(("Array after divided "+Arrays.toString(firstPart)));
        int secondPart[] = part_2(a);
        System.out.println(("Array after divided "+Arrays.toString(secondPart)));
        int combineArray[] = combineArray(firstPart,secondPart);
        System.out.println(("Array after combine "+Arrays.toString(combineArray)));
        divideArray(a);
        int findElemet = findAnElement(a, val);
        System.out.println("gia tri can tim "+findElemet);
        int max = findMax(a);
        System.out.println("gia tri lon nhat: "+ max);
        int max2 = findMax2(a);
        System.out.println("gia tri lon nhat2: "+max2);

        read.close();
    }

    private static void printArray(int matrix[][]){
        for(int i = 0; i < MAX_ROW;i++){
            for(int j = 0;j < MAX_COL;j++){
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    private static void importArray(int matrix[][], Scanner reader){
        for(int i = 0;i < MAX_ROW;i++){
            for(int j = 0;j < MAX_COL;j++){
                //matrix[i] = reader.nextInt();
                matrix[i][j] = reader.nextInt();
            }
        }
    }

    private static int[] copyArray(int curArray[], int size) {
        int newArray[] = new int[size];
        for(int i = 0;i < curArray.length;i++){
            newArray[i] = curArray[i];
        }
        return newArray;
    }

    //  insertAnElement(int curArray[], int pos, int val)
    private static int[] insertAnElement(int curArray[], int pos, int val){
        int newSize = curArray.length + 1;
        int newArray[] = copyArray(curArray, newSize);

        int index = pos - 1;
        for(int i = newArray.length - 1 ; i >= index;i--){
            newArray[i] = newArray[i - 1];
        }
        newArray[index] = val;
        return newArray;
    }

    //removeAnElement(int curArray[], int val)
    private static int[] removeAnElement(int[] curArray, int val){
        int newSize = curArray.length;
        int newArray[] = new int[newSize - 1];

        for(int i = 0; i < curArray.length;i++){
            if(curArray[i] == val)
            {
                for(int j = 0;j < i;j++){
                    newArray[j] = curArray[j];
                }
                //shift element
                for(int j = i;j < curArray.length - 1;j++){
                    newArray[j] = curArray[j + 1];
                }
            }
        }
        return newArray;
    }

    //divideArray(int curArray[], int part_1[],int part_2[] )
    private static int[] part_2(int[] curArray){
        int arraySize = curArray.length;
        int newArray[] = new int[arraySize / 2];
        int i = 0;
            for(int j = (curArray.length / 2); j < curArray.length; j++){
                newArray[i] = curArray[j];
                i++;
            }
        return newArray;
    }
    private static int[] part_1(int[] curArray){
        int arraySize = curArray.length;
        int newArray[] = new int[(arraySize / 2)];
        int lastElement = newArray.length - 1;
        for(int i = 0;i < newArray.length;i++){
            if(i <= lastElement){
                newArray[i] = curArray[i];
            }
        }
        return newArray;
    }

    //combineArray(int part_1[],int part_2[], int newArray[])
    private static int[] combineArray(int part_1[], int part_2[]){
        int arraySize = part_1.length + part_2.length;
        int newArray[] = new int[arraySize];
        int k = 0;
        for(int i = 0;i < part_1.length; i++){
            newArray[k] = part_1[i];
            k++;
        }
        for(int i = 0; i < part_2.length;i++){
            newArray[k] = part_2[i];
            k++;
        }
        return newArray;
    }
    // findAnElm(int curArray[], int val) => res = a[x] //Find
    private static int findAnElement(int curArray[],int val){
        int res = 0;
        for(int i = 0;i < curArray.length;i++){
            if(curArray[i] == val){
                res = curArray[i];
            }
        }
        return res;
    }

    //divideArray(int curArray[]] )
    private static void divideArray(int curArray[]){
        int size = curArray.length;
        int evenNumber = countEvenNumber(curArray);
        int oddNumber = countOddNumber(curArray);
        int part_1[] = new int[evenNumber];
        int part_2[] = new int[oddNumber];
        int i = 0, j = 0;
        for(int k = 0; k < curArray.length; k++){
            if(curArray[k] % 2 == 0){
                part_1[i] = curArray[k];
                i++;
            }
            else
            {
                part_2[j] = curArray[k];
                j++;
            }
        }
        System.out.println("mang chan: "+Arrays.toString(part_1));
        System.out.println("mang le: "+Arrays.toString(part_2));
    }
    private static int countEvenNumber(int curArray[]){
        int dem = 0;
        for(int i = 0;i < curArray.length;i++){
            if(curArray[i] % 2 == 0){
                dem++;
            }
        }
        return dem;
    }
    private static int countOddNumber(int curArray[]){
        int dem = 0;
        for(int i = 0;i < curArray.length;i++){
            if(curArray[i] % 2 !=0){
                dem++;
            }
        }
        return dem;
    }

    private static int findMax(int curArray[]){
        int max = curArray[0];
        for(int i = 1; i < curArray.length; i++){
            if(max < curArray[i]){
                max = curArray[i];
            }
        }
        return max;
    }
    private static int[] sortArray(int curArray[]) {
        int newSize = curArray.length;
        int newArray[] = copyArray(curArray, newSize);
        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i] < newArray[j]) {
                    int temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
            return newArray;

    }
    private static int findMax2(int curArray[]){
            int max = 0;
            int newArray[] = sortArray(curArray);
            max = newArray[0];
            return max;
    }

}

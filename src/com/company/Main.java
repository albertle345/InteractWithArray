package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PrimitiveIterator;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int a[] = {33, 11, 22, 21, 12, 19};
        int aCopy[] = copyArray(a, a.length);
        int pos = 3, val = 21;
        System.out.println("The First Array: " + Arrays.toString(a));
        System.out.println("The Copy Array: " + Arrays.toString(aCopy));

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

}

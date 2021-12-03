package com.company;
import java.util.Arrays;

/**
 * Программа для сортировки массива по количеству элементов
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 1, 1, 2, 2, 1, 4444,5,5,8};
        System.out.println("Отсортированный массив: " + Arrays.toString(sort(arr)));
    }

    /**
     * Метод производит сортировку исходный массив по частоте
     *
     * @param arr - массив
     * @return - возврат отсортированного массива
     */
    public static int[] sort(int[] arr) {

        int[][] twoDimensionalArray = sortByFrequency(arr);

        int counter = 0;

        for (int i = 0; i < twoDimensionalArray[1].length; i++) {
            int numberOccurrences = 0, value = 0, index = 0;

            for (int j = 0; j < twoDimensionalArray[1].length; j++) {
                if (numberOccurrences < twoDimensionalArray[1][j] && twoDimensionalArray[1][j] != 0) {
                    numberOccurrences = twoDimensionalArray[1][j];
                    index = j;
                    value = twoDimensionalArray[0][j];
                }
            }
            for (int g = 0; g < numberOccurrences; g++) {
                arr[counter] = value;
                counter++;
            }
            twoDimensionalArray[1][index] = 0;
        }
        return arr;
    }

    /**
     * Метод создаёт двумерный массив, записывая число с кол-вом вхождений
     *
     * @param arr - массив
     * @return - возврат отсортированного двумероного массива с числомами и кол-вом их вхождений
     */
    private static int[][] sortByFrequency(int[] arr) {
        int[][] twoDimensionalArray = new int[2][arr.length];

        int counter = 0;

        for (int value : arr) {
            if (checkForFoundItems(twoDimensionalArray, value)) {
                twoDimensionalArray[0][counter] = value;
                for (int i : arr) {
                    if (twoDimensionalArray[0][counter] == i) {
                        twoDimensionalArray[1][counter]++;
                    }
                }
                counter++;
            }
        }
        return twoDimensionalArray;
    }

    /**
     * Метод проверяет содержит ли двумерный массив похожее число и возвращает true или false
     * @param arr   - массив
     * @param value - число
     * @return - возврат результата проверки на повтор чисел
     */

    private static boolean checkForFoundItems(int[][] arr, int value) {
        boolean permission = true;

        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] == value && arr[1][j] != 0) {
                permission = false;
                break;
            }
        }
        return permission;
    }
}

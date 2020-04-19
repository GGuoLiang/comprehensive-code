package com.gguoliang.dataStructures.sparsearray;

/**
 * 稀疏数组
 *
 *
 */
public class Sparsearray {


    public static void main(String[] args) {
        int[][] array  = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        arrayPrint(array);
        System.out.println(" 属猪转稀疏数组  ");
        int[][] arrayToSparsearray = arrayToSparsearray(array);
        arrayPrint(arrayToSparsearray);
        System.out.println(" 稀疏数组转数组 ");
        array = sparsearrayToArray(arrayToSparsearray);
        arrayPrint(array);


    }


    public static void arrayPrint(int[][] array ){
        for (int[] row : array) {
            for (int item : row) {
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }

    // 数组转稀疏数组
    public static int[][] arrayToSparsearray(int[][] array ){
        //sum 表示array有多少个有效值
        int sum = 0;
        for (int[] row : array) {
            for (int item : row) {
                if(item != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparsearray  = new int[sum+1][3];
        sparsearray[0][0] = array.length;
        sparsearray[0][1] = array[0].length;
        sparsearray[0][2] = sum;
        // 稀疏数组赋值
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if(array[i1][i] != 0){
                    sparsearray[count][0] = i1;
                    sparsearray[count][1] = i;
                    sparsearray[count][2] = array[i1][i];
                    count++;
                }
            }
        }
        return sparsearray;
    }

    //稀疏数组转数组
    public static int[][] sparsearrayToArray(int[][] sparsearray ){
        int[][] array = new int[sparsearray[0][0]][sparsearray[0][1]];
        for (int i = 1; i < sparsearray.length; i++) {
            array[sparsearray[i][0]][sparsearray[i][1]] = sparsearray[i][2] ;
        }

        return array;
    }

}

package exercise;

import java.util.Arrays;

class SafetyList {

    private int[] arr = new int[0];

    public synchronized void add(int value) {
        // скопировать массив и добавить в него

        arr = Arrays.copyOf(arr, arr.length +1);
        arr[arr.length -1] = value;
       // System.out.println(arr.length);
    }

    public int get(int index) {
        return arr[index];
    }

    public int getSize() {
        return arr.length;
    }

    // BEGIN
    
    // END
}

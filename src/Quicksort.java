import java.io.File;
import java.util.Scanner;

public class Quicksort {

    private static int pivot = 0;

    public static int [] Quicksort(int [] array, int l, int h) {
        if (l < h) {
            pivot = sort(array, l, h);
            Quicksort(array, l, pivot - 1);
            Quicksort(array, pivot + 1, h);
        }
        return array;
    }

    public static int sort(int [] array, int l, int h){
        pivot = array[h];
        int i = l - 1;
        for(int j = l; j < h ; j++){
            if(array[j] < pivot){
                i++;
                qSwap(array, i, j);
            }
        }
        qSwap(array, i + 1, h);
        return (i + 1);
    }

    public static void qSwap(int [] arr, int i, int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void print(int [] array){
        String answer = "";
        for(int i = 0; i < array.length; ++i){
            answer += array[i];
            if(i != array.length -1){ answer += " "; }
        }
        System.out.println(answer);
    }

    public static void main(String [] args) throws Exception {
        Scanner scan = new Scanner(new File(args[0]));
        int T = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < T; i++) {
            String[] temp = scan.nextLine().split(" ");
            int [] demo = new int[temp.length];
            for(int j = 0; j < temp.length; ++j){
                demo[j] = Integer.parseInt(temp[j]);
            }
           print(Quicksort(demo, 0, temp.length-1));
        }
    }
}

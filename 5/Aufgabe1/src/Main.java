public class Main {

    public static void main(String[] args) {
        int[] array1 = {1, 12, 41};
        print42Sums(array1);
        int[] array2 = {1, 2, 3, 42};
        print42Sums(array2);
        int[] array3 = {1, 2, 3, 4, 5, 30, 12};
        print42Sums(array3);

    }

    //TODO remove duplicates
    public static void print42Sums(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int b = 0; b < inputArray.length; b++) {
                if (i != b && inputArray[i] + inputArray[b] == 42)
                    System.out.println(inputArray[i] + "+" + inputArray[b] + "= 42");
            }
        }
    }
}

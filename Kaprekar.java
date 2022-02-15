public class Kaprekar {
    public static void main(String[] args) {
        // the algorithm only works for 4 digit numbers
        for(int i = 1000; i < 9999;i++)
            // the algorithm does not work for the numbers such 'aaaa'
            if(i % 1111 != 0)
                System.out.println(i + " ends up as " + kaprekar(i));
    }
    static int kaprekar(int num){
        // creating an array to store all the digits of num
        int[] digits = new int[4];
        // using an variable that is not 'num' in order not to change the value of 'num' while calculating
        int numCurrent = num;
        // the answer we found after doing the math
        int answer = 0;
        // putting every single digit of 'num' to the array 'digits'
        for(int i = 0; i < 4; i++) {
            digits[i] = numCurrent % 10;
            numCurrent = numCurrent / 10;
        }
        // sorting the array in order to subtract the largest number you can get from arranging the digits of num
        // from the lowest number you can get.
        sort(digits);
        // doing the subtraction
        for(int i = 0; i < 4; i++)
            answer = (digits[3-i] - digits[i]) + answer * 10;
        // if the original number 'num' does not change, then we know that it is the last number you can get using this algorith
        if(answer == num)
            return answer;
        // however if the number 'num' changes, we still don't know if the algorithm can change the number again so we call the function again.
        else
            answer = kaprekar(answer);
        return answer;
    }
    // Insertion sort
    static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int current = arr[i];
            while (j >= 0 && arr[j] > current){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;
        }
    }
}

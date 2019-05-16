package movietheater;

class Main
{
       // Naive method to find a pair in an array with given sum
       public static void findPair(int[] A, int sum)
       {
              // consider each element except last element
              for (int i = 0; i < A.length - 1; i++)
              {
                     // start from i'th element till last element
                     for (int j = i + 1; j < A.length; j++)
                     {
                           // if desired sum is found, print it and return
                           if (A[i] + A[j] == sum)
                           {
                                  System.out.println("Pair found at index " + i + " and " + j);
                                  
                           }
                     }
              }

              // No pair with given sum exists in the array
//            System.out.println("Pair not found");
       }

       // main function
       public static void main (String[] args)
       {
              int A[] = {2,4,2,3,4,2,1,2,1,3};
              int sum = 5;

              findPair(A, sum);
       }
}


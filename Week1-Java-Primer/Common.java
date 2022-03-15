public class Common {
	public static void printArray(int[] array) {
  	  if (array == null || array.length == 0) {
  		System.out.println("No array to print out!");
  		return;
  	  }
  	  for (int number: array) {
  		  System.out.print(number + " ");
  	  }
  	  System.out.println();
    }
}

import java.util.Arrays;

public class equals {

	public static void main(String[] args) {
		
		int i = 4;
		int[] arrayA = new int[] {1, 2, 3, 4, 5};
		int[] arrayB = new int[] {1, 2, 3, 4};
		int[] arrayC = new int[] {3, 1, 2, 4};	
		System.out.println("2在数组中的index是" + Arrays.binarySearch(arrayA, 2));
		System.out.println(Arrays.equals(arrayA, arrayB));
		
		Arrays.sort(arrayC);
		for (int value: arrayC) {
			
			System.out.print(value + "  ");	
		}
		System.out.println();
		
	}
}

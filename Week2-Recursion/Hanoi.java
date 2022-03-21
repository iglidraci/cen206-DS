/*
-We are given a platform with three pegs, a, b and c
-On peg a is a stack of n disks, each larger than the next, so that the smallest
 is on the top and the largest is on the bottom
-The puzzle is to move all the disks from peg a to peg c
-moving one disk at a time
-we never place a larger disk on top of a smaller one
*/

public class Hanoi {
	public static void main (String[] args) {
		if (args.length != 4) {
			System.out.println("Wrong usage!");
			System.out.println("java Hanoi nr from to aux");
			System.exit(1);
		}
		int nr = Integer.valueOf(args[0]);
		hanoi(nr, args[1], args[2], args[3]);
	}

	public static void hanoi(int n, String from, String to, String aux) {
		/*
		n is the number of disks to be moved
		from is the rode where all the disks are placed on top of each other
		to is the destination rode
		aux is an auxiliary rode
		*/
		if (n == 1) {
			print(from, to);
			return;
		}
		// move all n-1 disks from 'from' rode to 'aux' rode
		hanoi(n-1, from, aux, to);
		// at this point there is only one disk to move from 'from' rode to 'to' rode
		// this disk is now at his final destination not to be moved any more
		print(from, to);
		// move all n-1 disks from the 'aux' rode to the final destination 'to' rode
		hanoi(n-1, aux, to, from);
	}
	private static void print (String from, String to) {
		System.out.printf("%s -> %s\n", from, to);
	}
}

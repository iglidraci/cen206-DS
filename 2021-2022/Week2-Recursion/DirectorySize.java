import java.io.File;

public class DirectorySize {
	public static void main (String[] args) {
		if (args.length != 1) {
			System.out.println("Wrong args given");
			System.out.println("java DirectorySize path");
			System.exit(1);
		}
		File file = new File(args[0]);
		if (file.exists()) {
			long size = getSize(file);
			System.out.println(size + " bytes");
			System.out.println(size/1024 + " KB");
			System.out.println(size/Math.pow(1024, 2) + " MB");
		} else {
			System.out.println("Path was not found");
		}
	}
	public static long getSize(File file) {
		System.out.println("Checking " + file.getPath());
		if (file.isFile())
			return file.length();
		File[] subFiles = file.listFiles();
		long total = 0;
		for (File sub: subFiles)
			total += getSize(sub);
		return total;
	}
}

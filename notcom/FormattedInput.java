import java.util.Scanner;
import java.util.InputMismatchException;

public class FormattedInput 
{
	public static void main(String[] args) { 
			
		//try {
		//	Object[] vals1 = sscanf("%l %l %l", "2\nstring gg d\n42");
		//	for (int i = 0; i < vals1.length; i++) {
		//		if (vals1[i] != null) {
		//			System.out.println(vals1[i]);
		//		}
		//	}
		//}
		//catch (InputMismatchException Throwable) {
		//	System.out.println(Throwable.getMessage()); 
		//}
		
		
		Object[] vals = scanf("%d %c");
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] != null) {
				System.out.println(vals[i]);
			}
		}
		
	}
	
	public static Object[] scanf(String format) {
		while(true) {
			try {
				System.out.println("Enter symbols " + format);
				Scanner scanner = new Scanner(System.in);
				String str = scanner.nextLine();
				Object[] vals = sscanf(format, str);
				scanner.close();
				return vals;
			}
			catch (InputMismatchException Throwable) {
				System.out.println(Throwable.getMessage()); 
			}
		}
	}
	
	public static Object[] sscanf(String format, String in) {
		Scanner scanner = new Scanner(in);
		Object[] vals = new Object[format.length()/2];
		scanner.useDelimiter("\s");
		int j = 0;
		while (scanner.hasNext()) {
			System.out.println("sscanf");
			for (int i = 0; i < format.length(); ) {
				
				if (format.startsWith("%d", i)) {
					if (scanner.hasNextInt()) {
						vals[j] = scanner.nextInt();
						j++;
						i += "%d".length();
					}
					else{
						throw new InputMismatchException("Incorrect value");
					}
				}
				
				if (format.startsWith("%f", i)) {
					System.out.println("Double");
					if (scanner.hasNextDouble()) {
						System.out.println("hasNextDouble()");
						vals[j] = scanner.nextDouble();
						j++;
						i += "%f".length();
					}
					else {
						throw new InputMismatchException("Incorrect value");
					}
				}
				
				if (format.startsWith("%s", i)) {
					if (scanner.hasNextLine()) {
						vals[j] = scanner.next();
						j++;
						i += "%s".length();
					}
					
				}
				
				if (format.startsWith("%l", i)) {
					if (scanner.hasNextLine()) {
						vals[j] = scanner.nextLine();
						j++;
						i += "%l".length();
					}
					
				}

				if (format.startsWith("%c", i)) {
					if (scanner.hasNext()) {
						String str = scanner.next();
						if (str.length() == 1) {
							vals[j] = str.charAt(0);
							j++;
							i += "%c".length();
						}
					}
					
					else {
						throw new InputMismatchException("Incorrect value");
					}
					
				}
				
				else {
					i++;
				}
			}
		}	
		scanner.close();
		return vals;
	}
}
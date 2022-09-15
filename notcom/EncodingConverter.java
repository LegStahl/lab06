import java.io.*;

public class EncodingConverter
{
	public static void main(String[] args) throws IOException  {
		
		String inFile = args[0];
		String outFile = args[1];
		String outFile2 = args[2];
		String inCode = args[3];
		String outCode = args[4];
		String outCode2 = args[5];
		
		File file = new File(inFile);
		
		String[] codes = new String[5];
		codes[0] = "utf8";
		codes[1] = "cp1251";
		codes[2] = "cp866";
		codes[3] = "ISO-8859-1";
		codes[4] = "utf16";
		
		if (!file.exists()){
			System.out.println("Input file does not exist");
			return;
		}
		
		for (int i = 0; i < codes.length; i++) {
			if (inCode.equals(codes[i]) && outCode.equals(codes[i]) && outCode2.equals(codes[i])) {
				System.out.println("Incorrect code");
				return;
			}
		}
		Reader reader = new InputStreamReader(new FileInputStream(inFile), inCode);
		Writer writer = new OutputStreamWriter(new FileOutputStream(outFile), outCode);
		Reader reader2 = new InputStreamReader(new FileInputStream(inFile), inCode);
		Writer writer2 = new OutputStreamWriter(new FileOutputStream(outFile2), outCode2);
		int c = 0;
		while ((c = reader.read()) >= 0){
			writer.write(c);
		}
		c = 0;
		while ((c = reader2.read()) >= 0){
			writer2.write(c);
		}
		
		reader.close();
		writer.close();
		reader2.close();
		writer2.close();
		
	}
}

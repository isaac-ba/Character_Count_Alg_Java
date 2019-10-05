import java.io.*;
import java.util.*;

public class CharCount {

	public static void main(String[] args){

		if(args.length == 0 || args.length == 1){
			System.out.println("Invalid # of arugments\n");
			return;
		}
		System.out.println("args[0]: " + args[0]);
		System.out.println("args[1]: " + args[1]);

		Scanner inFile = null;
		BufferedWriter outFile = null;
		
		try {// 	step 0: - open input and output files
			inFile = new Scanner(new FileReader(args[0]));
			outFile = new BufferedWriter(new FileWriter(args[1]));		
		}
        catch (IOException e) {
        	e.printStackTrace();
    	}

    	int[] charCount = new int[256];
    	char charIn;
    	int index;

     	while(inFile.hasNext()){// step 4: repeat step 1 to step 3 while infile is not empty
     		String nextWord = inFile.next();
     		for (int i = 0;i < nextWord.length() ;i++ ) {
			 	charIn =  nextWord.charAt(i);// step 1: charIn <- get the next character from inFile,one character at a time
			 	index = (int)charIn;// step 2: index <- cast charIn to integer
				if(index < 256)
		     		charCount[index]++;// step 3: charCounts[index]++
     		}

    	}
 		// step 5: printAry
    	 printAry(outFile,charCount);

		// step 6: close all files
		try {
			inFile.close();
			outFile.close();				

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done counting!");
	}

	// printAry algorithm
 	public static void printAry(BufferedWriter outFile, int[] charCount){

		int index = 0;// step 1: index <--0
		char symbol;
		while(index < 256){// step 4: repeat step 2 to step 3 while i < 256
			if(charCount[index] > 0){// step 2: if charCounts[index] > 0
				symbol = (char)index;// symbol <-- cast index to charactor
				try{
					outFile.write(symbol + "  "+charCount[index]+ "\n");// write symbol  charCounts[index]  per text line
				}
				catch(IOException e){
					e.printStackTrace();
				}			
			}
			index++;// step 3: index ++
		}
	}
}
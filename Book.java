import java.util.*;
import java.io.*;
import java.nio.file.*; 
public class Book{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i=-1;
		while(i!=0){

			System.out.print("enter file name: ");

			String str=input.nextLine();
			File file = new File(str);

			System.out.println("Choose");
			System.out.println("1. delete one symbol from all text");
			System.out.println("2. convert all text to UpperCase");
			System.out.println("3. convert all text to LowerCase");
			System.out.println("4. letter frequencies");
			System.out.println("5. the longest word");
			System.out.println("6. all palindromes");
			System.out.println("7. all words start from vowels");
			System.out.println("8. all words start from consonant");
			System.out.print("Enter your choice: ");
			i=input.nextInt();
			input.nextLine();

			if(i==1){
				System.out.print("Enter symbol you want to delete: ");
				String symbol=input.nextLine();
				clearFile(file,symbol);
			}else if(i==2){
				convertUpper(file);
			}else if(i==3){
				convertLower(file);
			}else if(i==4){
				countLetters(file);
			}else if(i==5){
				longestWord(file);
			} else if (i == 6) {
				findPalindromes(file);
			} else if (i == 7) {
				vowels(file);
			}else if (i == 8) {
				consonant(file);
			}

		}



	



		
	}


	public static void clearFile(File file, String symbol){

		File file2 = new File(symbol + file.getName());
		try{
			PrintWriter pw= new PrintWriter(file2);
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			st=st.replaceAll(symbol,"");
    			pw.println(st);
  			}
  			
			// Scanner sc = new Scanner(file);
			// while(sc.hasNextLine()){
			// 	String s=sc.nextLine();
			// 	String replaceString=s.replaceAll(symbol, "");
			// 	pw.println(replaceString);
				


			// }

			pw.close();
			
        }catch(FileNotFoundException e){
			System.out.println("Error");
		}catch(IOException e){
			System.out.println("Error");
		}

    }


    public static void convertUpper(File file){
    	File file2 = new File("UpperCase" + file.getName());
		try{
			PrintWriter pw= new PrintWriter(file2);
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			st=st.toUpperCase();
    			pw.println(st);
  			}

  			pw.close();
			
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}

    }

    public static void convertLower(File file){
    	File file2 = new File("LowerCase" + file.getName());
		try{
			PrintWriter pw= new PrintWriter(file2);
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			st=st.toLowerCase();
    			pw.println(st);
  			}

  			pw.close();
			
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}

    }

    public static void countLetters(File file){
        int [] arr=	new int [100000];


        try{
			
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			st=st.replaceAll(" ","");
    			
    			for (int i = 0; i < st.length(); i++) {
    				char ch = st.charAt(i);
    				int index = (int)ch;
    				arr[index]++;
    			}
    		
  			}

  			for (int i = 0; i < arr.length; i++) {
  				if (arr[i] != 0) {
  					System.out.print((char)i);
  					System.out.println(" " + arr[i]);
  				}
  			}

  		
			
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}

    }


	public static void longestWord(File file){
		String longestWord = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			String[] arr = st.split(" ");
    			for (int i = 0; i < arr.length; i++) {
    				String s = arr[i];
    				if (s.length() > longestWord.length()) {
    					longestWord = s;
    				}

    			}

  			}

  			System.out.println(longestWord);

			
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}

	}
	public static void findPalindromes(File file){
		ArrayList<String> results = new ArrayList<>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			String[] arr = st.split(" ");

    			for (int i = 0; i < arr.length; i++) {
    				String s = arr[i];
    				s=s.toLowerCase();
    				if (isPalindrome(s) && !results.contains(s)) {
    					results.add(s);
    				}
    			}
  			}

  			for (int i = 0; i < results.size(); i++) {
  				System.out.println(results.get(i));
  			}


			
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}

	}





	public static boolean isPalindrome(String s){
		String ss = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			ss += s.charAt(i);
		}

		if (ss.equals(s)) {
			return true;
		}
		return false;
	}


	public static void vowels(File file){
		ArrayList<String> results = new ArrayList<>();
		ArrayList<Character> vowels = new ArrayList<>();
		vowels.add('e');
		vowels.add('a');
		vowels.add('u');
		vowels.add('i');
		vowels.add('o');
		try{
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			String[] arr = st.split(" ");

    			for (int i = 0; i < arr.length; i++) {
    				String s = arr[i];
    				if (s.length() > 0 && vowels.contains(s.charAt(0)) && !results.contains(s)) {
    					results.add(s);
    				}
    			}
  			}

  			for (int i = 0; i < results.size(); i++) {
  				System.out.println(results.get(i));
  			}

  		
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}
	}

	public static void consonant(File file){
		ArrayList<String> results = new ArrayList<>();
		ArrayList<Character> vowels = new ArrayList<>();
		vowels.add('e');
		vowels.add('a');
		vowels.add('u');
		vowels.add('i');
		vowels.add('o');
		try{
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
  			while ((st = br.readLine()) != null){
    			String[] arr = st.split(" ");

    			for (int i = 0; i < arr.length; i++) {
    				String s = arr[i];
    				if (s.length() > 0 && !vowels.contains(s.charAt(0)) && !results.contains(s)) {
    					results.add(s);
    				}
    			}
  			}

  			for (int i = 0; i < results.size(); i++) {
  				System.out.println(results.get(i));
  			}

  		
	        }catch(FileNotFoundException e){
				System.out.println("Error");
			}catch(IOException e){
				System.out.println("Error");
			}
	}

    
  
  



}
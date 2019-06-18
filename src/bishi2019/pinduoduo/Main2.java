package pinduoduo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main2 {
	public static void main(String args[]) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(); 
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str.toLowerCase();
        if (str.length() == 1) {
			System.out.println(str.charAt(0));
			return;
		}
        for (int i = 0; i < str.length(); i++) {
			if (hashMap.containsKey(str.charAt(i))) {
				hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
			}else {
				hashMap.put(str.charAt(i), 1);
			}
		}
        
        for (int i = 0; i < str.length(); i++) {
        	
        	if (hashMap.get(str.charAt(i)) > 1) {
				
        		if(!bijiao(str.charAt(i), hashMap)){
        			System.out.println(str.charAt(i));
        			return;
        		}else {
					hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) - 1);
				} 
			}else {
				System.out.println(str.charAt(i));
    			return;
			}
        }
     
    }

	public static boolean bijiao(char ch, HashMap<Character, Integer> hashMap) {
		for(Entry<Character, Integer> entry : hashMap.entrySet()){
			if (entry.getKey() < ch) {
				if (hashMap.get(entry.getKey()) > 1) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
		
	}

}

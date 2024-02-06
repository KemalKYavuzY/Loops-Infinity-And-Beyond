package LoopsInfinityAndBeyond;

/**
* Utility class with static methods for loop practice.
*/
public class LoopsInfinityAndBeyond {
	
/**
* Private constructor to disable instantiation.
*/
private LoopsInfinityAndBeyond() {
}

/**
* Define a flying saucer as the following string pattern: one
, followed by
* zero to many , followed by one . Write a Java method
that, given a
* string find the first instance of a flying saucer (starting
from the left)
* and return its length. If no flying saucer exists return
0.
* <p>
* For example: Given: "(==)" Return: 4
* <p>
* Given: "***()**(===)" Return: 2
* <p>
* Given: "****(***)" Return: 0
*
* @param source input string
* @return the length
*/
public static int flyingSaucerLength(String srouce) {
	
	int count = 0;
	boolean StartParentheses = false;
	
	
	for (int i = 0; i < srouce.length(); i++) {
		if (srouce.charAt(i) == '(') {
			count++;
			StartParentheses = true;
			continue;
		}
		
		if (StartParentheses == true){
			if (srouce.charAt(i) == '=') {
				count++;
			} else if (srouce.charAt(i) == ')') {
				count++;
				StartParentheses = false;
				break;
			}  else {
				count = 0;
				StartParentheses = false;
				break;
			}
		}
	}
	
	return count;
}

/**
* Write a Java method that, given a string which many
contain a flying saucer
* broken into two parts with characters in between, return
a string where the
* flying is fixed by removing the in between characters. Look
for the two parts
* of the flying saucer from left to right and fix the saucer
with the first
* available parts.
* <p>
* For example:
* Given: ***(==****===)***
* Return: ***(=====)***
* <p>
* Given: ***(==****)**=)*
* Return: ***(==)**=)*
* <p>
* Given: ***(==)**
* Return: ***(==)**
*
* @param s
* @return the fixed string
*/
public static String fixFlyingSaucer(String s) {
	boolean StartParentheses = false;
	String fixedString = "";
	
	for (int i = 0; i < s.length(); i++) {
		if (StartParentheses == false) {
			fixedString += s.charAt(i);
		} else {
			if (s.charAt(i) == '=') {
				fixedString += s.charAt(i);
			} else if (s.charAt(i) == ')') {
				fixedString += s.charAt(i);
				StartParentheses = false;
			}
		}
		if (s.charAt(i) == '(') {
			StartParentheses = true;
		}
	}
	
	return fixedString;

}

/**
* Write a Java method that, given a string which many
contain many flying
* saucers, return the number of flying saucers. For this
problem a flying
* saucer may wrap around from the right side of the string
to the left.
* <p>
* For example:
* Given: ***(===)***
* Return: 1
* <p>
* Given: =)**(==)**(
* Return: 2
* <p>
* Given: ***(=*=)**
* Return: 0
*
* @param s
* @return the number of the flying saucers
*/
public static int countFlyingSaucers(String s) {
	
	int count = 0;
	boolean EndParentheses = false;
	boolean notFlying = false;
	
	for (int i = 0; i < s.length(); i++) {
		
		if (s.charAt(i) == '(' || s.charAt(i) == ')') {
			if (s.charAt(i) == '(') {
				
				for (int j = i + 1; j < s.length(); j++) {
					
					if (s.charAt(j) == '=') {
						continue;
					} else if (s.charAt(j) == ')') {
						i = j;
						EndParentheses = true;
						break;
					} else {
						break;
					}
				}
				
			} else if (s.charAt(i) == ')') {
				
				for (int j = i - 1; j >= 0; j--) {
					
					if (s.charAt(j) == '=') {
						continue;
					} else {
						notFlying = true;
						break;
					}
				}
				
				if (notFlying != true) {
					for (int j = s.length() - 1; j > i; j--) {
						if (s.charAt(j) == '=') {
							continue;
						} else if (s.charAt(j) == '(') {
							EndParentheses = true;
							break;
						} else {
							break;
						}
					}
				}
			
			}
	
		}
		
		if (EndParentheses == true) {
			count += 1;
			notFlying = false;
			EndParentheses = false;
		}
	}
	
	return count;
}

/**
* Write a Java method that, given a string which many
contain many flying
* saucers, shifts all of the saucers one character to the
right. For this
* problem a flying saucer may wrap around from the right
side of the string to
* the left. The returned string should have the same number
of characters as
* the given string. This is achieved by moving the
character to the right of a
* saucer to its left. It can be assumed that saucers will
never be touching
* each other (i.e., there will always be at least one
character between any two
* saucers). Also, a saucer will not touch itself (e.g., "=)
(=").
* <p>
* For example:
* Given: ***(===)***
* Return: ****(===)**
* <p>
* Given: =)**(==)**(
* Return: (=)***(==)*
* <p>
* Given: a()bcde(=*=)fg
* Return: ab()cde(=*=)fg
*
* @param s
* @return
*/
public static String flyingSaucersFly(String s) {
	
	boolean EndParentheses = false;
	boolean notFlying = false;
	int start = 0;
	int end = 0;
	char[] arr = s.toCharArray();
	int brokenCount = 0;
	char temp;
	
	for (int i = 0; i < s.length(); i++) {
		
		if (s.charAt(i) == '(' || s.charAt(i) == ')') {
			if (s.charAt(i) == '(') {
				start = i;
				for (int j = i + 1; j < s.length(); j++) {
					
					if (s.charAt(j) == '=') {
						continue;
					} else if (s.charAt(j) == ')') {
						i = j;
						end = j;
						EndParentheses = true;
						break;
					} else {
						brokenCount++;
						break;
					}
				}
				
			} else if (s.charAt(i) == ')') {
				end = i;
				for (int j = i - 1; j >= 0; j--) {
					
					if (s.charAt(j) == '=') {
						continue;
					} else {
						notFlying = true;
						break;
					}
				}
				
				if (notFlying != true) {
					for (int j = s.length() - 1; j > i; j--) {
						if (s.charAt(j) == '=') {
							continue;
						} else if (s.charAt(j) == '(') {
							start = j;
							EndParentheses = true;
							break;
						} else {
							brokenCount++;
							break;
						}
					}
				}
			}
		}
		
		if (brokenCount == 0 && s.charAt(s.length()-1) == ')') {
			temp = arr[s.length() - 1];
			for (int j = s.length() - 1; j > 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[0] = temp;
			break;
		}
		
		if (EndParentheses == true) {
			notFlying = false;
			EndParentheses = false;
			
			if (end > start) {
				arr[start + 1] = arr[start];
				arr[start] = arr[end + 1];
				for (int j = start + 2; j <= end; j++) {
					arr[j] = '=';
				}
				if (end + 1 > s.length()) {
					arr[0] = ')';
				} else {
				arr[end + 1] = ')';
				}
			} else if (start > end) {
				temp = arr[s.length() - 1];
				for (int j = s.length() - 1; j > 0; j--) {
					arr[j] = arr[j-1];
				}
				arr[0] = temp;
			}
			
		} 
	}
	
	if (brokenCount == 0) {
		arr = s.toCharArray();
		temp = arr[s.length() - 1];
		for (int j = s.length() - 1; j > 0; j--) {
			arr[j] = arr[j-1];
		}
		arr[0] = temp;
	}
	
	return new String(arr);
}
}

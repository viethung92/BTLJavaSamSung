package baitaplon;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static StringBuilder str;
	static float x;
	static float kq;
	ArrayList<StringBuilder> input = new ArrayList<StringBuilder>();
	ArrayList<StringBuilder> output = new ArrayList<StringBuilder>();
	Stack<StringBuilder> stack = new Stack<StringBuilder>();

	public static float kq(float in, String s) {
		str = new StringBuilder(s);
		x = in;
		return kq;

	}

	// kiem tra muc do uu tien cua toan tu
	public static int uutien(StringBuilder s) {

		switch (s.toString()) {
		case "+":
		case "-":
			return 2;
		case "*":
		case "/":
			return 3;
		case "^":
			return 4;
		case "sin":
		case "cos":
		case "tan":
		case "cotan":
		case "arctan":
		case "arccot":
		case "arcsin":
		case "arccos":
		case "sqrt":
		case "ln":
		case "log":
		case "abs":
			return 5;
		case "(":
		case ")":

			return 1;

		default:
			return 0;

		}

	}
	
	public static int kiemtra(StringBuilder s){
		
		switch (s.toString()) {
		case "+": case"-": case"*": case"/": case"^": case"sin": case"cos": case"tan": case"cotan": case"arcsin": case"arccos":
		case"arctan": case"arccot":	case"sqrt": case"ln": case"log": case"abs":
			return 1;
		case"(":
			return 2;
		case")":
			return 3;
		default:
			return 4;
		}
				
	}
	// kiem tra muc do uu tien cua toan tu
//Tim vi tri ky tu c dau tien trong chuoi s
	
	public static int findIndex(StringBuilder s, char c){
		
		int index=-1;
		for(int i=0; i< s.length(); i++){
			if(s.charAt(i)==c){
				i=index;
				break;
			}
		}
		return index;
		
	}
	
	//tach chuoi s thanh cac chuoi con phan cach voi nhau bang ky tu c, luu trong mang sb
	public static ArrayList<StringBuilder> tachChuoi(StringBuilder s, ArrayList<StringBuilder> sb,char c){
		StringBuilder s1=s;
		int i=0;
		while (findIndex(s1, ' ')!=-1) {
			StringBuilder s2= new StringBuilder();
			s2.append(s.substring(0, findIndex(s1, ' ')+1));
			s2.deleteCharAt(s2.length()-1);
			sb.add(i, s2);
			s2.delete(0, findIndex(s1, ' ')+1);
			i++;
				
		}
		sb.add(i,s1);
		return sb;
		
	}
	
	

}

package baitaplon;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static StringBuilder str;
	static float x=0;
	static float kq;
	static ArrayList<StringBuilder> input = new ArrayList<StringBuilder>();
	static ArrayList<StringBuilder> output = new ArrayList<StringBuilder>();
	static Stack<StringBuilder> stack = new Stack<StringBuilder>();

	public static float kq(float in, String s) {
		str = new StringBuilder(s);
		x = in;
		excuite();
		return kq;

	}
	public static void excuite(){
		input = new ArrayList<StringBuilder>();
		output = new ArrayList<StringBuilder>();
		stack = new Stack<StringBuilder>();
		
		buoc1();
		input = tachChuoi(str, input, ' ');
		buoc2();
		buoc3();
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

	public static int kiemtra(StringBuilder s) {

		switch (s.toString()) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":
		case "sin":
		case "cos":
		case "tan":
		case "cotan":
		case "arcsin":
		case "arccos":
		case "arctan":
		case "arccot":
		case "sqrt":
		case "ln":
		case "log":
		case "abs":
			return 1;
		case "(":
			return 2;
		case ")":
			return 3;
		default:
			return 4;
		}

	}

	// kiem tra muc do uu tien cua toan tu
	// Tim vi tri ky tu c dau tien trong chuoi s

	public static int findIndex(StringBuilder s, char c) {

		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				index = i;
				break;
			}
		}
		return index;

	}

	// tach chuoi s thanh cac chuoi con phan cach voi nhau bang ky tu c, luu
	// trong mang sb
	public static ArrayList<StringBuilder> tachChuoi(StringBuilder s,
			ArrayList<StringBuilder> sb, char c) {
		StringBuilder s1 = s;
		int i = 0;
		while (findIndex(s1, ' ') != -1) {
			StringBuilder s2 = new StringBuilder();
			s2.append(s1.substring(0, findIndex(s1, ' ') + 1));
			s2.deleteCharAt(s2.length() - 1);
			sb.add(i, s2);
			s1.delete(0, findIndex(s1, ' ') + 1);
			i++;

		}
		sb.add(i, s1);
		return sb;

	}

	// kiem tra xem ki tu do la toan tu hay toan hang
	//
	public static int kiemtra(char c) {
		switch (c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return 2;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return 3;
		case '(':
		case ')':
			return 4;

		default:

		}
		if (c >= 'a' && c <= 'z')
			return 1;
		return 0;

	}

	// buoc 1
	public static void buoc1() {
		// xoa dau cach
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.deleteCharAt(i);
				i--;
			}

		}
		// them so 0 vao truoc cac so am
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-' && str.charAt(i - 1) == '(') 
				str.insert(i, '0');
			
		}
		// them dau cach de phan biet cac toan tu va dau ngoac
		for (int i = 0; i < str.length(); i++) {
			switch (kiemtra(str.charAt(i))) {
			case 1: {
				if (i != 0 && kiemtra(str.charAt(i - 1)) != 1)
					str.insert(i, ' ');
				i++;
				break;

			}
			case 2: // +-*/^
			{
				str.insert(i, ' ');
				i++;
				break;
			}
			case 4: // dau ngoac
			{
				if (i != 0) {
					str.insert(i, ' ');
					i++;
				}
				break;
			}
			default: // so
				break;
			}
		}
		// them dau cach vao sau cac toan hang va dau ngoac
		for (int i = 0; i < str.length(); i++) {
			switch (kiemtra(str.charAt(i))) {
			case 1: {  //ky tu
				if (i != str.length() - 1 && str.charAt(i + 1) != ' '
						&& kiemtra(str.charAt(i + 1)) != 1) {
					str.insert(i + 1, ' ');
					i++;
				}
				break;
			}
			case 2: // +-*/^
			{
				if (str.charAt(i + 1) != ' ') {
					str.insert(i + 1, ' ');
					i++;
				}
				break;
			}
			case 4: // dau ngoac
			{
				if (i != str.length() - 1 && str.charAt(i + 1) != ' ') {
					str.insert(i + 1, ' ');
					i++;
				}
				
			} break;
			default: //so
				break;
			}
		}
	}

	// buoc 2
	public static void buoc2() {
		int j = 0;
		for (int i = 0; i < input.size(); i++) {
			switch (input.get(i).toString()) {
			case "x":
				int q = input.get(i).length();
				input.get(i).delete(0, q);
				input.get(i).append(x);
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < input.size(); i++) {
			switch (kiemtra(input.get(i))) {
			case 1: {
				if (stack.isEmpty())
					stack.push(input.get(i));
				else {
					StringBuilder t = new StringBuilder();
					while (!stack.isEmpty()) {
						t = stack.pop();
						if (uutien(t) > uutien(input.get(i))) {
							output.add(j, t);
							j++;
						} else {
							stack.push(t);
							stack.push(input.get(i));
							break;
						}
						if (stack.isEmpty()) {
							stack.push(input.get(i));
							break;
						}

					}
				}
			}
				break;
			case 2: {
				stack.push(input.get(i));
			} break;
			case 3: {
				StringBuilder t = new StringBuilder();
				do {
					boolean exit = false;
					t = stack.pop();
					switch (t.toString()) {
					case "(":
						exit = true;
						break;
					default:
						output.add(j, t);
						j++;
						break;
					}
					if (exit)
						break;
				} 
				while (!stack.isEmpty());
			}
				break;

			case 4: {
				output.add(j, input.get(i));
				j++;
			}
				break;
			default:
				break;
			}
		}
		while (!stack.isEmpty()) {
			output.add(j, stack.pop());
			j++;

		}
	}

	// buoc 3
	public static void buoc3() {
		for (int i = 0; i < output.size(); i++) {
			if (kiemtra(output.get(i)) != 1)
				stack.push(output.get(i));
			else {
				switch (output.get(i).toString()) {
				case "+": {
					float x1, x2, x3;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = Float.valueOf(stack.pop().toString());
					x3 = x2 + x1;
					stack.push(new StringBuilder(String.valueOf(x3)));
				}
					break;
				case "-": {
					float x1, x2, x3;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = Float.valueOf(stack.pop().toString());
					x3 = x2 - x1;
					stack.push(new StringBuilder(String.valueOf(x3)));
				}
					break;
				case "*": {
					float x1, x2, x3;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = Float.valueOf(stack.pop().toString());
					x3 = x2 * x1;
					stack.push(new StringBuilder(String.valueOf(x3)));
				}
					break;
				case "/": {
					float x1, x2, x3;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = Float.valueOf(stack.pop().toString());
					x3 = x2 / x1;
					stack.push(new StringBuilder(String.valueOf(x3)));
				}
					break;
				case "^": {
					float x1, x2, x3;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = Float.valueOf(stack.pop().toString());
					x3 = (float) Math.pow(x2, x1);
					stack.push(new StringBuilder(String.valueOf(x3)));
				}
					break;
				case "sin": {
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.sin(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
					break;
				case "cos": {
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.cos(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
					break;
				case "tan": {
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.tan(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
					break;
				case "cotan": {
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) (1 / Math.tan(x1));
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
					break;
				case "arcsin": {
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.asin(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
					break;
				case "arccos": {
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.acos(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
					break;
				case "arctan": {

					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.atan(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
				break;
				case "arccot":
				{
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) (Math.PI-Math.atan(x1));
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
				break;
				case "sqrt":
				{
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.sqrt(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
				break;
				case "abs":
				{
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = Math.abs(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
				break;
				case "ln":
				{
					float x1, x2;
					x1 = Float.valueOf(stack.pop().toString());
					x2 = (float) Math.log(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
					
				}
				break;
				case "log":
				{
					float x1, x2;
					x1=Float.valueOf(stack.pop().toString());
					x2 = (float) Math.log10(x1);
					stack.push(new StringBuilder(String.valueOf(x2)));
				}
				break;

				default:
					break;
				}
			}

		}
		kq = Float.valueOf(stack.pop().toString());

	}
}

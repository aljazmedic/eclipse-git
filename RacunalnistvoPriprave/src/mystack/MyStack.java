/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dijak
 */
public class MyStack {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		ToStack sss = new ToStack(5);
		sss.push(3);
		try {
			System.out.println(sss.peek());
			System.out.println(sss.peek());
			System.out.println(sss.peek());
			sss.push(4);
			System.out.println(sss.toString());
			System.out.println(sss.pop());

			System.out.println(sss.peek());
			System.out.println(sss.isEmpty());
			System.out.println(sss.pop());
			System.out.println(sss.isEmpty());
			sss.push(4);
			System.out.println(sss.pop());

			System.out.println(sss.pop());
		} catch (Exception e) {
			System.out.println("Napaka");
		}

		try {
			System.out.println(sss.pop());
		} catch (Exception ex) {
			System.out.println("Napaka");
		}

	}

	public static class ToStack {
		private int sp;
		private final int buffer_size;
		private int[] sklad;

		public ToStack(int str_buffer) {
			this.sp = -1;
			this.buffer_size = str_buffer;
			this.sklad = new int[str_buffer];
		}

		private void errorMsg(String message, boolean prekinitev) throws Exception {
			Exception mojError = new Exception(message);
			if (prekinitev) {
				throw mojError;
			} else {
				System.out.println(mojError.getMessage());
			}
		}

		public boolean isEmpty() {
			return sp == -1;
		}

		public int peek() throws Exception {
			if (!this.isEmpty())
				return sklad[sp];
			else {
				errorMsg("Prazen sklad", true);
				return 0;
			}
		}

		public int pop() throws Exception {
			if (!this.isEmpty()) {
				sp--;
				return sklad[sp + 1];
			} else {
				this.errorMsg("Prazen sklad", true);
				return 0;
			}
		}

		public void push(int t) {
			if (sp < buffer_size + 1) {
				sp++;
				sklad[sp] = t;
			} else {
				try {
					errorMsg("Prekoračena velikost zaloge", false);
				} catch (Exception e) {
					System.out.println("Pol sklad!");
				}
			}
		}

		public String toString() {
			String str = "[";
			for (int i = 0; i < sp + 1; i++) {
				if (i == sp) {
					str += sklad[i] + "]";
				} else {
					str += sklad[i] + ", ";
				}
			}
			return str;
		}
	}
}

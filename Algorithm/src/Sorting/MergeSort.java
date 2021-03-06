package Sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MergeSort {
	public static void main(String args[]) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("data02.txt"));
			String line = br.readLine();

			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					int temp = Integer.parseInt(st.nextToken());
					list.add(temp);
				}
				line = br.readLine();
			}
			
			mergeSort(list);
		
			int count = 0;
			
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("%6d,", list.get(i));
				count++;
				if (count == 10) {
					System.out.println();
					count = 0;
				}
			}

			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		if (list.size() == 1) {
			return list;
		} else {
			int mid = list.size() / 2;

			for (int i = 0; i < list.size(); i++) {
				if (i < mid) {
					left.add(list.get(i));
				} else {
					right.add(list.get(i));
				}
			}
			mergeSort(left);
			mergeSort(right);

			merge(list, left, right);
		}

		return list;
	}

	public static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right) {
		int i = 0;

		while (left.size() > 0 || right.size() > 0) {
			while (left.size() > 0 && right.size() > 0) {
				if ((left.get(0)).compareTo(right.get(0)) < 0) {
					list.set(i, left.get(0)); 
					left.remove(0);
				} else {
					list.set(i, right.get(0)); 
					right.remove(0); 
				}
				i = i + 1;
			}
			if (right.size() == 0) { 
				list.set(i, left.get(0)); 
				left.remove(0);
				i++;
			} else if (left.size() == 0) { 
				list.set(i, right.get(0)); 
				right.remove(0);
				i++;
			}
		}
	}
}

package com.sample.designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdapterPatternTest {
	public static void main(String[] args) {
		int[] numbers = new int[] { 34, 2, 4, 12, 1 };
		Sorter sorter = new ArraySorter();
		numbers = sorter.sort(numbers);
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		List<Integer> intList = new ArrayList<>();
		intList.add(10);intList.add(5);intList.add(20);
		ListSorter listSorter = new SortListAdapter();
		intList = listSorter.sort(intList);
		intList.stream().forEach(System.out::println);
	}
}

interface Sorter {
	public int[] sort(int[] numbers);
}

class ArraySorter implements Sorter {
	@Override
	public int[] sort(int[] numbers) {
		Arrays.sort(numbers);
		return numbers;
	}
}

interface ListSorter {
	public List<Integer> sort(List<Integer> numbers);
}

class SortListAdapter implements ListSorter {
	@Override
	public List<Integer> sort(List<Integer> numbers) {
		// convert the List to a array
		int arrayInt[] = numbers.stream()
				.mapToInt(currentValue -> currentValue).toArray();
		ArraySorter arraySorter = new ArraySorter();
		arrayInt = arraySorter.sort(arrayInt);
		// convert the array to a List 
		numbers = IntStream.of(arrayInt).boxed().collect(Collectors.toList());
		return numbers;
	}
}

package stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo1 {
	
	public static <E> void main(String[] args) {
		
		//1.  use sorted
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
			
		//2.  ifPresent()
			Arrays.asList("a1", "a2", "a3")
		    .stream()
		    .findFirst()
		    .ifPresent(System.out::println);
			
			
			//3.  base number stream
			IntStream.range(1, 4)
		    .forEach(System.out::println);
			
			//4.  average()  sum()
			Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> 2 * n + 1)
		    .average()
		    .ifPresent(System.out::println);  // 5.0 
			
			int sum = Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> 2 * n + 1)
		    .sum();
			System.out.println(sum);
			
			OptionalDouble average = Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> 2 * n + 1)
		    .average();
			
			//5.  mapToObj
			IntStream.range(1, 4)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);

			// a1
			// a2
			// a3 
			
			Stream.of(1.0, 2.0, 3.0)
		    .mapToInt(Double::intValue)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);

			// a1
			// a2
			// a3 
			
			//6.  lazy property
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return true;
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
			
			//7.  垂直执行
			Stream.of("d2", "a2", "b1", "b3", "c")
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .anyMatch(s -> {
		        System.out.println("anyMatch: " + s);
		        return s.startsWith("A");
		    });

			// map:      d2
			// anyMatch: D2
			// map:      a2
			// anyMatch: A2 
			
			String string = new String();
			String string2 = new String();
			ArrayList<String> arrayList = new ArrayList<String>();
			System.out.println();
			
			
		    
	}
	
	
}

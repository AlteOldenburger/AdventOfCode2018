package it.macke.adventofcode2018.ex02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import it.macke.adventofcode2018.ex01.ResourceReader;

public class ChecksumCalculator
{
	public static void main(String[] args) throws IOException
	{
		var ids = ResourceReader
				.readResource("/it/macke/adventofcode2018/ex02/Input.txt")
				.toArray(new String[] {});
		System.out.println(new ChecksumCalculator().calculateChecksum(ids));
		// 4920
	}

	public Map<Character, Long> countOccurrences(String id)
	{
		return id.chars()
				.mapToObj(i -> Character.valueOf((char) i))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}

	public long countIdsWithDuplicateCharacters(String[] ids, long duplicateCount)
	{
		return Arrays.stream(ids)
				.filter(id -> countOccurrences(id).containsValue(duplicateCount))
				.count();
	}

	public long calculateChecksum(String[] ids)
	{
		return countIdsWithDuplicateCharacters(ids, 2)
				* countIdsWithDuplicateCharacters(ids, 3);
	}
}

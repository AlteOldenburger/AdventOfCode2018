package it.macke.adventofcode2018.ex03;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import it.macke.adventofcode2018.ex01.ResourceReader;

public class OverlapFinder
{
	public static void main(String[] args) throws IOException
	{
		var parser = new ClaimParser();
		var claims = ResourceReader
				.readResource("/it/macke/adventofcode2018/ex03/Input.txt")
				.stream()
				.map(line -> parser.parse(line))
				.collect(Collectors.toList());
		System.out.println(new OverlapFinder().find(claims).size());
		// 118322
	}

	public List<Cell> find(List<Claim> claims)
	{
		var cells = new HashMap<Cell, Integer>();
		claims.stream()
				.flatMap(c -> c.getCells().stream())
				.forEach(c -> {
					cells.computeIfPresent(c, (existingCell, currentCount) -> currentCount + 1);
					cells.computeIfAbsent(c, (nonExistingCell) -> 1);
				});
		return cells.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
	}
}

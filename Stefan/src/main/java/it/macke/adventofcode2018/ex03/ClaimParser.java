package it.macke.adventofcode2018.ex03;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ClaimParser
{
	public Claim parse(String line)
	{
		var pattern = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
		var matcher = pattern.matcher(line);
		if (!matcher.matches())
		{
			throw new IllegalArgumentException("Illegal claim definition: " + line);
		}
		return new Claim(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer
				.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
	}

	public List<Claim> parse(List<String> lines)
	{
		return lines.stream().map(this::parse).collect(Collectors.toList());
	}
}

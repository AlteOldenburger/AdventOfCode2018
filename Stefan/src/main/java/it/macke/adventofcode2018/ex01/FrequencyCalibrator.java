package it.macke.adventofcode2018.ex01;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FrequencyCalibrator
{
	public static void main(String[] args) throws IOException
	{
		var frequencyChanges = ResourceReader
				.readResource("/it/macke/adventofcode2018/ex01/Input.txt")
				.stream()
				.collect(Collectors.joining(", "));
		System.out.println(new FrequencyCalibrator().calibrate(frequencyChanges));
		// 442
	}

	public int calibrate(String frequencyChange)
	{
		return Arrays.stream(frequencyChange.split(","))
				.map(String::trim)
				.mapToInt(Integer::parseInt)
				.sum();
	}
}

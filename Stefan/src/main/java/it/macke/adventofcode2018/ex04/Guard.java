package it.macke.adventofcode2018.ex04;

import java.util.Arrays;

public class Guard
{
	private int id;
	private int[] asleepMinutes;

	public Guard(int id)
	{
		this.id = id;
		asleepMinutes = new int[60];
	}

	public int getId()
	{
		return id;
	}

	public int getTotalSleepTime()
	{
		return Arrays.stream(asleepMinutes)
				.sum();
	}

	public Guard sleep(int from, int until)
	{
		for (var i = from; i <= until; i++)
		{
			asleepMinutes[i]++;
		}
		return this;
	}

	public int getMostAsleepMinute()
	{
		var max = asleepMinutes[0];
		var maxMinute = 0;
		for (var i = 1; i < asleepMinutes.length; i++)
		{
			if (asleepMinutes[i] > max)
			{
				max = asleepMinutes[i];
				maxMinute = i;
			}
		}
		return maxMinute;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + getTotalSleepTime();
		result = prime * result + getMostAsleepMinute();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Guard other = (Guard) obj;
		if (id != other.id)
		{
			return false;
		}
		if (getTotalSleepTime() != other.getTotalSleepTime())
		{
			return false;
		}
		if (getMostAsleepMinute() != other.getMostAsleepMinute())
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Guard [id=" + id + ", totalSleepTime=" + getTotalSleepTime() + ", mostAsleepMinute="
				+ getMostAsleepMinute()
				+ "]";
	}
}

package it.macke.adventofcode2018.ex04;

import java.time.LocalDate;

public class SleepLogEntry
{
	public static class Builder
	{
		private LocalDate date;
		private int guardId;
		private int asleepFrom;
		private int asleepUntil;

		public boolean isValid()
		{
			return date != null
					&& guardId != 0
					&& asleepUntil > asleepFrom;
		}

		public Builder withDate(LocalDate date)
		{
			this.date = date;
			return this;
		}

		public Builder withGuardId(int guardId)
		{
			this.guardId = guardId;
			return this;
		}

		public Builder withAsleepFrom(int asleepFrom)
		{
			this.asleepFrom = asleepFrom;
			return this;
		}

		public Builder withAsleepUntil(int asleepUntil)
		{
			this.asleepUntil = asleepUntil;
			return this;
		}

		public SleepLogEntry build()
		{
			return new SleepLogEntry(date, guardId, asleepFrom, asleepUntil);
		}
	}

	private LocalDate date;
	private int guardId;
	private int asleepFrom;
	private int asleepUntil;

	public SleepLogEntry(LocalDate date, int guardId, int asleepFrom, int asleepUntil)
	{
		this.date = date;
		this.guardId = guardId;
		this.asleepFrom = asleepFrom;
		this.asleepUntil = asleepUntil;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public int getGuardId()
	{
		return guardId;
	}

	public int getAsleepFrom()
	{
		return asleepFrom;
	}

	public int getAsleepUntil()
	{
		return asleepUntil;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + asleepFrom;
		result = prime * result + asleepUntil;
		result = prime * result + (date == null ? 0 : date.hashCode());
		result = prime * result + guardId;
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
		SleepLogEntry other = (SleepLogEntry) obj;
		if (asleepFrom != other.asleepFrom)
		{
			return false;
		}
		if (asleepUntil != other.asleepUntil)
		{
			return false;
		}
		if (date == null)
		{
			if (other.date != null)
			{
				return false;
			}
		}
		else
			if (!date.equals(other.date))
			{
				return false;
			}
		if (guardId != other.guardId)
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "SleepLogEntry [date=" + date + ", guardId=" + guardId + ", asleepFrom=" + asleepFrom + ", asleepUntil="
				+ asleepUntil + "]";
	}
}

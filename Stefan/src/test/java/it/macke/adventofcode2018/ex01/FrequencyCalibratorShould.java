package it.macke.adventofcode2018.ex01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrequencyCalibratorShould
{
	private void assertCalibratedFrequencyEquals(String frequencyChanges, int expectedFrequency)
	{
		assertThat(new FrequencyCalibrator().calibrate(frequencyChanges))
				.isEqualTo(expectedFrequency);
	}

	@Test
	@DisplayName("recalibrate from single frequency change")
	public void recalibrateFromSingleFrequencyChange()
	{
		assertCalibratedFrequencyEquals("+1", 1);
	}

	@Test
	@DisplayName("recalibrate from two frequency changes")
	public void recalibrateFromTwoFrequencyChanges()
	{
		assertCalibratedFrequencyEquals("+1, -2", -1);
	}

	@Test
	@DisplayName("recalibrate from multiple frequency changes")
	public void recalibrateFromMultipleFrequencyChanges()
	{
		assertCalibratedFrequencyEquals("+1, -2, +3, +1", 3);
	}

	@Test
	@DisplayName("recalibrate from given examples")
	public void recalibrateFromGivenExamples()
	{
		assertCalibratedFrequencyEquals("+1, +1, +1", 3);
		assertCalibratedFrequencyEquals("+1, +1, -2", 0);
		assertCalibratedFrequencyEquals("-1, -2, -3", -6);
	}
}

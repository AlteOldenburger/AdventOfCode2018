package it.macke.adventofcode2018.ex02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChecksumCalculatorShould
{
	private void assertIdContainsCharacter(String id, char character, long occurrence)
	{
		assertThat(new ChecksumCalculator().countOccurrences(id))
				.containsEntry(character, occurrence);
	}

	private void assertIdsContainDuplicateCharacters(String[] ids, int duplicateCount, int expectedIdCount)
	{
		assertThat(new ChecksumCalculator().countIdsWithDuplicateCharacters(ids, duplicateCount))
				.isEqualTo(expectedIdCount);
	}

	@Test
	@DisplayName("count occurrences of characters")
	public void countOccurrencesOfCharacters()
	{
		assertIdContainsCharacter("abcdef", 'a', 1);
		assertIdContainsCharacter("abcdef", 'f', 1);

		assertIdContainsCharacter("bababc", 'a', 2);
		assertIdContainsCharacter("bababc", 'b', 3);

		assertIdContainsCharacter("abcdee", 'e', 2);
	}

	@Test
	@DisplayName("count ids that contain characters multiple times")
	public void countIdsThatContainCharactersMultipleTimes()
	{
		assertIdsContainDuplicateCharacters(new String[] { "abcdef" }, 2, 0);

		assertIdsContainDuplicateCharacters(new String[] { "bababc" }, 2, 1);
		assertIdsContainDuplicateCharacters(new String[] { "bababc" }, 3, 1);

		assertIdsContainDuplicateCharacters(new String[] { "bababc", "abbcde" }, 2, 2);
		assertIdsContainDuplicateCharacters(new String[] { "bababc", "abbcde" }, 3, 1);
	}

	@Test
	@DisplayName("calculate checksum of ids containing multiple characters")
	public void calculateChecksum()
	{
		assertThat(new ChecksumCalculator().calculateChecksum(new String[] { "bababc", "abbcde" }))
				.isEqualTo(2);
		assertThat(new ChecksumCalculator().calculateChecksum(new String[] {
				"abcdef",
				"bababc",
				"abbcde",
				"abcccd",
				"aabcdd",
				"abcdee",
				"ababab"
		})).isEqualTo(12);
	}
}

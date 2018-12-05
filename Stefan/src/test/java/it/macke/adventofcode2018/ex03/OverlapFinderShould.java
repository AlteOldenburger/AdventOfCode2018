package it.macke.adventofcode2018.ex03;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OverlapFinderShould
{
	@Test
	@DisplayName("find no overlaps if claims don't overlap")
	public void findNoOverlapsForAdjacentClaims()
	{
		var overlaps = new OverlapFinder().find(List.of(new Claim(1, 0, 0, 1, 1), new Claim(2, 3, 3, 1, 1)));
		assertThat(overlaps.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("find overlaps if claims overlap")
	public void findOverlapsForOverlappingClaims()
	{
		var overlaps = new OverlapFinder().find(List.of(
				new Claim(1, 1, 3, 4, 4),
				new Claim(2, 3, 1, 4, 4),
				new Claim(3, 5, 5, 2, 2)));
		assertThat(overlaps.size()).isEqualTo(4);
		assertThat(overlaps).contains(new Cell(3, 3));
		assertThat(overlaps).contains(new Cell(3, 4));
		assertThat(overlaps).contains(new Cell(4, 3));
		assertThat(overlaps).contains(new Cell(4, 4));
	}
}

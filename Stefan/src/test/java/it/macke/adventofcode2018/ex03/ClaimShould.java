package it.macke.adventofcode2018.ex03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClaimShould
{
	@Test
	@DisplayName("know its cells")
	public void knowItsCells()
	{
		var claim = new Claim(1, 0, 0, 1, 1);
		assertThat(claim.getCells().size()).isEqualTo(1);
		assertThat(claim.getCells()).contains(new Cell(0, 0));

		claim = new Claim(123, 3, 2, 5, 4);
		assertThat(claim.getCells().size()).isEqualTo(20);
		for (var column = 3; column <= 7; column++)
		{
			for (var row = 2; row <= 5; row++)
			{
				assertThat(claim.getCells()).contains(new Cell(column, row));
			}
		}
	}
}

package it.macke.adventofcode2018.ex03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClaimParserShould
{
	@Test
	@DisplayName("parse example claim")
	public void parseClaims()
	{
		var claim = new ClaimParser().parse("#123 @ 3,2: 5x4");
		assertThat(claim.getId()).isEqualTo(123);
		assertThat(claim.getLeftColumn()).isEqualTo(3);
		assertThat(claim.getTopRow()).isEqualTo(2);
		assertThat(claim.getWidth()).isEqualTo(5);
		assertThat(claim.getHeight()).isEqualTo(4);
	}

	@Test
	@DisplayName("throw exception for invalid claim definition")
	public void throwExceptionForInvalidClaimDefinition()
	{
		var e = assertThrows(IllegalArgumentException.class,
				() -> new ClaimParser().parse("#12x3 @ 3:2: 5x4"));
		assertThat(e.getMessage()).contains("#12x3 @ 3:2: 5x4");
	}

	@Test
	@DisplayName("parse multiple claims")
	public void parseMultipleClaims()
	{
		var claims = new ClaimParser().parse(
				List.of("#123 @ 3,2: 5x4", "#124 @ 1,1: 7x10", "#1234567 @ 8,2: 100x4"));
		assertThat(claims.size()).isEqualTo(3);
		assertThat(claims).contains(new Claim(123, 3, 2, 5, 4));
		assertThat(claims).contains(new Claim(124, 1, 1, 7, 10));
		assertThat(claims).contains(new Claim(1234567, 8, 2, 100, 4));
	}
}

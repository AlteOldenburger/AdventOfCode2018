package test.java.adventofcode2018.tag12;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.adventofcode2018.tag12.PflanzenAusbreitungHellseher;

class PflanzenAusbreitungHellseherSollte
{
	private PflanzenAusbreitungHellseher sut;

	@BeforeEach
	void setUp()
	{
		sut = new PflanzenAusbreitungHellseher();
	}

	@DisplayName("eine Generation in die Zukunft sehen können")
	@Test
	void test01()
	{
		final String pflanzentopfSaat = "#..#.#..##......###...###";
		final String erwartet = "...#...#....#.....#..#..#..#...";

		final String ergebnis = sut.prophezeieDieNaechsteGeneration(pflanzentopfSaat);

		assertThat(ergebnis, is(erwartet));
	}

}

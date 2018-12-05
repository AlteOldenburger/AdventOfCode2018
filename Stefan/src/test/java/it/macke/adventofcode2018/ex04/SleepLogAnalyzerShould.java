package it.macke.adventofcode2018.ex04;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SleepLogAnalyzerShould
{
	@Test
	@DisplayName("find guards with longest sleep time")
	public void findGuardWithLongestSleepTime()
	{
		var entry1 = new SleepLogEntry(LocalDate.of(1518, 11, 1), 10, 1, 10);
		var entry2 = new SleepLogEntry(LocalDate.of(1518, 11, 2), 10, 11, 20);
		var entry3 = new SleepLogEntry(LocalDate.of(1518, 11, 3), 11, 1, 10);
		var entry4 = new SleepLogEntry(LocalDate.of(1518, 11, 4), 12, 1, 29);
		var entry5 = new SleepLogEntry(LocalDate.of(1518, 11, 5), 12, 29, 30);

		var guard = new SleepLogAnalyzer().analyze(List.of(entry1));
		assertThat(guard.getId()).isEqualTo(10);
		assertThat(guard.getTotalSleepTime()).isEqualTo(10);
		assertThat(guard.getMostAsleepMinute()).isEqualTo(1);

		guard = new SleepLogAnalyzer().analyze(List.of(entry1, entry2));
		assertThat(guard.getId()).isEqualTo(10);
		assertThat(guard.getTotalSleepTime()).isEqualTo(20);
		assertThat(guard.getMostAsleepMinute()).isEqualTo(1);

		guard = new SleepLogAnalyzer().analyze(List.of(entry1, entry2, entry3));
		assertThat(guard.getId()).isEqualTo(10);
		assertThat(guard.getTotalSleepTime()).isEqualTo(20);
		assertThat(guard.getMostAsleepMinute()).isEqualTo(1);

		guard = new SleepLogAnalyzer().analyze(List.of(entry1, entry2, entry3, entry4));
		assertThat(guard.getId()).isEqualTo(12);
		assertThat(guard.getTotalSleepTime()).isEqualTo(29);
		assertThat(guard.getMostAsleepMinute()).isEqualTo(1);

		guard = new SleepLogAnalyzer().analyze(List.of(entry1, entry2, entry3, entry4, entry5));
		assertThat(guard.getId()).isEqualTo(12);
		assertThat(guard.getTotalSleepTime()).isEqualTo(31);
		assertThat(guard.getMostAsleepMinute()).isEqualTo(29);
	}

	@Test
	@DisplayName("solve example")
	public void solveExample()
	{
		var log = new SleepLogParser().parse(List.of(
				"[1518-11-01 00:00] Guard #10 begins shift",
				"[1518-11-04 00:46] wakes up",
				"[1518-11-04 00:36] falls asleep",
				"[1518-11-01 23:58] Guard #99 begins shift",
				"[1518-11-01 00:25] wakes up",
				"[1518-11-05 00:55] wakes up",
				"[1518-11-01 00:55] wakes up",
				"[1518-11-02 00:50] wakes up",
				"[1518-11-03 00:05] Guard #10 begins shift",
				"[1518-11-03 00:24] falls asleep",
				"[1518-11-03 00:29] wakes up",
				"[1518-11-04 00:02] Guard #99 begins shift",
				"[1518-11-01 00:30] falls asleep",
				"[1518-11-05 00:03] Guard #99 begins shift",
				"[1518-11-01 00:05] falls asleep",
				"[1518-11-02 00:40] falls asleep",
				"[1518-11-05 00:45] falls asleep"));

		var guard = new SleepLogAnalyzer().analyze(log);
		assertThat(guard.getId()).isEqualTo(10);
		assertThat(guard.getTotalSleepTime()).isEqualTo(50);
		assertThat(guard.getMostAsleepMinute()).isEqualTo(24);
	}
}

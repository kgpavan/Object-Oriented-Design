//package com.github.javadojo;
//
//import static MarsRover.LINE_SEPARATOR;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
//import MarsRover;
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.assertThat;
//
//public class MarsRoverTest {
//
//	@Test
//	public void driveEast() {
//		assertThat(new MarsRover("s").path(), equalTo("X*" + LINE_SEPARATOR));
//	}
//
//	@Test
//	@Ignore
//	public void driveEastForABitLonger() {
//		assertThat(new MarsRover("ssss").path(), equalTo("X---*"
//				+ LINE_SEPARATOR));
//	}
//
//	@Test
//	@Ignore
//	public void driveNorth() {
//		String expectedPath = new StringBuilder().append("*")
//				.append(LINE_SEPARATOR).append("|").append(LINE_SEPARATOR)
//				.append("|").append(LINE_SEPARATOR).append("X")
//				.append(LINE_SEPARATOR).toString();
//		System.out.println(expectedPath);
//		assertThat(new MarsRover("lsss").path(), equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void driveEstThanTurnLeft() {
//		String expectedPath = new StringBuilder().append("    *")
//				.append(LINE_SEPARATOR).append("    |").append(LINE_SEPARATOR)
//				.append("    |").append(LINE_SEPARATOR).append("    |")
//				.append(LINE_SEPARATOR).append("X---+").append(LINE_SEPARATOR)
//				.toString();
//		System.out.println(expectedPath);
//		assertThat(new MarsRover("sssslssss").path(), equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void driveNorthAfterInitialProgrammingToTheEast() {
//		MarsRover rover = new MarsRover("ssss").turnLeft().moveForward()
//				.moveForward();
//		String expectedPath = new StringBuilder().append("    *")
//				.append(LINE_SEPARATOR).append("    |").append(LINE_SEPARATOR)
//				.append("X---+").append(LINE_SEPARATOR).toString();
//		assertThat(rover.path(), equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void driveEastThanTakeSampleThanDriveABitMore() {
//		assertThat(new MarsRover("sssSsss").path(), equalTo("X--S--*"
//				+ LINE_SEPARATOR));
//	}
//
//	@Test
//	@Ignore
//	public void turnRightTwoTimes() {
//		MarsRover marsRover = new MarsRover("sssrsss").turnRight()
//				.moveForward().moveForward().moveForward();
//		String expectedPath = new StringBuilder().append("X--+")
//				.append(LINE_SEPARATOR).append("   |").append(LINE_SEPARATOR)
//				.append("   |").append(LINE_SEPARATOR).append("*--+")
//				.append(LINE_SEPARATOR).toString();
//
//		assertThat(marsRover.path(), equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void pathOverlapsAreMarkedWithRightCursor() {
//		MarsRover marsRover = new MarsRover("ssssssrsss").turnRight()
//				.moveForward().moveForward().moveForward().turnRight()
//				.moveForward().moveForward().moveForward().moveForward();
//
//		String expectedPath = new StringBuilder().append("   *   ")
//				.append(LINE_SEPARATOR).append("X--+--+")
//				.append(LINE_SEPARATOR).append("   |  |")
//				.append(LINE_SEPARATOR).append("   |  |")
//				.append(LINE_SEPARATOR).append("   +--+")
//				.append(LINE_SEPARATOR).toString();
//
//		assertThat(marsRover.path(), equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void samplePointIsNotOverridenOnSecondPass() {
//		String expectedPath = new StringBuilder().append("   *   ")
//				.append(LINE_SEPARATOR).append("X--S--+")
//				.append(LINE_SEPARATOR).append("   |  |")
//				.append(LINE_SEPARATOR).append("   |  |")
//				.append(LINE_SEPARATOR).append("   +--+")
//				.append(LINE_SEPARATOR).toString();
//
//		assertThat(new MarsRover("sssSsssrsssrsssrssss").path(),
//				equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void samplePointIsOverridenByCurrentPosition() {
//		String expectedPath = new StringBuilder().append("X--*--+")
//				.append(LINE_SEPARATOR).append("   |  |")
//				.append(LINE_SEPARATOR).append("   |  |")
//				.append(LINE_SEPARATOR).append("   +--+")
//				.append(LINE_SEPARATOR).toString();
//
//		assertThat(new MarsRover("sssSsssrsssrsssrsss").path(),
//				equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void startPointIsNotOverridenOnSecondPass() {
//		String expectedPath = new StringBuilder().append("*   ")
//				.append(LINE_SEPARATOR).append("X--+").append(LINE_SEPARATOR)
//				.append("|  |").append(LINE_SEPARATOR).append("|  |")
//				.append(LINE_SEPARATOR).append("+--+").append(LINE_SEPARATOR)
//				.toString();
//
//		assertThat(new MarsRover("sssrsssrsssrssss").path(),
//				equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void startPointIsOverridenByCurrentPosition() {
//		String expectedPath = new StringBuilder().append("*--+")
//				.append(LINE_SEPARATOR).append("|  |").append(LINE_SEPARATOR)
//				.append("|  |").append(LINE_SEPARATOR).append("+--+")
//				.append(LINE_SEPARATOR).toString();
//
//		assertThat(new MarsRover("sssrsssrsssrsss").path(),
//				equalTo(expectedPath));
//	}
//
//	@Test
//	@Ignore
//	public void intermediatePathCanBeSent() {
//		MarsRover marsRover = new MarsRover("sss");
//		String intermadiatePath = marsRover.path();
//
//		marsRover.moveForward().moveForward();
//		String finalPath = marsRover.path();
//
//		assertThat(intermadiatePath, equalTo("X--*" + LINE_SEPARATOR));
//		assertThat(finalPath, equalTo("X----*" + LINE_SEPARATOR));
//	}
//}

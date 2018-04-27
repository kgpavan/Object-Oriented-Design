//package pingpong;
//
//
//import org.junit.Test;
//
//import com.nespresso.exercices.pingpong.PingPong;
//
//import static org.junit.Assert.assertEquals;
//
//
///**
// * These two table-tennis players, called "I" and "O", always play on progressively longer tables.
// * The first match they play on a zero-length table, the second match is played on a two meters table.
// * Every match is played on a table two meters longer than the previous one.
// */
//public class PingPongTest {
//
//    @Test
//    public void playPingPongOnce() {
//        PingPong pingPong = new PingPong(1);
//        assertEquals("IO",pingPong.print());
//    }
//    @Test
//    public void playPingPongTwice() {
//        PingPong pingPong = new PingPong(2);
//        assertEquals("IOI..O",pingPong.print());
//    }
//
//    @Test
//    public void playPingPongThreeTimes() {
//        PingPong pingPong = new PingPong(3);
//        assertEquals("IOI..OI....O",pingPong.print());
//    }
//    @Test
//    public void playPingPongFourTimes() {
//        PingPong pingPong = new PingPong(4);
//        assertEquals("IOI..OI....OI......O",pingPong.print());
//    }
//}
//

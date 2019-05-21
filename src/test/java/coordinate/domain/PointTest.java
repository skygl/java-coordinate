package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void 좌표_값에_최솟값보다_작은_값이_들어올경우_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Point(0, 1));
    }

    @Test
    void 좌표_값에_최댓값보다_큰_값이_들어올경우_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Point(25, 24));
    }

    @Test
    void x좌표_사이의_거리를_구하는지_테스트() {
        Point point = new Point(5, 5);
        assertThat(point.getDeltaXTo(new Point(10, 5))).isEqualTo(5);
    }

    @Test
    void y좌표_사이의_거리를_구하는지_테스트() {
        Point point = new Point(5, 5);
        assertThat(point.getDeltaYTo(new Point(5, 10))).isEqualTo(5);
    }
}

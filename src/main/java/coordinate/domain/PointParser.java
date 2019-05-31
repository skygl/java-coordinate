package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointParser {
    private static final String POINT_SEPARATOR = "-";
    private static final String COORDINATE_SEPARATOR = ",";
    private static final String FRONT_COORDINATE_WRAPPER = "(";
    private static final String BACK_COORDINATE_WRAPPER = ")";
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;
    private static final int NUM_OF_2D_COORDINATES = 2;

    public static List<Point> parse(String rawInput) {
        List<Point> points = new ArrayList<>();
        String[] tuples = rawInput.split(POINT_SEPARATOR);
        for (String tuple : tuples) {
            validateBetweenBrackets(tuple);
            List<Integer> coordinates = new ArrayList<>(splitToCoordinates(tuple));
            validateSizeOf(coordinates);
            points.add(new Point(coordinates.get(X_INDEX), coordinates.get(Y_INDEX)));
        }
        return points;
    }

    private static List<Integer> splitToCoordinates(String tuple) {
        return Arrays.stream(stripBrackets(tuple).split(COORDINATE_SEPARATOR))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String stripBrackets(String tuple) {
        return tuple.substring(tuple.indexOf(FRONT_COORDINATE_WRAPPER) + FRONT_COORDINATE_WRAPPER.length(), tuple.lastIndexOf(BACK_COORDINATE_WRAPPER));
    }

    private static void validateBetweenBrackets(String tuple) {
        if (!tuple.startsWith(FRONT_COORDINATE_WRAPPER) || !tuple.endsWith(BACK_COORDINATE_WRAPPER)) {
            throw new IllegalArgumentException("좌표들은 소괄호로 둘러 쌓여 있어야 합니다.");
        }
    }

    private static void validateSizeOf(List<Integer> coordinates) {
        if (coordinates.size() != NUM_OF_2D_COORDINATES) {
            throw new IllegalArgumentException("좌표점을 두개 입력해야 합니다");
        }
    }
}
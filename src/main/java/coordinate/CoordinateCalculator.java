package coordinate;

import coordinate.domain.AttributeType;
import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.PointParser;
import coordinate.ui.CartesianPlane;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateCalculator {
    public static void main(String[] args) {
        Figure figure = getFigure();

        CartesianPlane plane = new CartesianPlane();
        plane.drawPoints(figure);
        OutputView.printGraph(plane);

        OutputView.printAttributeOf(figure);
    }

    private static Figure getFigure() {
        try {
            return AttributeType.getFigureOf(getPoints());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            return getFigure();
        }
    }

    private static List<Point> getPoints() {
        String rawInput = InputView.inputPoints();
        return PointParser.parse(rawInput);
    }
}
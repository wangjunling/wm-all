package site.wmblog.mapper.query;

import java.util.Locale;

/**
 * Created by tiantiea on 15/6/9.
 */
public class Sort {

    private Direction direction;

    private String property;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = Direction.fromString(direction);
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public static enum Direction {

        ASC, DESC;
        public static Direction fromString(String value) {
            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                return ASC;
            }
        }
    }

}

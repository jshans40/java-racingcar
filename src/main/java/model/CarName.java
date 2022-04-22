package model;

public class CarName {
    private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
    private static final String CAR_NAME_MAXIMUM_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";
    private static final String EMPTY_CAR_NAME = "자동차의 이름은 공백일 수 없습니다.";

    private String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalStateException(EMPTY_CAR_NAME);
        }

        if (validateCarMaximumLength(name)) {
            throw new IllegalStateException(CAR_NAME_MAXIMUM_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean validateCarMaximumLength(String name) {
        return name.length() > MAXIMUM_LENGTH_OF_CAR_NAME;
    }

    public String getName() {
        return name;
    }
}

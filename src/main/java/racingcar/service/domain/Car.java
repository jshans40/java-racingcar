package racingcar.service.domain;

import racingcar.service.strategy.RoundRule;
import racingcar.service.value.CarName;
import racingcar.service.value.Position;
import racingcar.utils.Preconditions;

import java.util.Objects;

public class Car implements Cloneable {
    private final CarName carName;
    private Position position;

    public Car(String carName) {
        this(CarName.from(carName), Position.init());
    }

    public Car(CarName carName, Position position) {
        Preconditions.checkNotNull(carName, "name은 필수값입니다.");
        Preconditions.checkNotNull(position, "position는 필수값입니다.");

        this.carName = carName;
        this.position = position;
    }

    public void startRace(RoundRule roundRule) {
        if (roundRule.checkCondition()) {
            position = position.increasePosition();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.isGreaterThan(maxPosition)) {
            return position;
        }

        return maxPosition;
    }

    public Position getCurrentPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }

    @Override
    public Car clone() {
        return new Car(carName, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
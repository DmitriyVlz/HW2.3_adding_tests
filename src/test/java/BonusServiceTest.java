import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BonusServiceTest {

    // 1. проверяем значение bonus, клиент зарегистрирован
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    // 2. Проверяем bonus= limit, клиент зарегистрирован
    @Test

    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    // 3. проверяем значение bonus, но клиент не зарегистрирван

    @Test
    void shouldCalculateForUnregistredUser() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_60;

        boolean registered = false;

        long expected = 10;

        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    //4. проверка нижней границы amount
    @Test

    void shouidCalculateForUnderRegisterBonus() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}



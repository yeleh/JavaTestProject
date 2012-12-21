package enumTest;

import java.util.concurrent.TimeUnit;

/**
 * User: Alex
 * Date: 16.12.12
 * Time: 10:47
 */
public class EnumTestClass {

    public static long timeInMilliseconds(long warteZeit, TimeUnit timeUnit) {
        return timeUnit.toMillis(warteZeit);
    }

    public static void main(String[] args) {
        timeInMilliseconds(1L, TimeUnit.MINUTES);
    }
}

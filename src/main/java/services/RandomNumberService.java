package services;

import java.util.Random;

public class RandomNumberService {
    private final Random random = new Random();

    public int getRandomNumber(int maxValueRandomNumber) {
        return random.nextInt(maxValueRandomNumber);
    }
}

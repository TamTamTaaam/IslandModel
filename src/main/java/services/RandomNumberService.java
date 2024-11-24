package services;

import java.util.Random;

public class RandomNumberService {
    private final Random random = new Random();

    public Integer getRandomNumber(int maxValueRandomNumber) {
        if(maxValueRandomNumber>0) {
            return random.nextInt(maxValueRandomNumber);
        } else {
            return null;
        }
    }
}

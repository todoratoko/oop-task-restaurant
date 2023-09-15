package util;

import java.util.Random;

public abstract class Helper {
    public static int getRandom(int min, int max){
        return new Random().nextInt(min, max+1);
    }
    public static int getRandom(int max){
        return new Random().nextInt(max+1);
    }
}

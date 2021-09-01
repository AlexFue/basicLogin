package com.example.basiclogin;

import android.widget.EditText;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public void mulitplication() {
        Random random = new Random();
        int y = random.nextInt(1000);
        int x = random.nextInt(1000);

        assertEquals(x*y, Util.multiply(x,y));
    }
}
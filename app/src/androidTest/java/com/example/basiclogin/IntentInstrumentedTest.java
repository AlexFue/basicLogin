package com.example.basiclogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class IntentInstrumentedTest {

    @Test
    public void testFactoryMethodIntent() {
        Context appContext = getInstrumentation().getTargetContext();
        Bundle bun = new Bundle();
        bun.putString("username", "alex");
        bun.putString("password", "123");
        bun.putString("id", "1");
        Intent intent = MainActivity.getIntent(appContext, bun); ///appcontext is what activity currently on, 5 is the userid. function returns an nitent
        assertEquals("1", intent.getBundleExtra("SECOND_ACTIVITY_COM_EXAMPLE").getString("id"));
    }
}

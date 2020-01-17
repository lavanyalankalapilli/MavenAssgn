package com.zemoso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    @Test
    public void profileTest() {
        App app = new App();
        Map<String, String> prop = app.getPropValues();
        String env = System.getProperty("env");
        assertEquals(prop,getExpectedPropMap(env));
    }

    public Map<String, String> getExpectedPropMap(String env) {
        Map<String, String> expectedProp = new HashMap<>();
        switch (env) {
            case "dev":
                expectedProp.put("user", "dev1");
                expectedProp.put("env", "dev");
                expectedProp.put("ip", "10.1.0.4");
                break;
            case "test":
                expectedProp.put("user", "test-user");
                expectedProp.put("env", "test");
                expectedProp.put("ip", "10.1.0.6");
                break;
            case "prod":
                expectedProp.put("user", "admin");
                expectedProp.put("env", "prod");
                expectedProp.put("ip", "192.168.45.78");
                break;
        }
        return expectedProp;
    }
}

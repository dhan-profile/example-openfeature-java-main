package com.hello_togglebot;

import com.devcycle.sdk.server.local.api.DevCycleLocalClient;
import com.devcycle.sdk.server.local.model.DevCycleLocalOptions;

import dev.openfeature.sdk.MutableContext;
import dev.openfeature.sdk.Structure;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import com.devcycle.sdk.server.common.model.DevCycleUser;
import com.devcycle.sdk.server.common.model.Feature;
import com.devcycle.sdk.server.common.model.BaseVariable;
import com.devcycle.sdk.server.common.model.DevCycleEvent;

public class MyClass {

    private DevCycleLocalClient client;

    public MyClass() {
        DevCycleLocalOptions options = DevCycleLocalOptions.builder()
            // Insert Options
            .build();
        DevCycleUser user = DevCycleUser.builder()
                .userId("a_user_id")
                .country("US")
                .build();

        Boolean variableValue = client.variableValue(user, "super_cool_feature", true);
        if (variableValue.booleanValue()) {
            // New Feature code here
        } else {
            // Old code here
        }
        
        Map<String, BaseVariable> variables = client.allVariables(user);
        Map<String, Feature> features = client.allFeatures(user);
        
        DevCycleEvent event = DevCycleEvent.builder()
                .date(Instant.now().toEpochMilli())
                .target("test target")
                .type("test event")
                .value(new BigDecimal(600))
                .build();

        client.track(user, event);
        
        MutableContext context = new MutableContext("test-1234");
        context.add("email", "email@devcycle.com");
        context.add("name", "name");
        context.add("country", "CA");
        context.add("language", "en");
        context.add("appVersion", "1.0.11");
        context.add("appBuild", 1000);

        Map<String,Object> customData = new LinkedHashMap<>();
        customData.put("custom", "value");
        context.add("customData", Structure.mapToStructure(customData));

        Map<String,Object> privateCustomData = new LinkedHashMap<>();
        privateCustomData.put("private", "data");
        context.add("privateCustomData", Structure.mapToStructure(privateCustomData));
        
        
        
        client = new DevCycleLocalClient(System.getenv("DEVCYCLE_SERVER_SDK_KEY"), options);
    }
}

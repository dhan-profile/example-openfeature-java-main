package com.hello_togglebot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.devcycle.sdk.server.local.api.DevCycleLocalClient;
import com.devcycle.sdk.server.local.model.DevCycleLocalOptions;

import dev.openfeature.sdk.*;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
        // Initialize DevCycle Client
        DevCycleLocalOptions options = DevCycleLocalOptions.builder().build();
        DevCycleLocalClient devCycleClient = new DevCycleLocalClient(System.getenv("DEVCYCLE_SERVER_SDK_KEY"), options);

        // Set the provider into the OpenFeature API
        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(devCycleClient.getOpenFeatureProvider());

        // Get the OpenFeature client
        Client openFeatureClient = api.getClient();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// Start logging the variation to the console once the DevCycle client has initialized
			DevCycleWithOpenFeatureClient ofDVCClient = DevCycleWithOpenFeatureClient.getInstance();
			DevCycleLocalClient devcycleClient = ofDVCClient.getDevCycleClient();

			while (!devcycleClient.isInitialized()) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println("Interrupted while waiting for DevCycle client to initialize");
				}
			}
			new VariationLogger().start();
		};
	}

}

package com.devsda.hack.alterego;

import com.codahale.metrics.MetricRegistry;
import com.devsda.hack.alterego.application.AlteregoApplication;
import com.devsda.hack.alterego.loader.YamlLoader;
import com.devsda.hack.alterego.model.AlteregoConfiguration;
import com.google.inject.Injector;
import io.dropwizard.setup.Environment;

import java.io.IOException;

public class ApplicationContextUtil {

    public static Injector createApplicationInjector() throws IOException {
            AlteregoApplication alteregoApplication = new AlteregoApplication();

        AlteregoConfiguration alteregoConfiguration = YamlLoader.load("configurations/dev.yaml", AlteregoConfiguration.class);
        Environment environment = new Environment("Alterego", null, null, new MetricRegistry(), null);

        return alteregoApplication.createInjector(alteregoConfiguration, environment);
    }
}

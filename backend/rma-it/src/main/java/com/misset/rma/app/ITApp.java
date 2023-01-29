package com.misset.rma.app;

import com.misset.rma.RmaApplication;
import com.misset.rma.it.data.ITDataLoader;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper app that will load the RMA with IT test data made available
 */
@Component
@EnableAutoConfiguration
public class ITApp extends RmaApplication implements ApplicationListener<ContextRefreshedEvent> {

    private static final List<ITDataLoader> dataLoaders = new ArrayList<>();

    public static void registerStartup(ITDataLoader runnable) {
        dataLoaders.add(runnable);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        dataLoaders.forEach(ITDataLoader::load);
    }
}

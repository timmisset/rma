package com.misset.rma.it.data;

import com.misset.rma.app.ITApp;

public abstract class ITDataLoader {

    protected ITDataLoader() {
        ITApp.registerStartup(this);
    }

    /**
     * Load the IT dataset
     */
    public abstract void load();
}

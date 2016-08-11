package com.samsung.mno.t_mobile;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DataCollectionInitializer extends Service {
    public DataCollectionInitializer() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

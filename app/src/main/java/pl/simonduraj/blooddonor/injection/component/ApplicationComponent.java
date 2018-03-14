package pl.simonduraj.blooddonor.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pl.simonduraj.blooddonor.data.DataManager;
import pl.simonduraj.blooddonor.data.SyncService;
import pl.simonduraj.blooddonor.data.local.DatabaseHelper;
import pl.simonduraj.blooddonor.data.local.PreferencesHelper;
import pl.simonduraj.blooddonor.data.remote.RibotsService;
import pl.simonduraj.blooddonor.injection.ApplicationContext;
import pl.simonduraj.blooddonor.injection.module.ApplicationModule;
import pl.simonduraj.blooddonor.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}

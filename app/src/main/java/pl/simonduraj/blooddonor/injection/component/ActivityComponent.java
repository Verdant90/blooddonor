package pl.simonduraj.blooddonor.injection.component;

import dagger.Subcomponent;
import pl.simonduraj.blooddonor.injection.PerActivity;
import pl.simonduraj.blooddonor.injection.module.ActivityModule;
import pl.simonduraj.blooddonor.ui.main.MainActivity;
import pl.simonduraj.blooddonor.ui.signin.SignInActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(SignInActivity signInActivity);

}

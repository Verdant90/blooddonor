package pl.simonduraj.blooddonor.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import pl.simonduraj.blooddonor.injection.component.ApplicationComponent;
import pl.simonduraj.blooddonor.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}

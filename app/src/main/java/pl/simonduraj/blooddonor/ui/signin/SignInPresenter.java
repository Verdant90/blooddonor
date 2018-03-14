package pl.simonduraj.blooddonor.ui.signin;

import javax.inject.Inject;

import pl.simonduraj.blooddonor.data.DataManager;
import pl.simonduraj.blooddonor.injection.ConfigPersistent;
import pl.simonduraj.blooddonor.ui.base.BasePresenter;

@ConfigPersistent
public class SignInPresenter extends BasePresenter<SignInMvpView> {

    private final DataManager mDataManager;
    @Inject
    public SignInPresenter(final DataManager dataManager) {
        mDataManager = dataManager;
    }

    public void signIn(final String email) {

    }

    public void signInSuccessful() {
        getMvpView().showSignInSuccessful();
    }
}

package pl.simonduraj.blooddonor.ui.signin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import pl.simonduraj.blooddonor.data.DataManager;

import static junit.framework.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SignInPresenterTest {
    @Mock
    SignInMvpView mSignInMvpView;
    @Mock
    DataManager mMockDataManager;
    private SignInPresenter mSignInPresenter;

    @Before
    public void setUp() {
        mSignInPresenter = new SignInPresenter(mMockDataManager);
        mSignInPresenter.attachView(mSignInMvpView);
    }

    @Test
    public void testTest() {
        assertTrue(true);
    };
}
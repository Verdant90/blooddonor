package pl.simonduraj.blooddonor.ui.signin;

import android.os.Bundle;

import butterknife.ButterKnife;
import pl.simonduraj.blooddonor.R;
import pl.simonduraj.blooddonor.ui.base.BaseActivity;

public class SignInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
    }
}

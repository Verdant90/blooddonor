package pl.simonduraj.blooddonor.ui.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import pl.simonduraj.blooddonor.ui.signin.SignInActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}

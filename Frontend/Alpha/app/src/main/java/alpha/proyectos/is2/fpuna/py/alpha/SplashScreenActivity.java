package alpha.proyectos.is2.fpuna.py.alpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import alpha.proyectos.is2.fpuna.py.alpha.utils.PreferenceUtils;

/**
 *
 * @author federico.torres
 */
public class SplashScreenActivity extends Activity {

    private static int splashInterval = 2000;

    private PreferenceUtils preferenceUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        preferenceUtils = new PreferenceUtils(SplashScreenActivity.this);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                if (preferenceUtils.isLoggedIn()) {
                    i = new Intent(SplashScreenActivity.this, DashboardActivity.class);
                }
                startActivity(i);
                finish();
            }

        }, splashInterval);

    }

}

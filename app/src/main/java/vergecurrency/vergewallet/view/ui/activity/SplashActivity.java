package vergecurrency.vergewallet.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

import io.horizontalsystems.bitcoinkit.BitcoinKit;
import vergecurrency.vergewallet.R;
import vergecurrency.vergewallet.helpers.DbOpenHelper;
import vergecurrency.vergewallet.service.model.PreferencesManager;
import vergecurrency.vergewallet.view.ui.activity.firstlaunch.FirstLaunchActivity;
import vergecurrency.vergewallet.wallet.WalletManager;

public class SplashActivity extends AppCompatActivity {

	PreferencesManager pm;
	//DbOpenHelper dbOpenHelper;
	//private AbstractDaoSession daoSession;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//TestFairy token for getting info on beta testing
		//TestFairy.begin(this, "a67a4df6e2a8a0c981638eb0f168297fd45aed73");
		//init db
		//dbOpenHelper = new DbOpenHelper(this,"verge.db",1);
		//Database db = dbOpenHelper.getWritableDb();
		//daoSession = new AbstractDaoMaster;

		//init BitcoinKit
		BitcoinKit.Companion.init(this);

		//gets the holy preferences
		pm = PreferencesManager.init(getApplicationContext());



		setContentView(R.layout.activity_splash);

		//Just to have the splash screen going briefly
		new Handler().postDelayed(() -> startApplication(), 500);

	}


	public void startApplication() {

		if (pm.getFirstLaunch()) {
			finish();
			startActivity(new Intent(getApplicationContext(), FirstLaunchActivity.class));
		} else {
			WalletManager wm = WalletManager.init();
			try {
				wm.startWallet();
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
			}
			finish();
			startActivity(new Intent(getApplicationContext(), WalletActivity.class));
		}
	}

	@Override
	public void onBackPressed() {
	}

}

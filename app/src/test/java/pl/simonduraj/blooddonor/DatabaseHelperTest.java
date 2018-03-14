package pl.simonduraj.blooddonor;

import android.database.Cursor;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import io.reactivex.observers.TestObserver;
import pl.simonduraj.blooddonor.data.local.DatabaseHelper;
import pl.simonduraj.blooddonor.data.local.Db;
import pl.simonduraj.blooddonor.data.local.DbOpenHelper;
import pl.simonduraj.blooddonor.data.model.Ribot;
import pl.simonduraj.blooddonor.test.common.TestDataFactory;
import pl.simonduraj.blooddonor.util.DefaultConfig;
import pl.simonduraj.blooddonor.util.RxSchedulersOverrideRule;

import static junit.framework.Assert.assertEquals;

/**
 * Unit tests integration with a SQLite Database using Robolectric
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = DefaultConfig.EMULATE_SDK)
public class DatabaseHelperTest {

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    private DatabaseHelper mDatabaseHelper;

    @Before
    public void setup() {
        if (mDatabaseHelper == null)
            mDatabaseHelper = new DatabaseHelper(new DbOpenHelper(RuntimeEnvironment.application),
                    mOverrideSchedulersRule.getScheduler());
    }

    @Test
    public void setRibots() {
        Ribot ribot1 = TestDataFactory.makeRibot("r1");
        Ribot ribot2 = TestDataFactory.makeRibot("r2");
        List<Ribot> ribots = Arrays.asList(ribot1, ribot2);

        TestObserver<Ribot> result = new TestObserver<>();
        mDatabaseHelper.setRibots(ribots).subscribe(result);
        result.assertNoErrors();
        result.assertValueSequence(ribots);

        Cursor cursor = mDatabaseHelper.getBriteDb()
                .query("SELECT * FROM " + Db.RibotProfileTable.TABLE_NAME);
        assertEquals(2, cursor.getCount());
        for (Ribot ribot : ribots) {
            cursor.moveToNext();
            Assert.assertEquals(ribot.profile(), Db.RibotProfileTable.parseCursor(cursor));
        }
    }

    @Test
    public void getRibots() {
        Ribot ribot1 = TestDataFactory.makeRibot("r1");
        Ribot ribot2 = TestDataFactory.makeRibot("r2");
        List<Ribot> ribots = Arrays.asList(ribot1, ribot2);

        mDatabaseHelper.setRibots(ribots).subscribe();

        TestObserver<List<Ribot>> result = new TestObserver<>();
        mDatabaseHelper.getRibots().subscribe(result);
        result.assertNoErrors();
        result.assertValue(ribots);
    }

}

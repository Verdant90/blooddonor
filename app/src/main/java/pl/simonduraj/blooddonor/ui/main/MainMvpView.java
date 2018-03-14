package pl.simonduraj.blooddonor.ui.main;

import java.util.List;

import pl.simonduraj.blooddonor.data.model.Ribot;
import pl.simonduraj.blooddonor.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}

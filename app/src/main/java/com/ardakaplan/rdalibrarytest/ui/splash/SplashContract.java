package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.domain.interaction.InteractionException;
import com.ardakaplan.rdalibrary.objects.base.RDAPresenterContract;
import com.ardakaplan.rdalibrary.objects.base.RDAViewContract;

import java.util.ArrayList;

public class SplashContract {

    public interface SplashViewContract extends RDAViewContract {

        void testViewContract();

        void setList(ArrayList<String> list);

        void onError(InteractionException e);

    }

    public interface SplashPresenterContract extends RDAPresenterContract<SplashViewContract> {

        void testPresenterContract();

        void getList();
    }
}

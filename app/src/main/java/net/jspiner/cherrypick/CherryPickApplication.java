package net.jspiner.cherrypick;

import android.app.Application;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class CherryPickApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initFont();
    }

    private void initFont() {
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath(getString(R.string.font_regular))
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }
}

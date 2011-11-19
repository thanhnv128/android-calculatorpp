/*
 * Copyright (c) 2009-2011. Created by serso aka se.solovyev.
 * For more information, please, contact se.solovyev@gmail.com
 * or visit http://se.solovyev.org
 */

package org.solovyev.android.calculator.help;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.solovyev.android.calculator.R;

/**
 * User: serso
 * Date: 11/19/11
 * Time: 11:35 AM
 */
public class HelpActivity extends TabActivity {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.help);

		final TabHost tabHost = getTabHost();

		createTab(tabHost, "faq", "Faq", HelpFaqActivity.class);
		createTab(tabHost, "hints", "Hints", HelpHintsActivity.class);
		createTab(tabHost, "screens", "Screens", HelpScreensActivity.class);

		tabHost.setCurrentTab(0);


	}

	private void createTab(@NotNull TabHost tabHost,
						   @NotNull String tabId,
						   @NotNull String tabCaption,
						   @NotNull Class<? extends Activity> activityClass) {

		TabHost.TabSpec spec;

		final Intent intent = new Intent().setClass(this, activityClass);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost.newTabSpec(tabId).setIndicator(tabCaption)
				.setContent(intent);

		tabHost.addTab(spec);
	}
}
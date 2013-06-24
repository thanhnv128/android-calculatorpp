package org.solovyev.android.calculator.wizard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.solovyev.android.calculator.R;

import com.actionbarsherlock.app.SherlockFragment;

import static org.solovyev.android.calculator.wizard.CalculatorLayout.big_buttons;
import static org.solovyev.android.calculator.wizard.CalculatorLayout.getDefaultLayout;
import static org.solovyev.android.calculator.wizard.CalculatorLayout.optimized;

/**
 * User: serso
 * Date: 6/19/13
 * Time: 12:33 AM
 */
public class ChooseLayoutWizardStep extends SherlockFragment {

	/*
	**********************************************************************
	*
	*                           CONSTANTS
	*
	**********************************************************************
	*/

	static final String LAYOUT = "layout";

	/*
	**********************************************************************
	*
	*                           FIELDS
	*
	**********************************************************************
	*/

	@Nullable
	private RadioButton optimizedRadioButton;

	@Nullable
	private RadioButton bigButtonsRadioButton;

	private CalculatorLayout layout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if(savedInstanceState != null) {
			layout = (CalculatorLayout) savedInstanceState.getSerializable(LAYOUT);
		}

		if (layout == null) {
			layout = (CalculatorLayout) getArguments().getSerializable(LAYOUT);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.cpp_wizard_step_tablet, null);
	}

	@Override
	public void onViewCreated(View root, Bundle savedInstanceState) {
		super.onViewCreated(root, savedInstanceState);

		optimizedRadioButton = (RadioButton) root.findViewById(R.id.wizard_optimized_radiobutton);
		bigButtonsRadioButton = (RadioButton) root.findViewById(R.id.wizard_big_buttons_radiobutton);

		switch (layout) {
			case big_buttons:
				bigButtonsRadioButton.setChecked(true);
				optimizedRadioButton.setChecked(false);
				break;
			case optimized:
				bigButtonsRadioButton.setChecked(false);
				optimizedRadioButton.setChecked(true);
				break;
		}
	}

	@Nonnull
	CalculatorLayout getSelectedLayout() {
		CalculatorLayout layout = getDefaultLayout();

		if (bigButtonsRadioButton != null && bigButtonsRadioButton.isChecked()) {
			layout = big_buttons;
		} else if (optimizedRadioButton != null && optimizedRadioButton.isChecked()) {
			layout = optimized;
		}

		return layout;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putSerializable(LAYOUT, layout);
	}
}

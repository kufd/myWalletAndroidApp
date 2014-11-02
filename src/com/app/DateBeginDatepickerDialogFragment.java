package com.app;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

public class DateBeginDatepickerDialogFragment extends DatepickerDialogFragment 
{

	public DateBeginDatepickerDialogFragment(int fieldId) 
    {
    	super(fieldId);
    }
	
	@Override
    protected void setDefaultDate()
    {
    	Calendar cal = Calendar.getInstance();
		day = 1;
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
    }
}
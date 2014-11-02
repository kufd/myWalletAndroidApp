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

public class DateEndDatepickerDialogFragment extends DatepickerDialogFragment 
{

	public DateEndDatepickerDialogFragment(int fieldId) 
    {
    	super(fieldId);
    }
	
	@Override
    protected void setDefaultDate()
    {
    	Calendar cal = Calendar.getInstance();
    	
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	cal.roll(Calendar.DAY_OF_MONTH, -1);
    	
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		
    }
}
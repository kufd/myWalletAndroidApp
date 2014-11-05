package com.app;

import java.util.Calendar;

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

public class DatepickerDialogFragment extends DialogFragment 
{
   
	protected int day;
	protected int month;
	protected int year;
	private DatePickerDialog.OnDateSetListener dateSetListener;
	protected String defaultDate = null;
	
    

    public DatepickerDialogFragment(DatePickerDialog.OnDateSetListener dateSetListener, String defaultDate) 
    {
    	this.dateSetListener = dateSetListener;
    	this.defaultDate = defaultDate;
    	
    	
    	String[] dateParts = defaultDate.split("-");
		day = Integer.parseInt(dateParts[2]);
		month = Integer.parseInt(dateParts[1])-1;
		year = Integer.parseInt(dateParts[0]);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
    	return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }
}


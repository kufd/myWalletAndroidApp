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
	private EditText field;
	private int fieldId;
    

    public DatepickerDialogFragment(int fieldId) 
    {
    	this.fieldId = fieldId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	field = (EditText) getActivity().findViewById(fieldId);
        setDefaultDate();
    }
    
    protected void setDefaultDate()
    {
    	Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
    	return new DatePickerDialog(getActivity(), datePickerListener, year, month, day);
    }
    
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() 
	{
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) 
		{
			field.setText(selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay);
		}
	};
}
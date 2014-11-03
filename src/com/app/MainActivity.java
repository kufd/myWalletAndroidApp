package com.app;



import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends Activity 
{
	
	private String dateBegin;
	private String dateEnd;
	
	private EditText fieldDateBegin;
	private EditText fieldDateEnd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spendings_list);
		
		dateBegin = getDefaultDateBegin();
		dateEnd = getDefaultDateEnd();
		
		fieldDateBegin = (EditText) findViewById(R.id.dateBegin);
		fieldDateEnd = (EditText) findViewById(R.id.dateEnd);
		
		fieldDateBegin.setText(dateBegin);
		fieldDateEnd.setText(dateEnd);
		
		initDateFieldsEvents();
	}
	
	private void initDateFieldsEvents()
	{
		fieldDateBegin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	showDateBeginDatepickerDialog(R.id.dateBegin);
            }
        });
		fieldDateBegin.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            	if(hasFocus)
            	{
            		showDateBeginDatepickerDialog(R.id.dateBegin);
            	}
            }
        });
		
		fieldDateEnd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	showDateEndDatepickerDialog(R.id.dateEnd);
            }
        });	
		fieldDateEnd.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
            	if(hasFocus)
            	{
            		showDateEndDatepickerDialog(R.id.dateEnd);
            	}
            }
        });
	}
	
	void showDateBeginDatepickerDialog(int fieldNumber) 
	{
	    DialogFragment newFragment = new DatepickerDialogFragment(dateBeginPickerListener, dateBegin);
	    newFragment.show(getFragmentManager(), "dialog");
	}
	
	void showDateEndDatepickerDialog(int fieldNumber) 
	{
	    DialogFragment newFragment = new DatepickerDialogFragment(dateEndPickerListener, dateEnd);
	    newFragment.show(getFragmentManager(), "dialog");
	}
	
	private DatePickerDialog.OnDateSetListener dateBeginPickerListener = new DatePickerDialog.OnDateSetListener()  {
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) 
		{
			dateBegin = selectedYear + "-" + (selectedMonth+1) + "-" + selectedDay;
			fieldDateBegin.setText(dateBegin);
		}
	};
	
	private DatePickerDialog.OnDateSetListener dateEndPickerListener = new DatePickerDialog.OnDateSetListener()  {
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) 
		{
			dateEnd = selectedYear + "-" + (selectedMonth+1) + "-" + selectedDay;
			fieldDateEnd.setText(dateEnd);
		}
	};
	
	private String getDefaultDateBegin()
	{
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + 1;
	}
	
	private String getDefaultDateEnd()
	{
		Calendar cal = Calendar.getInstance();
    	
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	cal.roll(Calendar.DAY_OF_MONTH, -1);
    	
    	return cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH);
	}
	
}










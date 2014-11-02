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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spendings_list);
		
		EditText fieldDateBegin = (EditText) findViewById(R.id.dateBegin);
		EditText fieldDateEnd = (EditText) findViewById(R.id.dateEnd);
		
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
	    DialogFragment newFragment = new DateBeginDatepickerDialogFragment(fieldNumber);
	    newFragment.show(getFragmentManager(), "dialog");
	}
	
	void showDateEndDatepickerDialog(int fieldNumber) 
	{
	    DialogFragment newFragment = new DateEndDatepickerDialogFragment(fieldNumber);
	    newFragment.show(getFragmentManager(), "dialog");
	}
	
}










package com.app;



import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;
import android.app.AlertDialog;


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
				
		Button buttonAddSpending = (Button) findViewById(R.id.buttonAddSpending);
		buttonAddSpending.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            }
        });
		
		
		new SpendingsLoader(dateBegin, dateEnd, this).execute();
		
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
			dateBegin = selectedYear + "-" + String.format("%02d", (selectedMonth+1)) + "-" + String.format("%02d", selectedDay);
			fieldDateBegin.setText(dateBegin);
		}
	};
	
	private DatePickerDialog.OnDateSetListener dateEndPickerListener = new DatePickerDialog.OnDateSetListener()  {
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) 
		{
			dateEnd = selectedYear + "-" + String.format("%02d", (selectedMonth+1)) + "-" + String.format("%02d", selectedDay);
			fieldDateEnd.setText(dateEnd);
		}
	};
	
	private String getDefaultDateBegin()
	{
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + "-" + String.format("%02d", (cal.get(Calendar.MONTH)+1)) + "-01";
	}
	
	private String getDefaultDateEnd()
	{
		Calendar cal = Calendar.getInstance();
    	
    	cal.set(Calendar.DAY_OF_MONTH, 1);
    	cal.roll(Calendar.DAY_OF_MONTH, -1);
    	
    	return cal.get(Calendar.YEAR) + "-" + String.format("%02d", (cal.get(Calendar.MONTH)+1)) + "-" + String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
	}
	
	public void showSpendingsList(String data)
	{
    	
    	new AlertDialog.Builder(this)
        .setMessage(data)
        .show();
    	
    	/*
		
		TableLayout table = (TableLayout)findViewById(R.id.spendingsList);
		
		table.removeAllViews();

		for(int i=0; i<=50; i++)
		{
			TableRow row = new TableRow(this);
			TextView colSpendingName = new TextView(this);
			TextView colAmount = new TextView(this);
			TextView colDate = new TextView(this);
			
			colSpendingName.setText("Spending name");
			colSpendingName.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0.5f));
			colSpendingName.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			colSpendingName.setTextSize(17);
			colSpendingName.setHeight(25);
			
			colAmount.setText("20 грн");
			colAmount.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0.2f));
			colAmount.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			colAmount.setTextSize(17);
			colAmount.setHeight(25);
			
			colDate.setText("2014-08-08");
			colDate.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0.3f));
			colDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
			colDate.setTextSize(17);
			colDate.setHeight(25);
			
			
			row.addView(colSpendingName);
			row.addView(colAmount);
			row.addView(colDate);
			
			table.addView(row);
		}
		*/
	}
	
}










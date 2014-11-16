package com.app;

import android.os.AsyncTask; 

public class SpendingsLoader extends AsyncTask<Void, Void, String>
{
	private String dateBegin;
	private String dateEnd;
	private MainActivity activity;
	
	public SpendingsLoader(String dateBegin, String dateEnd, MainActivity activity) 
	{
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.activity = activity;
	}
	
	protected String doInBackground(Void... param) 
	{
		Spendings spendings = new Spendings();
    	
    	String data = spendings.getSpendings(dateBegin, dateEnd);
    	
    	return data;
    }

    protected void onPostExecute(String data) 
    {
    	activity.showSpendingsList(data);
    }
    
}


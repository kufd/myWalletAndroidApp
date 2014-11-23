package com.app;

import android.os.AsyncTask; 
import org.json.JSONObject;

public class SpendingsLoader extends AsyncTask<Void, Void, JSONObject>
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
	
	protected JSONObject doInBackground(Void... param) 
	{
		Spendings spendings = new Spendings();
    	
		JSONObject data = spendings.getSpendings(dateBegin, dateEnd);
    	
    	return data;
    }

    protected void onPostExecute(JSONObject data) 
    {
    	activity.showSpendingsList(data);
    }
    
}


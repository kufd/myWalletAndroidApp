package com.app;

import android.os.AsyncTask; 

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class SpendingsLoader extends AsyncTask<Void, Void, JSONObject>
{
	private String dateBegin;
	private String dateEnd;
	private MainActivity activity;
    private Exception exception = null;
	
	public SpendingsLoader(String dateBegin, String dateEnd, MainActivity activity) 
	{
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.activity = activity;
	}
	
	protected JSONObject doInBackground(Void... param)
	{
		Spendings spendings = new Spendings();

        JSONObject data = null;

		try
		{
			data = spendings.getSpendings(dateBegin, dateEnd);
		}
		catch(Exception e)
		{
            exception = e;
		}
    	
    	return data;
    }

    protected void onPostExecute(JSONObject data) 
    {
        if(exception == null)
        {
            activity.showSpendingsList(data);
        }
        else
        {
            activity.showExceptionMessage(exception);
        }
    }
    
}


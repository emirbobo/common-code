package com.arrownock.social;

import org.json.JSONObject;

public abstract interface IAnSocialCallback
{
  public abstract void onFailure(JSONObject paramJSONObject);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\social\IAnSocialCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
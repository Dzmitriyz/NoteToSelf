package com.example.notetoself;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class Note {
    private String mTitle;
    private String mDiscription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;

    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";
    private static final String JSON_IDEA = "idea" ;
    private static final String JSON_TODO = "todo";
    private static final String JSON_IMPORTANT = "important";

    public Note(){}

    public Note(JSONObject jo) throws JSONException{
        mTitle = jo.getString(JSON_TITLE);
        mDiscription=jo.getString(JSON_DESCRIPTION);
        mIdea=jo.getBoolean(JSON_IDEA);
        mTodo= jo.getBoolean(JSON_TODO);
        mImportant=jo.getBoolean(JSON_IMPORTANT);
    }

    public JSONObject converToJSON() throws JSONException{
        JSONObject jo = new JSONObject();
        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDiscription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_TODO, mTodo);
        jo.put(JSON_IMPORTANT, mImportant);
        return jo;
    }




    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDiscription;
    }

    public boolean isIdea() {
        return mIdea;
    }

    public boolean isTodo() {
        return mTodo;
    }

    public boolean isImportant() {
        return mImportant;
    }


    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setDescription(String mDiscription) {
        this.mDiscription = mDiscription;
    }

    public void setIdea(boolean mIdea) {
        this.mIdea = mIdea;
    }

    public void setTodo(boolean mTodo) {
        this.mTodo = mTodo;
    }

    public void setImportant(boolean mImportant) {
        this.mImportant = mImportant;
    }
}

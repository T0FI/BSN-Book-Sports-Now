package com.example.group_project_2019_20_group_6;


import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Sports {

    public String Name;
    public String Image;
    public ArrayList<String> extras = new ArrayList<String>();

    public Sports(String Name)
    {
        this.Name = Name;
    }

    @NonNull
    @Override
    public String toString() {
        return Name;
    }
}

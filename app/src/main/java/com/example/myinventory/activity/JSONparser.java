package com.example.myinventory.activity;

import com.example.myinventory.Adapter.Inventory;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class JSONparser {

    static InputStream is = null;
    static JSONObject jobj =null;
    static String json = "";

    //cosntuctor
    public JSONparser() {

    }

    // function get json from url
    // by making HTTP POST or GET mehtod

    public JSONObject makeHttpRequest(String url, String method, List<Inventory> params){
        return null;
    }
}

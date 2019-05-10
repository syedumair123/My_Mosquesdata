package com.example.my_mosquesdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {
private MosqueDataAdapter mosquedataAdapter;
private RecyclerView recyclerView;
    ArrayList<Mosque> mosqueArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);

        mosqueArrayList = new ArrayList<>();

        fetch_json(MosqueInterface.jsonurl);


    }
    public void fetch_json(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.valueOf(url))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        MosqueInterface api=retrofit.create(MosqueInterface.class);
        Call<String> call=api.getdata(33,"page=1");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body();
                        writeRecycler(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
    private void writeRecycler(String responce){

        try {
            JSONObject jsonObject=new JSONObject(responce); //getting json object from responce
            Log.d("responcetttt", String.valueOf(jsonObject));



                JSONArray jsonArray=jsonObject.getJSONArray("data");
                Mosque mosque ;
                for(int i=0;i<jsonArray.length();i++){
                    mosque=new Mosque();
                    JSONObject dataobj = jsonArray.getJSONObject(i);
                    mosque.setName(dataobj.getString("name"));
                    mosque.setAddress(dataobj.getString("address"));
                    mosque.setImageurl(dataobj.getString("imageurl"));
                    mosqueArrayList.add(mosque);
                }

            mosquedataAdapter = new MosqueDataAdapter(this,mosqueArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mosquedataAdapter);




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

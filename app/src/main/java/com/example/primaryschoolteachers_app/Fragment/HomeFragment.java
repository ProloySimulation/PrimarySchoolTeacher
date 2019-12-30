package com.example.primaryschoolteachers_app.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.primaryschoolteachers_app.MainActivity;
import com.example.primaryschoolteachers_app.R;
import com.goodiebag.pinview.Pinview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class HomeFragment extends Fragment {

    String url = "";
    String headMasterName , Boys , Girls , schoolName;

    Pinview pvBoys1,pvGirls1 , pvBoys2 , pvGirls2 , pvBoys3 , pvGirls3 , pvBoys4 , pvGirls4 , pvBoys5 , pvGirls5 ;

    int totalBoys , totalGirls ;

    int boys1 , boys2 , boys3 , boys4 , boys5 , girls1 , girls2, girls3 , girls4 , girls5 ;

    Button btnDetail;

    private TextView tvHeadMasterName , tvSchoolName ;
    private RequestQueue mqueue , sendQueue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        jsonParse();

        tvHeadMasterName = rootView.findViewById(R.id.tvMasterName);
        tvSchoolName = rootView.findViewById(R.id.tvSchoolName);

        pvBoys1 = rootView.findViewById(R.id.pvBoys1);
        pvBoys2 = rootView.findViewById(R.id.pvBoys2);
        pvBoys3 = rootView.findViewById(R.id.pvBoys3);
        pvBoys4 = rootView.findViewById(R.id.pvBoys4);
        pvBoys5 = rootView.findViewById(R.id.pvBoys5);
        pvGirls1 = rootView.findViewById(R.id.pvGirls1);
        pvGirls2 = rootView.findViewById(R.id.pvGirls2);
        pvGirls3 = rootView.findViewById(R.id.pvGirls3);
        pvGirls4 = rootView.findViewById(R.id.pvGirls4);
        pvGirls5 = rootView.findViewById(R.id.pvGirls5);
        btnDetail = rootView.findViewById(R.id.details);


        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getValue();

            }
        });
        return rootView ;
    }

    private void jsonParse() {

        mqueue = Volley.newRequestQueue(getActivity());

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray responseArray) {
                        try {
                            //  StringBuilder textViewData = new StringBuilder();
                            //Parse the JSON response array by iterating over it
                            for (int i = 0; i < responseArray.length(); i++) {
                                JSONObject response = responseArray.getJSONObject(i);
                                headMasterName = response.getString("");
                                schoolName = response.getString("");

                                //Create String out of the Parsed JSON

                                //         textViewData.append("Name: ").append(name).append(NEW_LINE);

                            }

                            //Populate textView with the response
                            tvHeadMasterName.setText(headMasterName);
                            tvSchoolName.setText(schoolName );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        mqueue.add(arrayRequest);

    }

    private void getValue() {

        // Get Value And Convert to Integer

        boys1 = Integer.parseInt(pvBoys1.getValue());
        boys2 = Integer.parseInt(pvBoys2.getValue());
        boys3 = Integer.parseInt(pvBoys3.getValue());
        boys4 = Integer.parseInt(pvBoys4.getValue());
        boys5 = Integer.parseInt(pvBoys5.getValue());
        girls1 = Integer.parseInt(pvGirls1.getValue());
        girls2 = Integer.parseInt(pvGirls2.getValue());
        girls3 = Integer.parseInt(pvGirls3.getValue());
        girls4 = Integer.parseInt(pvGirls4.getValue());
        girls5 = Integer.parseInt(pvGirls5.getValue());

        totalBoys = (boys1 + boys2 +boys3 + boys4 + boys5);
        totalGirls = (girls1 + girls2 + girls3 + girls4 + girls5);

        Boys = Integer.toString(totalBoys);
        Girls = Integer.toString(totalGirls);

        Toast.makeText(getActivity(),String.valueOf(totalBoys), Toast.LENGTH_SHORT).show();

        String data ="{"+ "\"boys\"" + "\"" + Boys + "\","+ "\"girls\"" + "\"" + Girls + "\""+ "}";

        dataSend(data);

    }

    // Method for sending TotalBoys and Girls Quantity

    private void dataSend(String data) {

        final String savedata= data;
        String URL="";

        sendQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);
                    Toast.makeText(getActivity(),objres.toString(),Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Toast.makeText(getActivity(),"Server Error",Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata == null ? null : savedata.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {

                    return null;
                }
            }

        };
        sendQueue.add(stringRequest);

    }

}

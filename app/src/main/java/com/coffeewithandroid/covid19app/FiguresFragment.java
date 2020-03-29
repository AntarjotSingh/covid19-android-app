package com.coffeewithandroid.covid19app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.coffeewithandroid.covid19app.App.AppController;
import com.coffeewithandroid.covid19app.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.coffeewithandroid.covid19app.App.AppController.TAG;

public class FiguresFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView text_confirmed, text_active, text_recovered, text_deceased, text_lastupdated;

    private Constants constants;

    private OnFragmentInteractionListener mListener;

    public FiguresFragment() {
        // Required empty public constructor
    }

    public static FiguresFragment newInstance(String param1, String param2) {
        FiguresFragment fragment = new FiguresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout= inflater.inflate(R.layout.fragment_figures, container, false);
        text_confirmed = layout.findViewById(R.id.text_confirmed);
        text_active = layout.findViewById(R.id.text_active);
        text_recovered = layout.findViewById(R.id.text_recovered);
        text_deceased = layout.findViewById(R.id.text_deceased);
        text_lastupdated = layout.findViewById(R.id.text_lastupdated);
        parseFiguresData();
        return layout;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void parseFiguresData() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, constants.URL_JSON_OBJECT, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statewise");
                            for(int i = 0; i < response.getJSONArray("statewise").length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if(jsonObject.getString("state").equals("Total")) {
                                    text_confirmed.setText(jsonObject.getString("confirmed"));
                                    text_active.setText(jsonObject.getString("active"));
                                    text_recovered.setText(jsonObject.getString("recovered"));
                                    text_deceased.setText(jsonObject.getString("deaths"));
                                    text_lastupdated.setText("Last Updated "+" "+jsonObject.getString("lastupdatedtime"));
                                }
                            }
                          //  Log.d(TAG, response.getJSONObject("state_wise").toString());
                         } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, constants.TAG_JSON_OBJECT);
    }
}

package com.coffeewithandroid.covid19app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coffeewithandroid.covid19app.Adapter.StatesAdapter;
import com.coffeewithandroid.covid19app.Model.StatesData;

import java.util.ArrayList;
import java.util.List;


public class StatesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private List<StatesData> statesDataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StatesAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

    public StatesFragment() {
    }

    public static StatesFragment newInstance(String param1, String param2) {
        StatesFragment fragment = new StatesFragment();
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
        View layout= inflater.inflate(R.layout.fragment_states, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.states_recyclerview);
        mAdapter = new StatesAdapter(getActivity().getApplicationContext(), statesDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareStatesData();

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
        void onFragmentInteraction(Uri uri);
    }

    private void prepareStatesData() {
        StatesData statesData = new StatesData("Karnataka", "984", "", "879", "", "84", "", "21", "");
        statesDataList.add(statesData);

        StatesData statesData1 = new StatesData("Karnataka", "984", "", "879", "", "84", "", "21", "");
        statesDataList.add(statesData1);
        StatesData statesData2 = new StatesData("Karnataka", "984", "", "879", "", "84", "", "21", "");
        statesDataList.add(statesData2);
        StatesData statesData3 = new StatesData("Karnataka", "984", "", "879", "", "84", "", "21", "");
        statesDataList.add(statesData3);
        StatesData statesData4 = new StatesData("Karnataka", "984", "", "879", "", "84", "", "21", "");
        statesDataList.add(statesData4);
        StatesData statesData5 = new StatesData("Karnataka", "984", "", "879", "", "84", "", "21", "");
        statesDataList.add(statesData5);
        mAdapter.notifyDataSetChanged();
    }
}

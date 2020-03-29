package com.coffeewithandroid.covid19app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coffeewithandroid.covid19app.Model.StatesData;
import com.coffeewithandroid.covid19app.R;

import java.util.List;

public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.ViewHolder> {

    private List<StatesData> statesDataList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView state, confirmed, active, recovered, deceased;
        public RelativeLayout stateholder;

        public ViewHolder(View view) {
            super(view);
            state = (TextView) view.findViewById(R.id.state);
            confirmed = (TextView) view.findViewById(R.id.confirmed);
            active = (TextView) view.findViewById(R.id.active);
            recovered = (TextView) view.findViewById(R.id.recovered);
            deceased = (TextView) view.findViewById(R.id.deceased);
            stateholder = (RelativeLayout) view.findViewById(R.id.stateholder);
        }
    }

    public StatesAdapter(Context context, List<StatesData> statesDataList) {
        this.context = context;
        this.statesDataList = statesDataList;
    }

    @NonNull
    @Override
    public StatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.state_list_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StatesAdapter.ViewHolder holder, int position) {
        StatesData statesData = statesDataList.get(position);
        holder.state.setText(statesData.getState());
        holder.confirmed.setText(statesData.getConfirmed());
        holder.active.setText(statesData.getActive());
        holder.recovered.setText(statesData.getRecovered());
        holder.deceased.setText(statesData.getDeceased());

        if(position%2 != 0) {
            holder.stateholder.setBackgroundColor(context.getResources().getColor(R.color.colorLightBackGray));
        }
    }

    @Override
    public int getItemCount() {
        return statesDataList.size();
    }
}

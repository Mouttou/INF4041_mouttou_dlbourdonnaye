package com.example.nathalie.applicationmobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nathalie on 28/12/2016.
 */

public class BiereAdapter extends RecyclerView.Adapter<BiereAdapter.BiereHolder>{

    JSONArray bieres;

    BiereAdapter()
    {

    }
    BiereAdapter (JSONArray bieres)
    {
        this.bieres=bieres;
    }
    protected void setData(JSONArray bieresFromFile)
    {
        this.bieres=bieresFromFile;
        notifyDataSetChanged();
    }

    @Override
    public BiereHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater lif = LayoutInflater.from(parent.getContext());
        View tv = lif.inflate(R.layout.biere_layout, parent, false);

        return new BiereHolder(tv);
    }

    @Override
    public void onBindViewHolder(BiereHolder holder, int position) {
        try {

            JSONObject myobject = (JSONObject) bieres.get(position);
            Biere mybiere = new Biere();
            mybiere.name = myobject.getString("name");
            mybiere.category_id = myobject.getString("category_id");
            holder.bind(mybiere);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (bieres!=null)
            return bieres.length();
        return 0;
    }

    public class BiereHolder extends RecyclerView.ViewHolder   {
        TextView tv;


        public BiereHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.tvBiere);
        }

        public void bind(Biere b) {
            tv.setText(b.name);
        }
    }
}

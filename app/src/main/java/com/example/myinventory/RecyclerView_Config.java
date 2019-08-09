package com.example.myinventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.example.myinventory.Adapter.Inventory;

import java.util.ArrayList;

public class RecyclerView_Config extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private ArrayList<Inventory> daftarInventory;
    private FirebaseDataListener listener;


    public RecyclerView_Config(Context context, ArrayList<Inventory> daftarInventory){
        this.context=context;
        this.daftarInventory = daftarInventory;
        this.listener=(FirebaseDataListener)context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_main, parent,false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override

    public void onBindViewHolder(ItemViewHolder holder, final int position){

        holder.noInventory.setText("No   :  "+ daftarInventory.get(position).getNo());
        holder.code_MaterialInventory.setText("Code Material   :  "+ daftarInventory.get(position).getCode_Material());
        holder.lokasiInventory.setText("Lokasi   :  "+ daftarInventory.get(position).getLokasi());
        holder.rack_NumberInventory.setText("Rack number   :  "+ daftarInventory.get(position).getRack_Number());
        holder.material_descInventory.setText("Material Desc   :  "+ daftarInventory.get(position).getMaterial_desc());
        holder.deptInventory.setText("Dept   :  "+ daftarInventory.get(position).getDept());
        holder.uomInventory.setText("UOM   :  "+ daftarInventory.get(position).getUom());
        holder.begining_StockInventory.setText("Begining Stock   :  "+ daftarInventory.get(position).getBegining_Stock());
        holder.price_unitInventory.setText("Price/unit   :  "+ daftarInventory.get(position).getPrice_unit());
        holder.total_Inventory.setText("Total_   :  "+ daftarInventory.get(position).getTotal_());
        holder.dateInventory.setText("Date   :  "+ daftarInventory.get(position).getDate());
        holder.inputInventory.setText("Input   :  "+ daftarInventory.get(position).getInput());
        holder.outputInventory.setText("Output   :  "+ daftarInventory.get(position).getOutput());
        holder.noteInventory.setText("Note   :  "+ daftarInventory.get(position).getNote());
        holder.stockInventory.setText("Stock   :  "+ daftarInventory.get(position).getStock());
        holder.total_sInventory.setText("Total_Stock   :  "+ daftarInventory.get(position).getTotal_s());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { listener.onDataClick(daftarInventory.get(position),position); }
        });

    }
    @Override
    public int getItemCount ()
    {
        return daftarInventory.size();
    }


    public interface FirebaseDataListener {
    void onDataClick (Inventory inventory, int position);
    }

}
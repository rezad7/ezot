package com.example.myinventory;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView noInventory;
    public TextView code_MaterialInventory;
    public TextView lokasiInventory;
    public TextView rack_NumberInventory;
    public TextView material_descInventory;
    public TextView deptInventory;
    public TextView uomInventory;
    public TextView begining_StockInventory;
    public TextView price_unitInventory;
    public TextView total_Inventory;
    public TextView dateInventory;
    public TextView inputInventory;
    public TextView outputInventory;
    public TextView noteInventory;
    public TextView stockInventory;
    public TextView total_sInventory;

    public View view;

    public ItemViewHolder (View view) {
        super(view);

        noInventory = (TextView) view.findViewById(R.id.txtNo);
        code_MaterialInventory = (TextView) view.findViewById(R.id.txtCode);
        lokasiInventory = (TextView) view.findViewById(R.id.txtLokasi);
        rack_NumberInventory = (TextView) view.findViewById(R.id.txtRack);
        material_descInventory = (TextView) view.findViewById(R.id.txtMaterial);
        deptInventory = (TextView) view.findViewById(R.id.txtDept);
        uomInventory = (TextView) view.findViewById(R.id.txtUom);
        begining_StockInventory = (TextView) view.findViewById(R.id.txtBegStck);
        price_unitInventory = (TextView) view.findViewById(R.id.txtPriceU);
        total_Inventory = (TextView) view.findViewById(R.id.txtTotal_);
        dateInventory = (TextView) view.findViewById(R.id.txtDate);
        inputInventory = (TextView) view.findViewById(R.id.txtIn);
        outputInventory = (TextView) view.findViewById(R.id.txtOut);
        noteInventory = (TextView) view.findViewById(R.id.txtNote);
        stockInventory = (TextView) view.findViewById(R.id.txtStock);
        total_sInventory = (TextView) view.findViewById(R.id.txtTotS);
        this.view = view;
    }
}

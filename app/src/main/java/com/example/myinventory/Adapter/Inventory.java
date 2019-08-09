package com.example.myinventory.Adapter;

public class Inventory {
    private String No;
    private String Code_Material;
    private String Lokasi;
    private String Rack_Number;
    private String Material_desc;
    private String Dept;
    private String Uom;
    private String Begining_Stock;
    private String Price_unit;
    private String Total_;
    private String Date;
    private String Input;
    private String Output;
    private String Note;
    private String Stock;
    private String Total_s;
    private String key;


    public Inventory(String code_MaterialInventory, String lokasiInventory, String rack_NumberInventory, String material_descInventory, String deptInventory, String uomInventory, String begining_StockInventory, String price_unitInventory, String total_Inventory, String dateInventory, String inputInventory, String outputInventory, String noteInventory, String stockInventory, String total_sInventory) {
    }


    public Inventory(String noInventory, String code_MaterialInventory, String lokasiInventory, String rack_NumberInventory, String material_descInventory, String deptInventory, String uomInventory, String begining_StockInventory, String price_unitInventory, String total_Inventory, String dateInventory, String inputInventory, String outputInventory, String noteInventory, String stockInventory, String total_sInventory) {
        No = noInventory;
        Code_Material = code_MaterialInventory;
        Lokasi = lokasiInventory;
        Rack_Number = rack_NumberInventory;
        Material_desc = material_descInventory;
        Dept = deptInventory;
        Uom = uomInventory;
        Begining_Stock = begining_StockInventory;
        Price_unit = price_unitInventory;
        Total_ = total_Inventory;
        Date = dateInventory;
        Input = inputInventory;
        Output = outputInventory;
        Note = noteInventory;
        Stock = stockInventory;
        Total_s = total_sInventory;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getCode_Material() {
        return Code_Material;
    }

    public void setCode_Material(String code_Material) {
        Code_Material = code_Material;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public String getRack_Number() {
        return Rack_Number;
    }

    public void setRack_Number(String rack_Number) {
        Rack_Number = rack_Number;
    }

    public String getMaterial_desc() {
        return Material_desc;
    }

    public void setMaterial_desc(String material_desc) {
        Material_desc = material_desc;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public String getUom() {
        return Uom;
    }

    public void setUom(String uom) {
        Uom = uom;
    }

    public String getBegining_Stock() {
        return Begining_Stock;
    }

    public void setBegining_Stock(String begining_Stock) {
        Begining_Stock = begining_Stock;
    }

    public String getPrice_unit() {
        return Price_unit;
    }

    public void setPrice_unit(String price_unit) {
        Price_unit = price_unit;
    }

    public String getTotal_() {
        return Total_;
    }

    public void setTotal_(String total_) {
        Total_ = total_;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }

    public String getOutput() {
        return Output;
    }

    public void setOutput(String output) {
        Output = output;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getTotal_s() {
        return Total_s;
    }

    public void setTotal_s(String total_s) {
        Total_s = total_s;
    }

}

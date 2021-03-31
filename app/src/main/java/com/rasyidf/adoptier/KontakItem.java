package com.rasyidf.adoptier;

import androidx.annotation.NonNull;

public class KontakItem {
    private String Nama;
    private String Nomor;
    public KontakItem(String nama, String nomor){
        this.Nama = nama;
        this.Nomor = nomor;
    }
    
    public String getNama(){
        return this.Nama;
    }
    public String getNomor(){
        return this.Nomor;
    }

    @NonNull
    @Override
    public String toString() {
        return this.Nama;
    }
}

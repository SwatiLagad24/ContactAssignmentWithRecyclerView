package com.example.contactassignmentwithrecyclerview;

import java.io.Serializable;

public class Contact implements Serializable {
    private int imgId;
    private String edtName;
    private String edtPhNumber;
    private  String edtEmailId;

    public Contact(int imgId,String edtName,String edtPhNumber,String edtEmailId)
    {
        this.imgId=imgId;
        this.edtName=edtName;
        this.edtPhNumber=edtPhNumber;
        this.edtName=edtEmailId;
    }

    public int getId() {
        return imgId;
    }

    public void setId(int id) {
        this.imgId = id;
    }

    public String getEdtName() {
        return edtName;
    }

    public void setEdtName(String edtName) {
        this.edtName = edtName;
    }

    public String getEdtPhNumber() {
        return edtPhNumber;
    }

    public void setEdtPhNumber(String edtPhNumber) {
        this.edtPhNumber = edtPhNumber;
    }

    public String getEdtEmailId() {
        return edtEmailId;
    }

    public void setEdtEmailId(String edtEmailId) {
        this.edtEmailId = edtEmailId;
    }
}

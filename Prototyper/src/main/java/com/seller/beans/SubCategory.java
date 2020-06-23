package com.seller.beans;
public class SubCategory extends Category{

    private int subCategoryId;
    private String subCategoryName;

    public SubCategory(int categoryId, String categoryName, int subCategoryId, String subCategoryName) {
        super(categoryId,categoryName);
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
    }

    public SubCategory() {
    }

    public SubCategory(int subCategoryId, String subCategoryName) {
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }


}

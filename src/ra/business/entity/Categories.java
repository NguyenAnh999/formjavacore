package ra.business.entity;

import ra.business.config.InputMethods;

import static ra.business.implement.CategoriesImplement.categoriesList;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private Boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData() {
        this.catalogId=autoId();
        this.catalogName=getInputName();
        this.descriptions=getInputDescriptions();
        this.catalogStatus=getInputStatus();

    }
    public String getInputDescriptions(){
        System.out.println("Mời bạn nhập mô tả");
     return    InputMethods.getString();
    }
    public Boolean getInputStatus() {
        System.out.println("mời bạn nhập vào trạng thái  (true – hoạt động, false – không hoạt động)");
        return InputMethods.getBoolean();
    }
    public int autoId() {
        if (categoriesList.isEmpty()) {
            return 0;
        } else {
            return categoriesList.get(categoriesList.size() - 1).getCatalogId() + 1;
        }
    }
    public String getInputName() {
        while (true) {
            System.out.println("Mời bạn nhập vào tên danh mục");
            String nameCheck = InputMethods.getString();
            if (nameCheck.length() > 50) {
                System.err.println("Tên không vượt quá 50 kí tự");
            } else {
                if (categoriesList.stream().anyMatch(categories -> categories.catalogName.equals(nameCheck))) {
                    System.err.println("Tên đã được sử dụng");
                } else {
                    return nameCheck;
                }
            }
        }
    }
    public void displayData(){
        System.out.printf("ID danh mục: %-2d | Tên danh mục: %-5s | " +
                "Mô tả danh mục: %-9s | Trạng thái danh mục: %-5s | \n",
                this.catalogId,this.catalogName,this.descriptions,this.catalogStatus?"hoạt dộng":"không hoạt động");

    }

    @Override
    public String toString() {
        return "Categories{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", catalogStatus=" + catalogStatus +
                '}';
    }
}

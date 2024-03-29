package ra.business.entity;

import ra.business.config.InputMethods;

import java.util.Date;

import static ra.business.implement.CategoriesImplement.categoriesList;
import static ra.business.implement.ProductImplement.productList;

public class Product {

    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;

    public enum productStatusEnum {
        ACTIVE, BLOCK, INACTIVE
    }

    private productStatusEnum productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, productStatusEnum productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void inputData() {

        this.productId = getInputProductId();
        this.productName = getInputName();
        this.price = getInputPrice();
        this.created = getInputDate();
        this.catalogId = getCategoryId();
        this.description = getInputDescriptions();
        this.productStatus = getInputStatus();
    }

    public productStatusEnum getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(productStatusEnum productStatus) {
        this.productStatus = productStatus;
    }

    private String getInputProductId() {
        final String regex = "^[C|A|S]\\w{3}$";
        while (true) {
            System.out.println("Nhập vào mã sản phẩm");
            String productIdInput = InputMethods.getString();
            if (productIdInput.matches(regex)) {
                boolean flag = true;
                for (Product product : productList) {
                    if (product != null && product.getProductId().equals(productIdInput)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return productIdInput;
                } else {
                    System.err.println("Id đã tồn tại, vui long nhập giá trị khác");
                }
            } else {
                System.err.println("Không đúng định dạng (C___)|(S___)|(A___)");
            }
        }
    }

    public productStatusEnum getInputStatus() {
        while (true) {
            System.out.println("Mời bạn chọn trạng thái cho sản phẩm");
            System.out.println("1: Đang bán");
            System.out.println("2: Hết hàng ");
            System.out.println("3: Khônh bán");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    return productStatusEnum.ACTIVE;
                case 2:
                    return productStatusEnum.BLOCK;
                case 3:
                    return productStatusEnum.INACTIVE;
                default:
                    System.err.println("Lựa chọn không đúng");
                    break;
            }

        }

    }

    private int getCategoryId() {
        if (categoriesList.isEmpty()){
            return -1;
        }
        while (true) {
            int count = 1;
            for (Categories arrCategory : categoriesList) {
                if (arrCategory.getCatalogStatus()){
                System.out.println("danh mục thứ : " + count);
                arrCategory.displayData();
                count++;
                }
            }
            System.out.println("mời bạn nhập vào số thứ tự của danh mục muốn chọn");
            int choice = InputMethods.getInteger();
            if (choice > count) {
                System.out.println("bạn chọn chưa đúng mời chọn lại");
            } else {
                return categoriesList.get(choice - 1).getCatalogId();
            }
        }
    }


    public Date getInputDate() {
        System.out.println("mời bạn nhập ngày nhập sản phẩm");
        return InputMethods.getDate();
    }

    public String getInputDescriptions() {
        System.out.println("Mời bạn nhập mô tả cho sản phẩm");
        return InputMethods.getString();
    }

    public float getInputPrice() {
        while (true) {
            System.out.println("Mời bạn nhập giá");
            float price = InputMethods.getFloat();
            if (price > 0) {
                return price;
            } else {
                System.err.println("Giá cần phải lớn hơn 0");
            }
        }
    }

    public String getInputName() {
        while (true) {
            System.out.println("Mời bạn nhập vào tên sản phẩm");
            String nameCheck = InputMethods.getString();
            if (nameCheck.length() > 50 || nameCheck.length() < 10) {
                System.err.println("Tên không vượt quá 50 kí tự và nhỏ hơn 10 kí tự");
            } else {
                if (productList.stream().anyMatch(product -> product.getProductName().equals(nameCheck))) {
                    System.err.println("Tên đã được sử dụng");

                } else {
                    return nameCheck;
                }
            }
        }
    }

    public void displayData() {
        String CategoryName = "Chưa chọn";
      if (this.catalogId!=-1){
          for (Categories categories : categoriesList) {
              if (categories.getCatalogId() == this.catalogId) {
                  CategoryName = categories.getCatalogName();
              }
          }
      }
        String status = this.productStatus == productStatusEnum.ACTIVE ? "Đang bán" : (productStatus == productStatusEnum.BLOCK ? "Hết hàng" : "Không bán");

        System.out.printf("Mã sản phẩm: %-5s | Tên sản phẩm: %-5s | giá sản phẩm: %-5f | " +
                        "Mô tả: %-5s | Ngày nhập: %-5s | Tên danh mục: %-5s | " +
                        "trạng thái sản phẩm: %-5s\n", this.productId, this.productName, this.price, this.description,
                this.created.toString(), CategoryName, status);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", catalogId=" + catalogId +
                ", productStatus=" + productStatus +
                '}';
    }
}

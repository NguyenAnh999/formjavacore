package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.ICategories;
import ra.business.design.IProduct;
import ra.business.entity.Categories;
import ra.business.entity.Product;

import java.awt.im.InputMethodRequests;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductImplement implements IProduct {
    public static List<Product> productList = new ArrayList<>();
    static {
        Date date = new Date(2023,22,12);
        productList.add(new Product("C123","cà phê chồn tươi",9f,"ngon",date,1, Product.productStatusEnum.ACTIVE));
    }

    @Override
    public void addElement() {
        System.out.println("Mời bạn nhập vào số sản phẩm muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Product c = new Product();
            c.inputData();
            productList.add(c);
        }
    }

    @Override
    public void deleteElement() {
        displayData();
        while (true) {
            System.out.println("Mời bạn nhập vào ID sản phẩm muốn xóa");
            String IDDelete = InputMethods.getString();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                productList.remove(finByID(IDDelete));
                System.out.println("Xóa sản phẩm thành công");
                return;
            }
        }
    }

    @Override
    public void updateElement() {
        displayData();
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID sản phẩm muốn sửa");
            String IDDelete = InputMethods.getString();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                while (isExit) {
                    System.out.println("chọn trường bạn cần sửa \n" +
                            "1: Tên\n" +
                            "2: Giá      \n" +
                            "3: Mô tả     \n" +
                            "4: ngày nhâp  \n" +
                            "5: danh mục   \n" +
                            "6: trạng thái   \n" +
                            "0: Thoát");
                    System.out.println("mời bạn chọn");
                    byte choice = InputMethods.getByte();
                    switch (choice) {
                        case 1:
                            finByID(IDDelete).setProductName(finByID(IDDelete).getInputName());
                            break;
                        case 2:
                            finByID(IDDelete).setPrice(finByID(IDDelete).getInputPrice());
                            break;
                        case 3:
                            finByID(IDDelete).setDescription(finByID(IDDelete).getInputDescriptions());
                            break;
                        case 4:
                            finByID(IDDelete).setCreated(finByID(IDDelete).getInputDate());
                            break;
                        case 5:
                            finByID(IDDelete).setCatalogId(finByID(IDDelete).getCatalogId());
                            break;
                        case 6:
                            finByID(IDDelete).setProductStatus(finByID(IDDelete).getInputStatus());
                            break;
                        case 0:
                            isExit = false;
                            break;
                        default:
                            System.err.println("lựa chọn sai ");

                    }
                }
            }
        }
    }

    @Override
    public void displayData() {
        if (productList.isEmpty()){
            System.err.println("bạn chưa có sản phẩm nào");
        }
        productList.stream().forEach(Product::displayData);
    }

    @Override
    public Product finByID(String ID) {
        for (Product product : productList) {
            if (product.getProductId().equals(ID)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortElementByPrice() {
        for (int i = 0; i < productList.size(); i++) {
            for (int j = 0; j < productList.size(); j++) {
                if (productList.get(j).getPrice() >productList.get(j+1).getPrice()) {
                   Product temp = productList.get(j);
                   productList.set(j,productList.get(j+1));
                    productList.set(j+1,temp);
                }
            }
        }
        System.out.println("sắp sếp theo giá thành công");
        displayData();
    }

    @Override
    public void searchByName() {
        System.out.println("mời bạn nhập vào tên sản phẩm muốn tìm");
        String name = InputMethods.getString();
        if (productList.stream().anyMatch(product -> product.getProductName().contains(name))){
            productList.stream().filter(product -> product.getProductName().contains(name)).forEach(Product::displayData);
        }else {
            System.out.println("không timg thấy sản phẩm bạn muốn");
        }
    }
    public void searchByPrice() {
        System.out.println("mời bạn nhập vào khoảng giá");
        System.out.println("Từ");
        float from = InputMethods.getFloat();
        System.out.println("đến");
        float to = InputMethods.getFloat();
        if (productList.stream().filter(product -> product.getPrice()<to).anyMatch(product -> product.getPrice()>from)){
            productList.stream()
                    .filter(product -> product.getPrice()<to)
                    .filter(product -> product.getPrice()>from)
                    .forEach(Product::displayData);
        }else {
            System.out.println("không timg thấy sản phẩm bạn muốn");
        }
    }
}

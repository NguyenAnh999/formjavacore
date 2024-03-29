package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.ICategories;
import ra.business.entity.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesImplement implements ICategories {

    public static List<Categories> categoriesList = new ArrayList<>();
    static {
        categoriesList.add(new Categories(0,"cà phê1","cà phê chồn",true));
        categoriesList.add(new Categories(1,"cà phê2","cà phê mèo",true));
        categoriesList.add(new Categories(2,"cà phê3","cà phê chó",true));
        categoriesList.add(new Categories(3,"cà phê4","cà phê voi",true));
        categoriesList.add(new Categories(4,"cà phê5","cà phê gà",true));
        categoriesList.add(new Categories(5,"cà phê6","cà phê chim",true));
        categoriesList.add(new Categories(6,"cà phê7","cà phê chuột",true));
        categoriesList.add(new Categories(7,"cà phê8","cà phê cú",true));
        categoriesList.add(new Categories(8,"cà phê9","cà phê cá",true));
        categoriesList.add(new Categories(9,"cà phê10","cà phê sai",false));
    }

    @Override
    public void addElement() {
        System.out.println("Mời bạn nhập vào số danh mục muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Categories categories = new Categories();
            categories.inputData();
            categoriesList.add(categories);
        }
    }

    @Override
    public Categories finByID(Integer ID) {
        for (Categories categories : categoriesList) {
            if (categories.getCatalogId() == ID) {
                return categories;
            }
        }
        return null;
    }

    @Override
    public void deleteElement() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID danh mục muốn xóa");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.err.println("id bạn nhập vào chưa đúng mời nhập lại");
            } else {
                categoriesList.remove(finByID(IDDelete));
                isExit = false;
            }
        }
    }

    @Override
    public void updateElement() {
        displayData();
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID danh mục muốn sửa");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                while (isExit) {
                    System.out.println("chọn trường bạn cần sửa \n" +
                            "1: Tên\n" +
                            "2: Mô tả\n" +
                            "3: trạng thái\n" +
                            "0: Thoát");
                    System.out.println("mời bạn chọn");
                    byte choice = InputMethods.getByte();
                    switch (choice) {
                        case 1:
                            finByID(IDDelete).setCatalogName(finByID(IDDelete).getInputName());
                            break;
                        case 2:
                            System.out.println("Mời nhập mô tả mới");
                            finByID(IDDelete).setDescriptions(InputMethods.getString());
                            break;
                        case 3:
                            finByID(IDDelete).setCatalogStatus(finByID(IDDelete).getInputStatus());
                            break;
                        case 0:
                            System.out.println("cập nhật thành công");
                            isExit = false;
                            break;
                        default:
                            System.err.println("Trường bạn chọn sửa không có");

                    }
                }
            }
        }
    }
    public void updateStatus() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID danh mục muốn cập nhật trạng thái");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.err.println("id bạn nhập vào chưa đúng mời nhập lại");
            } else {
                finByID(IDDelete).displayData();
                finByID(IDDelete).setCatalogStatus(finByID(IDDelete).getInputStatus());
                System.out.println("cập nhật thành công");
                isExit = false;
            }
        }
    }
    @Override
    public void displayData() {
        if (categoriesList.isEmpty()){
            System.err.println("bạn chưa có danh mục nào");
        }
        categoriesList.stream().filter(Categories::getCatalogStatus).forEach(Categories::displayData);
    }
}

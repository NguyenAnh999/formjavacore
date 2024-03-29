package ra.run;

import ra.business.config.InputMethods;
import ra.business.implement.ProductImplement;

public class ProductMenu {
    public static void ProductMenuImplement() {
        ProductImplement cal = new ProductImplement();
        boolean isExit = true;
        while (isExit) {
            System.out.println("-----------PRODUCT MANAGEMENT----------------");
            System.out.println("1. Nhập thông tin các sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp các sản phẩm theo giá \n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm \n" +
                    "5. Xóa sản phẩm theo mã sản phẩm \n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm \n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn \n" +
                    "phím) \n" +
                    "0. Quay lại");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    cal.addElement();
                    break;
                case 2:
                    cal.displayData();
                    break;
                case 3:
                    cal.sortElementByPrice();
                    break;
                case 4:
                    cal.updateElement();
                    break;
                case 5:
                    cal.deleteElement();
                    break;
                case 6:
                    cal.searchByName();
                    break;
                case 7:
                    cal.searchByPrice();
                    break;
                case 0:
                    isExit = false;
                    break;
                default:
                    System.err.println("Lựa chọn không đúng mời chọn lại");
                    break;
            }
        }

    }
}

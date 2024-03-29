package ra.run;

import ra.business.config.InputMethods;
import ra.business.implement.CategoriesImplement;

public class CategoryMenu{
    public static void CategoryMenuImplement(){
        CategoriesImplement cal = new CategoriesImplement();
        boolean isExit=true;
        while (isExit) {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1: Nhập thông tin các danh mục \n" +
                    "2: Hiển thị thông tin các danh mục\n" +
                    "3: Cập nhật thông tin danh mục \n" +
                    "4. Xóa danh mục  \n" +
                    "5. Cập nhật trạng thái danh mục \n" +
                    "0: Quay lại\n");
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
                    cal.updateElement();
                    break;
                case 4:
                    cal.deleteElement();
                    break;
                case 5:
                    cal.updateStatus();
                    break;
                case 0:
                   isExit=false;
                    break;
                default:
                    System.out.println("Lựa chọn không đúng");
                    break;
            }
        }
    }
}

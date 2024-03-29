package ra.run;

import ra.business.config.InputMethods;

import java.util.Scanner;

public class ShopManagement {

    public static void main(String[] args) {
       while (true){
           System.out.println("******************SHOP MENU*******************");
           System.out.println("1: Quản lý danh mục sản phẩm\n" +
                   "2: Quản lý sản phẩm\n" +
                   "3: Thoát\n");
           System.out.println("mời bạn nhập");
           byte choice = InputMethods.getByte();
           switch (choice){
               case 1:
                 CategoryMenu.CategoryMenuImplement();
                   break;
               case 2:
              ProductMenu.ProductMenuImplement();
                   break;
               case 3:
                   System.exit(0);
                   break;
               default:
                   System.out.println("Lựa chọn không đúng mời chọn lại");
                   break;

           }
       }
    }
}

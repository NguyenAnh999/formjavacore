package ra.run;

import ra.business.config.InputMethods;

import java.util.Scanner;

public class Manage {

    public static void main(String[] args) {
       while (true){
           System.out.println("-----------MENU----------------");
           System.out.println("1: Quản lý xxxxxxx\n" +
                   "2: Quản lý xxxxxxxxx\n" +
                   "3: Quản lý xxxxxxxxxx\n" +
                   "4: Thoát\n");
           System.out.println("mời bạn nhập");
           byte choice = InputMethods.getByte();
           switch (choice){
               case 1:
                   MenuLon.menuXxxx();
                   break;
               case 2:
                   MenuNho.menuyyyyyy();
                   break;
               case 3:
                   break;

               case 4:
                   System.exit(0);
                   break;
               default:
                   System.out.println("Lựa chọn không đúng");
                   break;

           }
       }
    }
}

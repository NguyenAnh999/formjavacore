package ra.run;

import ra.business.config.InputMethods;

public class MenuLon {
    public static void menuXxxx(){
        boolean isExit=true;
        while (isExit) {
            System.out.println("-----------MENUXXXXXX----------------");
            System.out.println("1: Quản lý xxxxxxx\n" +
                    "2: Quản lý xxxxxxxxx\n" +
                    "3: Quản lý xxxxxxxxxx\n" +
                    "0: Thoát\n");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
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

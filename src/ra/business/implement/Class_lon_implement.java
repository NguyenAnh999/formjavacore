package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.IClass_lon;
import ra.business.entity.ClassName_nho;
import ra.business.entity.Class_Lon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Class_lon_implement implements IClass_lon {
    public static List<Class_Lon> listLon = new ArrayList<>();

    @Override
    public void addElement() {
        System.out.println("Mời bạn nhập vào số xxxxxxxxxx muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Class_Lon c = new Class_Lon();
            c.inputData();
            listLon.add(c);
        }
    }

    @Override
    public void deleteElement() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID muốn xóa");
            String IDDelete = InputMethods.getString();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                listLon.remove(finByID(IDDelete));
                isExit = false;
            }
        }
    }

    @Override
    public void updateElement() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID muốn sửa");
            String IDDelete = InputMethods.getString();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {

                while (isExit) {

                    System.out.println("chọn trường bạn cần sửa \n" +
                            "1: Tên\n" +
                            "2:        \n" +
                            "3:        \n" +
                            "4:    \n" +
                            "5:    \n" +
                            "6:    \n" +
                            "7:     \n" +
                            "0: Thoát");
                    System.out.println("mời bạn chọn");
                    byte choice = InputMethods.getByte();
                    switch (choice) {
                        case 1:

                            finByID(IDDelete).setName(InputMethods.getString());
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:

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

    }

    @Override
    public Class_Lon finByID(String ID) {
        for (Class_Lon c : listLon) {
            if (c.getId().equals(ID)) {
                return c;
            }
        }
        return null;
    }


}

package ra.business.design;

import ra.business.entity.ClassName_nho;

public interface IClass_nho extends  InterfaceCRUD<ClassName_nho,String>{
   void sortElementByName();
   void searchByName();

}

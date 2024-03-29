package ra.business.design;

import ra.business.entity.Product;

public interface IProduct extends  InterfaceCRUD<Product,String>{
   void sortElementByPrice();
   void searchByName();
   void searchByPrice();

}

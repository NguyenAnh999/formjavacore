package ra.business.design;

public interface InterfaceCRUD<T,E> {
   void addElement();
   void deleteElement();
   void updateElement();
   void displayData();
   T finByID(E t);
}

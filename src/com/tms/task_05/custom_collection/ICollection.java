package com.tms.task_05.custom_collection;

public interface ICollection<T> {
    void addItem(T item);
    Object getObject(int index);
    Object[] getItems();
    void printLastIndex();
    void delete(int index);
    void clear();

}

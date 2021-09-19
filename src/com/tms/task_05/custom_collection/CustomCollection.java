package com.tms.task_05.custom_collection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomCollection<T> {
    private T[] data;

    public CustomCollection(T[] data) {
        this.data = data;
    }

    public CustomCollection(Class<T[]> array, int size) {
        data = array.cast(Array.newInstance(array.getComponentType(), size));
    }

    int index = 0;
    int index1;

    /**
     * Метод add добавляет элемент в массив
     *
     * @param item - принимаемое значение
     */
    public void add(T item) {

        if (item != null) {
            if (index >= data.length) {
                data = Arrays.copyOf(data, data.length + 4);
            }
            if (index < data.length & data[index] == null) {
                data[index] = item;
            }
            index1 = index;
            index++;
        } else {
            index1 = -1;
        }
    }

    /**
     * get получает из поля Data предварительно переданный объект
     *
     * @param index - принимаемый индекс элемента
     * @return возвращает объект (значение элемента массива). Если индекс не существует, то вернет сообщение об этом
     */
    public T get(int index) {
        if (index >= 0 & index < data.length) {
            return data[index];
        } else {
            return (T) "элемент с заданным индексом не существует";
        }
    }

    /**
     * Метод getItems получает объекты поля Data
     *
     * @param - не принимает никаких параметров
     * @return - возвращает поле Data
     */
    public T[] getItems() {
        return data;
    }

    /**
     * Метод printLastIndex - тестовый метод
     *
     * @param - не принимает никаких параметров
     * @return - возвращает void. Выводит индекс последнего переданного элемента в консоль
     */
    public void printLastIndex() {
        System.out.println("Last added index = " + index1);
    }

    /**
     * Метод delete - удаляет элемент массива по заданному индексу
     *
     * @param - принимает параметр - индекс элемента
     */
    public void delete(int index) {
        boolean var;
        if (index == 0) {
            T[] data2 = (T[]) java.lang.reflect.Array.newInstance(data.getClass().getComponentType(), data.length - 1);
            System.arraycopy(data, 1, data2, 0, data.length - 1);
            data = data2;
            var = true;
        } else if (index == data.length - 1) {
            T[] data2 = (T[]) java.lang.reflect.Array.newInstance(data.getClass().getComponentType(), data.length - 1);
            if (data.length - 1 >= 0) {
                System.arraycopy(data, 0, data2, 0, data2.length);
            }
            var = true;
            data = data2;
        } else if (index > data.length - 1) {
            var = false;

        } else {
            T[] data2 = (T[]) java.lang.reflect.Array.newInstance(data.getClass().getComponentType(), data.length - 1);
            for (int i = 0; i < data.length; i++) {
                if (i > index) {
                    data2[i - 1] = data[i];
                }
                if (i == index) {
                    continue;
                }
                if (i < index) {
                    data2[i] = data[i];
                }
            }
            var = true;
            data = data2;
        }
    }

    /**
     * Метод delete - удаляет элемент массива по заданному значению
     *
     * @param - принимает параметр - значение элемента
     */
    public void delete(T item) {
        int i = 0;
        if (item != null) {
            for (T element : data) {
                if (element == null) {
                    continue;
                } else if (element.equals(item)) {
                    break;
                }
                i++;
                index = i;
            }
            delete(index);
        }

    }

    /**
     * Метод очищает массив
     */
    public void clear() {
        T[] data2 = (T[]) java.lang.reflect.Array.newInstance(data.getClass(), data.length);
        for (int i = 0; i < data.length; i++) {
            data2[i] = null;
        }
        data = data2;
    }

    /**
     * Метод toString - переопределение метода toString класса Object (используем StringBuilder)
     *
     * @param - не принимает параметров
     * @return возвращает строку
     */
    @Override
    public String toString() {
        boolean var = false;
        if (data == null) {
            return "null";
        }
        int iMax = data.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < data.length; i++) {
            if (i == iMax) {
                b.append(']');
            }
            if (data[i] != null) {
                if (var) {
                    b.append(", ");
                }
                b.append(data[i]);
                var = true;

            }
        }
        return b.toString();
    }

}

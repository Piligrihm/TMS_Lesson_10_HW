package com.tms.task_05.custom_collection;

public class CustomCollection<T> implements ICollection<T> {
    private int index = 0;
    private int index1;
    private Object[] data;

    public CustomCollection() {
        this.data = new Object[4];
    }

    public CustomCollection(int size) {
        data = new Object[size];
    }

    /**
     * Метод add добавляет элемент в массив
     *
     * @param item - принимаемое значение
     */
    public void addItem(T item) {

        if (item != null) {
            if (index >= data.length) {
                Object[] data2 = new Object[data.length + 4];
                for (int i = 0, j = 0; i < data.length; i++, j++) {
                    data2[j] = data[i];
                }
                data = data2;
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
    public Object getObject(int index) {
        if (index >= 0 & index < data.length) {
            return data[index];
        } else {
            return "элемент с заданным индексом не существует";
        }
    }

    /**
     * Метод getItems получает объекты поля Data
     *
     * @param - не принимает никаких параметров
     * @return - возвращает поле Data
     */
    public Object[] getItems() {
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
        Object[] data2 = new Object[data.length - 1];
        if (index == 0) {
            for (int i = 1, j = 0; i < data.length; i++, j++) {
                data2[j] = data[i];
            }
            data = data2;
        } else if (index == data.length - 1) {
            for (int i = 0, j = 0; i < data.length - 1; i++, j++) {
                data2[j] = data[i];
            }
            data = data2;
        } else if (index > data.length - 1) {
            System.out.println("Элемент с таким индексом не существует");
        } else {
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
            data = data2;
        }
    }

    /**
     * Метод delete - удаляет элемент массива по заданному значению
     *
     * @param - принимает параметр - значение элемента
     */
    public void delete(Object item) {
        int i = 0;
        if (item != null) {
            for (Object element : data) {
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
        Object[] data2 = new Object[data.length];
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
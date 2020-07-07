package sample;

/**
 * Класс для вывода объектов с 2 полями
 */

public class List {
    private String name;
    private Integer count;

    public List(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

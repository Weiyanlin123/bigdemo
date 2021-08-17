package com.city.cloud;

import lombok.Data;

@Data
public class B {

    private  String  name;

    private  String  age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof B)) return false;

        B b = (B) o;

        if (name != null ? !name.equals(b.name) : b.name != null) return false;
        return age != null ? age.equals(b.age) : b.age == null;
    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (age != null ? age.hashCode() : 0);
//        return result;
//    }
}



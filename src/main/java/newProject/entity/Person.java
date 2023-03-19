package newProject.entity;

public class Person {
    private int id;

    private String name;

    public Person() {
    }

//    public Person(String name){
//        this.name = name;
//    }

    public Person(int id, String name){
        this.name = name;
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

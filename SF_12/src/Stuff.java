public interface Stuff {
    void helpStudent(Student student);
    public default void getAdditionalMaterials(){
        System.out.println("https://habr.com/ru/");
    }
}

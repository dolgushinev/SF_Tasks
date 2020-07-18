public interface Autochecked {
    public default void perfornTask() {
        System.out.println("Задание выполнено. Задание было проверено автоматически");
    }
}

public interface Autochecked {
    public default void performTask() {
        System.out.println("Задание выполнено. Задание было проверено автоматически\n");
    }
}

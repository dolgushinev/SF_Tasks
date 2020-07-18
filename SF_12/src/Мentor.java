public class Мentor extends Person implements Stuff {

    private boolean mood;
    private final int NUM_FOR_RANDOM_CLC = 1000;

    public Мentor(String name, int age) {
        super(name, age);
        setMood(true);
    }

    public boolean isMood() {
        return mood;
    }

    public void setMood(boolean mood) {
        this.mood = mood;
    }

    @Override
    public void helpStudent(Student student) {
//        Напечатать приободряющее сообщение, в сообщении должно быть имя студента
        System.out.println("Держись, " + student.getName() + ", в жизни есть вещи и посложнее программирования, например - квантовая физика");
    }

    public boolean checkCode(Task task) {
/*      ➜ В начале метода рандомно генерируется какое-то число, если это число больше 1000, то настроение у ментора хорошее, иначе плохое.
        ➜ Если у ментора плохое настроение, то он задачу не принимает. Должно быть напечатано сообщение о том, что задача (в сообщении указать номер задачи) не принято и вернуть false.
        ➜ Иначе напечатать сообщение о том, что задача принята и вернуть true.*/

        if (Math.random() * 5000 > NUM_FOR_RANDOM_CLC) setMood(true);
        else {
            setMood(false);
            System.out.println("Задача не принята: " + task.getNumber());
        }
        return isMood();
    }

}

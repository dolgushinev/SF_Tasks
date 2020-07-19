import java.util.Random;

public class Education {
    public static void main(String[] args) {
        Task[] tasks = new Task[45];

        for (int i = 0; i < 45; i += 3) {
            tasks[i] = new Test();
            tasks[i].setNumber(i);

            tasks[i + 1] = new Code();
            tasks[i + 1].setNumber(i + 1);

            tasks[i + 2] = new DragAndDrop();
            tasks[i + 2].setNumber(i + 2);
        }

        Mentor mentorA = new Mentor("Иван Иванов", 35);
        Mentor mentorB = new Mentor("Степан Петров", 40);

        Student[] students = new Student[3];
        students[0] = new Student("Федор Федоров", 30, mentorA);
        students[1] = new Student("Эдгар Базилик", 30, mentorA);
        students[2] = new Student("Руберойд Запашный", 30, mentorB);

        for (Student student : students
        ) {
            System.out.println("\n----------------------------Студент: " + student.getName() +
                    " приступает к прохождению заданий. Его ментор: " + student.getMentor().getName() +
                    "----------------------------\n");
            int i = 0;
            do {
                Random random = new Random();
                int min = 1;
                int max = 45;
                int diff = max - min;
                i = random.nextInt(diff + 1);
                i += min;
            } while (!student.doTasks(i, tasks));


        }
    }
}

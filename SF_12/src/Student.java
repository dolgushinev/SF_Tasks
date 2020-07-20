public class Student extends Person {

    private int taskComplitedCnt;
    private static int allStudentTasksComplitedCnt = 0;
    private Mentor mentor;
    private boolean allTasksComplited;

    public Student(String name, int age, Mentor mentor) {
        super(name, age);
        this.mentor = mentor;
        this.allTasksComplited = false;
        this.taskComplitedCnt = 0;
    }

    public int getTaskComplitedCnt() {
        return taskComplitedCnt;
    }

    public void setTaskComplitedCnt(int taskComplitedCnt) {
        this.taskComplitedCnt = taskComplitedCnt;
    }

    public boolean isAllTasksComplited() {
        return allTasksComplited;
    }

    public void setAllTasksComplited(boolean allTasksComplited) {
        this.allTasksComplited = allTasksComplited;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean doTasks(int taskCnt, Task[] tasks) {

/*        ➜ Студенту передаётся число задач, которые он должен решить и ссылка на массив с заданиями
          ➜ У студента есть количество задач, которые он уже решил, а значит вы можете вычислить, с какой задачи начинать решение.
          ➜ Для решения задач студент вызывает метод Решить задачу.
          ➜ Если студент решил все задачи из массива, то напечатать об этом сообщение и выставить true в соответствующее поле
          ➜ Иначе напечатать сообщение о том, что не все задачи решены и вернуть false */

        System.out.println("Вызван doTasks, taskComplitedCnt = " + taskComplitedCnt + ", taskCnt = " + taskCnt + "\n");

        int limitIndex = taskComplitedCnt + taskCnt;

        for (int i = taskComplitedCnt; i < limitIndex; i++) {
            if (isAllTasksComplited()) {
                System.out.println("У студента " + this.getName() + " все задачи из массива уже были решены ранее");
                break;
            }
            System.out.println("**************************** В работе task с id = " + tasks[i].getNumber() +
                    " ****************************");
            doTask(tasks[i]);
            if (i == tasks.length - 1) {
                System.out.println("У студента " + this.getName() + " все задачи из массива решены");
                setAllTasksComplited(true);
                break;
            }
        }

        if (!isAllTasksComplited())
            System.out.println("!!!Внимание, у студента " + this.getName() +
                    " пока не все задачи решены, будет еще один вызов doTasks!!!\n");

        return isAllTasksComplited();
    }

    private void doTask(Task task) {
/*       Если задание проверяется автоматически, то напечатать сообщение о том, что задание выполнено и закончить работу метода
         Иначе у текущего отправлять ментору задание на проверку до тех пор, пока оно не будет зачтено
         Не забудьте увеличить число решенных студентом и всеми студентами задач */

        if (task instanceof DragAndDrop || task instanceof Test) {
            ((Autochecked) task).performTask();
            taskComplitedCnt++;
            allStudentTasksComplitedCnt++;
        } else {
            while (!getMentor().checkCode(task)) {
            }
            allStudentTasksComplitedCnt++;
            taskComplitedCnt++;
        }

    }

}

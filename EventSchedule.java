import java.util.*;

class StudentComparator implements Comparator<Student> { 
    public int compare(Student student_1, Student student_2) 
    { 
        if(student_1.getCgpa() == student_2.getCgpa()){
            if(student_1.getName().equals(student_2.getName())){
                return Integer.compare(student_1.getToken(), student_2.getToken());
            } 
            else{
                return student_1.getName().compareTo(student_2.getName());
            }
        } 
        else{
            return Float.compare(student_2.getCgpa(), student_1.getCgpa());
        }
    } 
}

public class EventSchedule {
    private PriorityQueue<Student> queue;

    // Constructor
    public EventSchedule(int events){
        queue = new PriorityQueue<Student>(new StudentComparator());
    }

    // Display Answer
    private void displayQueue() {
        if (!queue.isEmpty()) {
            while (!queue.isEmpty())
                System.out.println(queue.remove().getName());
        } 
        else
            System.out.println("EMPTY");

    }

    //Schedule Events
    private void executeEvent(int events) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= events; i++){

            String event = sc.nextLine();
            String[] eventDetails = event.split(" ");

            if(eventDetails[0].equals("ENTER")){
                String name = eventDetails[1];
                float cgpa = Float.parseFloat(eventDetails[2]);
                int token = Integer.parseInt(eventDetails[3]);
                queue.add(new Student(name, cgpa, token));
            } 
            else if(eventDetails[0].equals("SERVED") && queue.peek() != null){
                queue.remove();
            }
        }
    }

    //Main Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int events = sc.nextInt();
        EventSchedule event = new EventSchedule(events);
        event.executeEvent(events);
        event.displayQueue();
    }
}

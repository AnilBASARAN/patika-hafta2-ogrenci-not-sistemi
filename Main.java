import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

                    System.out.print("Matematik yazılı notunu girin:   ");
                    int m1 = input.nextInt();

                    System.out.print("Matematik sözlü notunu girin:   ");
                    int m2 = input.nextInt();

                    System.out.print("Fizik yazılı notunu girin:   ");
                    int f1 = input.nextInt();

                    System.out.print("Fizik sözlü notunu girin:");
                    int f2 = input.nextInt();

                    System.out.print("Kimya yazılı notunu girin:   ");
                    int k1 = input.nextInt();

                    System.out.print("Kimya sözlü notunu girin:   ");
                    int k2 = input.nextInt();


                    Course mat = new Course("Matematik", "MAT101", "MAT");
                    Course fizik = new Course("Fizik", "FZK101", "FZK");
                    Course kimya = new Course("Kimya", "KMY101", "KMY");

                    Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
                    Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
                    Teacher t3 = new Teacher("Ali Veli", "90550000002", "KMY");

                    mat.addTeacher(t1);
                    fizik.addTeacher(t2);
                    kimya.addTeacher(t3);

                    Student s1 = new Student("İnek Şaban", 4, "140144015", mat, fizik, kimya);
                    s1.addBulkExamNote(m1, m2, f1, f2, k1, k2);
                    s1.isPass();



    }
}
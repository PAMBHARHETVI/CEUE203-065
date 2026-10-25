import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "Name")
    String name;

    @Column(name = "Age")
    int age;

    @Column(name = "City")
    String city;
}

public class ColumnMapping {

    static Student populate(String[] header, String[] data)
            throws Exception {

        Student student = new Student();

        for (Field field : Student.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {

                Column col = field.getAnnotation(Column.class);
                int index = -1;

                for (int i = 0; i < header.length; i++) {
                    if (header[i].equalsIgnoreCase(col.name())) {
                        index = i;
                        break;
                    }
                }

                if (index == -1 || index >= data.length) {
                    continue;
                }

                field.setAccessible(true);

                if (field.getType() == int.class) {
                    field.setInt(student,
                            Integer.parseInt(data[index]));
                } else {
                    field.set(student, data[index]);
                }
            }
        }

        return student;
    }

    public static void main(String[] args) throws Exception {

        String[] header = {"Name", "Age", "City"};
        String[] data = {"Smit", "20", "Ahmedabad"};

        Student s = populate(header, data);

        System.out.println("Name: " + s.name);
        System.out.println("Age: " + s.age);
        System.out.println("City: " + s.city);
    }
}
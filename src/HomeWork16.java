import homework16.Academy;
import homework16.HelloWorld;
import homework16.Man;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class HomeWork16 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        task1();
        task2();
        task3();
    }

    /*
    Создать класс Man c произвольным набором полей и методов (не менее 3).
    Создать метод, который распечатает информацию о классе (список методов и полей с их типами и доступностью)
    с помощью рефлексии. Вызвать метод с помощью рефлексии из основной программы.
     */
    public static void task1() {
        Class<Man> myClass = Man.class;
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            int modifierField = field.getModifiers();
            System.out.println("Поля : " + field.getName() + " : тип : " + type.getName() + " : доступность : " + Modifier.toString(modifierField));
        }
        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            int modifierMethod = method.getModifiers();
            System.out.println("Метод : " + method.getName() + " : возвращает тип : " + returnType.getName() + " : доступность : " + Modifier.toString(modifierMethod));
        }
    }

    /*
    Создайте класс с методом printHelloWorld(). Вызвать метод с помощью рефлексии из основной программы.
     */
    public static void task2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<HelloWorld> helloWorld = HelloWorld.class;
        Method printHL = helloWorld.getDeclaredMethod("printHelloWorld");
        printHL.invoke(helloWorld);
    }

    /*
    Создать собственную аннотацию @AcademyInfo c полем year.
    Создать метод, помеченный этой аннотацией с заданным year, и метод без нее.
    С помощью рефлексии проверить наличие данной аннотации у этих методов из основной программы.
     */
    public static void task3() {
        Class<Academy> academy = Academy.class;
        Method[] methods = academy.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Academy.AcademyInfo annotation = methods[i].getAnnotation(Academy.AcademyInfo.class);
            if (annotation == null) {
                System.out.println("У метода : " + methods[i].getName() + " - нет аннотаций");
            } else {
                System.out.println("У метода : " + methods[i].getName() + " - есть аннотация с параметром year = " + annotation.year());
            }
        }
    }
}

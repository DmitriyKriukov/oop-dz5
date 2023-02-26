import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in); Socket socket = new Socket("localhost", 1234)) {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println("\nВыберите пункт меню: \n1 - добавить сотрудника \n2 - удалить сотрудника \n" +
                        "3 - изменить данные сотрудника \n4 - показать список сотрудников \n0 - выход.");
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);
                if (request.equals("1")) {
                    System.out.println("Введите имя сотрудника: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите фамилию сотрудника: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите должность сотрудника: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("Введите возраст сотрудника: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                } else if (request.equals("2")) {
                    System.out.println("Введите id сотрудника: ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                } else if (request.equals("3")) {
                    System.out.println("Введите id : ");
                    dataOutputStream.writeUTF(scanner.nextLine());
                    System.out.println("\nВыберите параметр: \n1 - имя \n2 - фамилия \n" +
                            "3 - должность \n4 - возраст.");
                    String request2 = scanner.nextLine();
                    dataOutputStream.writeUTF(request2);
                    if (request2.equals("1")) {
                        System.out.println("Введите имя : ");
                        dataOutputStream.writeUTF(scanner.nextLine());
                    } else if (request2.equals("2")) {
                        System.out.println("Введите фамилию : ");
                        dataOutputStream.writeUTF(scanner.nextLine());
                    } else if (request2.equals("3")) {
                        System.out.println("Введите должность : ");
                        dataOutputStream.writeUTF(scanner.nextLine());
                    } else if (request2.equals("4")) {
                        System.out.println("Введите возраст : ");
                        dataOutputStream.writeUTF(scanner.nextLine());
                    }
                } else if (request.equals("0"))
                    break;


                System.out.println("Получили сообщение от сервера: " + dataInputStream.readUTF());
            }
        } catch (
                UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



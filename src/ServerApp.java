import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    /*
    Создать информационную систему позволяющую работать с сотрудниками некой компании \ студентами вуза \
    учениками школы - добавлять, удалять, изменять данные о сотруднике, выводить информацию о них.
    **Сделать клиент серверную версию, чтобы клиент вводил данные о сотруднике \ студенте \ ученике.
    */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем соединение....");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            Company company = new Company("Best company");

            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("0")) {
                    break;
                }

                else if (clientRequest.equals("1")) {
                    String clientFirstName = dataInputStream.readUTF();
                    String clientLastName = dataInputStream.readUTF();
                    String clientPosition = dataInputStream.readUTF();
                    int clientAge = Integer.parseInt(dataInputStream.readUTF());

                    dataOutputStream.writeUTF(company.addEmployee(clientFirstName, clientLastName,
                            clientPosition, clientAge));

                } else if (clientRequest.equals("2")) {
                    int clientId = Integer.parseInt(dataInputStream.readUTF());
                    dataOutputStream.writeUTF(company.removeEmployee(clientId));

                } else if (clientRequest.equals("3")) {
                    int clientId = Integer.parseInt(dataInputStream.readUTF());
                    Employee employee = company.showEmployee(clientId);
                    String clientRequest2 = dataInputStream.readUTF();
                    if (clientRequest2.equals("1")){
                        String clientFirstName = dataInputStream.readUTF();
                        dataOutputStream.writeUTF(company.changeEmployeeFirstName(employee, clientFirstName));
                    } else if (clientRequest2.equals("2")) {
                        String clientLastName = dataInputStream.readUTF();
                        dataOutputStream.writeUTF(company.changeEmployeeLastName(employee, clientLastName));
                    } else if (clientRequest2.equals("3")) {
                        String clientPosition = dataInputStream.readUTF();
                        dataOutputStream.writeUTF(company.changeEmployeePosition(employee, clientPosition));
                    } else if (clientRequest2.equals("4")) {
                        int clientAge = Integer.parseInt(dataInputStream.readUTF());
                        dataOutputStream.writeUTF(company.changeEmployeeAge(employee, clientAge));
                    } else {
                        dataOutputStream.writeUTF("Некорректный запрос.");
                    }
                } else if (clientRequest.equals("4")) {
                    dataOutputStream.writeUTF(company.showEmployeeList());

                } else {
                    dataOutputStream.writeUTF("Некорректный запрос.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
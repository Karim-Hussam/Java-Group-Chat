import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	// Listen to incoming connection or client by creating socket object
	private ServerSocket serverSocket;
	
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	
	public void startServer() {
		
		
		try {
			
			while (!serverSocket.isClosed())
			{
				Socket socket = serverSocket.accept();
				System.out.println("A new member has landed !!");
				System.out.println("Say Welcome !");
				ClientHandler clientHandeler = new ClientHandler(socket);
				
				Thread thread = new Thread(clientHandeler);
				thread.start();
			}
			
		} 
		catch (IOException e) {
			
		}
		
	}
	
	public void closeServerSocket() {
		try {
			if (serverSocket != null)
			{
				serverSocket.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(1234);
		Server server = new Server(serverSocket);
		server.startServer();
		
	}
	
}

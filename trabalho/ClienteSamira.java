import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSamira{
    public static void main(String[] args) {
        String enderecoServidor = "10.130.129.103"; 
        int portaServidor = 12345; 
        String mensagemCodificada = "MjAwMg=="; 

        String respostaDoServidor = null; 

        try (Socket socket = new Socket(enderecoServidor, portaServidor);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // a mensagem para o servidor
            out.println(mensagemCodificada);

            // a resposta do servidor
            respostaDoServidor = in.readLine();

            // a resposta do servidor
            System.out.println("Resposta do servidor: " + respostaDoServidor);


        } catch (IOException e) {
            System.err.println("Erro ao se conectar ao servidor: " + e.getMessage());
        }
    }
}

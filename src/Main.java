import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Usuário realizando o cadasto dos livros
        List<Livro> livros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //Informado o caminho do arquivo que irá conter os livros cadastrados
        Path arquivo = Paths.get("AcervoDeLivros.txt");

        try {
            //Inserção dos dados via terminal
            System.out.print("Informe a quatidade de livros a ser cadastrada: ");
            int quatidadeLivros = scanner.nextInt();

            for (int i = 0; i < quatidadeLivros; i++) {
                System.out.print("Digite o título do Livro: ");
                String titulo = scanner.next();
                System.out.print("Digite o autor do Livro: ");
                String autor = scanner.next();
                System.out.print("Digite o editora do Livro: ");
                String editora = scanner.next();
                System.out.print("Digite o status do Livro (disponível/emprestado): ");
                String status = scanner.next();

                Livro livro = new Livro(titulo, autor, editora, status);
                livros.add(livro);

                Files.writeString(arquivo, livros.get(i).getTitulo(), StandardOpenOption.APPEND);
                Files.writeString(arquivo, "\n", StandardOpenOption.APPEND);
                Files.writeString(arquivo, livros.get(i).getAutor(), StandardOpenOption.APPEND);
                Files.writeString(arquivo, "\n", StandardOpenOption.APPEND);
                Files.writeString(arquivo, livros.get(i).getEditora(), StandardOpenOption.APPEND);
                Files.writeString(arquivo, "\n", StandardOpenOption.APPEND);
                Files.writeString(arquivo, livros.get(i).getStatus(), StandardOpenOption.APPEND);
                Files.writeString(arquivo, "\n", StandardOpenOption.APPEND);
                Files.writeString(arquivo, "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Lendo as informações do arquivo
        try {
            String conteudo = Files.readString(arquivo);
            System.out.println(conteudo);
        } catch (IOException f) {
            f.printStackTrace();
        }

        // update
        Livro novoLivro = new Livro("Titulonovo", "Autornovo", "EditoraNova", "disponivel");
        String tituloAntigo = "TituloAntigo";
        try {
            //Leitura de todas as linhas do arquivo
            List<String> linhas = Files.readAllLines(arquivo);

            // Novas linhas para a atualização
            List<String> novasLinhas = new ArrayList<>();

            // v.a para ver se encontrou ou nao
            boolean found = false;

            for (int i = 0; i < linhas.size(); i += 5) { // 5 linhas por livro (4 informações + 1 linha em branco)
                String titulo = linhas.get(i);
                if (titulo.equalsIgnoreCase(tituloAntigo)) {
                    found = true;
                    novasLinhas.add(novoLivro.getTitulo());
                    novasLinhas.add(novoLivro.getAutor());
                    novasLinhas.add(novoLivro.getEditora());
                    novasLinhas.add(novoLivro.getStatus());
                    novasLinhas.add(""); // linha em branco
                } else {
                    novasLinhas.add(linhas.get(i));     // Título
                    novasLinhas.add(linhas.get(i + 1)); // Autor
                    novasLinhas.add(linhas.get(i + 2)); // Editora
                    novasLinhas.add(linhas.get(i + 3)); // Status
                    novasLinhas.add(linhas.get(i + 4)); // linha em branco
                }
            }

            if (found) {
                Files.write(arquivo, novasLinhas, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Livro atualizado com sucesso.");
            } else {
                System.out.println("Livro não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    //delete
    // Primeiro vamos ler todas as linhas do arquivo
        try

    {
        List<String> linhas = Files.readAllLines(arquivo);

        System.out.println("Digite o título do livro a ser lido:");
        String titulo = scanner.next();

        boolean found = false;
        Livro livro = null;
        for (int i = 0; i < livros.size(); i++) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                found = true;
                livros.remove(i);
                break;
            }
        }
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }
}

}
        //CRUD
        //Create
        // Read
        //U = Update
        //D = delete


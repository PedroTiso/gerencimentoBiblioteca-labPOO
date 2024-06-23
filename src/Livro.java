public class Livro{
    private String titulo;
    private String autor;
    private String editora;
    private String status;

    public Livro(String titulo, String autor, String editora, String status) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getStatus() {
        return status;
    }


    //CRUD - C = Create R=Read, U=Update, D=Delete
}

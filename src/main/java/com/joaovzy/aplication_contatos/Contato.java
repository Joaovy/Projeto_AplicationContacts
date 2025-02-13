package com.joaovzy.aplication_contatos;

/*  Padrão JavaBeans
diz que as propriedades eu não posso deixar as propriedades publicas e sim
privadas
 */
public class Contato {
    private String nome;

    private String telefone;

    private String id;
    /* utilizando private você só consegue utilizar um metodo que
    esta dentro da classe contato, e alem de ser uma boa pratica!!
     */

    public Contato(){

    }

    // COnstrutor:
    public Contato(String nome, String telefone, String id){

        this.nome = nome;
        this.telefone = telefone;
        this.id = id;

    }

    public boolean isNovo(){
    return id == null;
      // Perguntando se id esta com valor!
      // pois essa propriedade é quem vai dar um retorno
      // para quando você der um valor ou removelo
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

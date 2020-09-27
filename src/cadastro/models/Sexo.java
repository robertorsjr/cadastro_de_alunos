package cadastro.models;

public enum  Sexo {
    MASCULINO("Masculino"),FEMININO("Feminino"),OUTRO("Outro");

    private String descricao;

    Sexo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}

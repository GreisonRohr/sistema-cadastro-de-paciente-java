import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Paciente {
	
	
    private int codigo;
    private String nome;
    private String idade;
    private String diagnostico;
    private String tratamento;
    private String nomeArq;
    
    
   

   
    
    public Paciente(int codigo, String nome, String idade, String diagnostico,String tratamento) {
    	this.codigo =  codigo;       
    	this.nome =  nome;       
    	this.idade =  idade;       
    	this.diagnostico =  diagnostico;       
    	this.tratamento =  tratamento;       

    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
    
    public void Arquivo(String nomeArq) {
    	this.nomeArq =  nomeArq;       

    }
    
    	public String getNomeArq() {
            return nomeArq;
        }

        public void setNomeArq(String nomeArq) {
            this.nomeArq = nomeArq;
        }
    	
    
    
   

    	
    
}


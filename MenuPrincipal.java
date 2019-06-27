
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MenuPrincipal extends JFrame {
	
	protected JFileChooser localArquivo = new JFileChooser();

	
	public JPanel contentPane;
	String d;
	public static ArrayList<String> ler = new ArrayList<String>();

	public static ArrayList<Paciente> paciente = new ArrayList<Paciente>();
	
	public MenuPrincipal(){
		
		super("Menu");
		setBackground(Color.WHITE);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		//cria o menu de botoes
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		//cria os botoes 
		JButton b1 = new JButton("Cadastrar");
		JButton b2 = new JButton("Listar");
		JButton b3 = new JButton("Editar");
		JButton b4 = new JButton("Excluir");
		JButton b5 = new JButton("Sair");
		JButton b6 = new JButton("Salvar Arquivo");
		JButton b7 = new JButton("Carregar Arquivo");
		JButton b8 = new JButton("Média de idade");


       


		
		//adiciona as funçoes dos botoes menu
		
		barraMenu.add(b6);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salvar();
				
				
				}
			});
		
		barraMenu.add(b7);
		b7.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) { // açao do comando abrir
				//Abre uma caixa de diálogo do seletor de arquivos "Abrir Arquivo". 
				if(localArquivo.showOpenDialog(getParent())== JFileChooser.APPROVE_OPTION) {
					Abrir(localArquivo.getSelectedFile().getAbsolutePath()); //executa o metodo abrir arquivo passando os parametros do arquivo selecionado 
				}
			}	
		
			});
		
		barraMenu.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro abrir = new Cadastro( );
				
				abrir.setVisible(true);
				
				}
			});
	    barraMenu.add(b2);
	    b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listar abrir = new Listar( );
				
				abrir.setVisible(true);
				
				}
			});
		barraMenu.add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Editar abrir = new Editar( );
				
				abrir.setVisible(true);
				
				}
			});
		barraMenu.add(b4);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Excluir abrir = new Excluir( );
				
				abrir.setVisible(true);
				
				}
			});
		
		
		barraMenu.add(b8);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MediaIdade( );
				
					
				
				
				}
			});
		
		
		barraMenu.add(b5);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			});
		
		
		
		//altera cor dos botoes
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		b6.setBackground(Color.white);
		b7.setBackground(Color.white);
		b8.setBackground(Color.white);

		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//adiciona imagem
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Cliente\\Desktop\\SistemaGerenciador\\logofaccat.png"));
		//adiciona nome na tela 
		JLabel lblGreisonRohr = new JLabel("Greison Rohr");
		// altera cor da fonte
		lblGreisonRohr.setForeground(Color.WHITE);
		lblGreisonRohr.setBackground(Color.WHITE);
		
		//posiciona imagem e nome 
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		contentPane.add(lblGreisonRohr, BorderLayout.SOUTH);
		
		// cria cor 
		Color azulEscuro = new Color(0, 56, 120); 
		// altera cor de fundo
		contentPane.setBackground(azulEscuro);
		
		
		
		// finaliza o programa ao fechar a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		// posiçao da janela ao abrir o programa
		setBounds(400, 200, 444, 315);
		// faz a janela do programa ficar visivel
		setVisible(true);
		
		
	
	}
	
	
	
	
	//Funçao de salvar os dados em arquivo txt
	public void Salvar() {
    	
		int cod;
    	String nome;
    	String idade;
    	String diagnostico;
    	String tratamento;
        

    	if(localArquivo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					FileWriter escreverArquivo = new FileWriter(localArquivo.getSelectedFile().getAbsolutePath()+".txt");
					BufferedWriter bw = new BufferedWriter(escreverArquivo);
		        	PrintWriter pw = new PrintWriter(bw);
					for(int i=0; i<MenuPrincipal.paciente.size(); i++){
						// adiciona os registros em uma variavel para escrever no arquivo
						cod = MenuPrincipal.paciente.get(i).getCodigo();
			        	nome = MenuPrincipal.paciente.get(i).getNome();
			        	idade = MenuPrincipal.paciente.get(i).getIdade();
			        	diagnostico = MenuPrincipal.paciente.get(i).getDiagnostico();
			        	tratamento = MenuPrincipal.paciente.get(i).getTratamento();
			        	
			        	pw.print(cod);
			        	pw.print("| "+nome);
			        	pw.print("| "+idade);	
			        	pw.print("| "+diagnostico);
						pw.println("| "+tratamento);
						
					}
					bw.close();
					pw.close();
					
					

				}catch(Exception e) {
	
				}
				
				


    	}
    }
	// funçao para abrir arquivo
	public void Abrir(String nomeArquivo) {
		try {
			FileReader lerArquivo = new FileReader(nomeArquivo);// cria uma variavel de leitura para arquivos de caracteres, e ja recebe o arquivo selecionado.
            BufferedReader br = new BufferedReader(lerArquivo);

            String dados;
            while (br.ready()) {
                dados = br.readLine();
                ler.add(dados);

               
 
            }
            
			lerArquivo.close();//Fecha o fluxo do FileReader libera quaisquer recursos do sistema associados a ele. 
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo"); //retorna erro caso ocorra algum problema com os comandos dentro do bloco
		}
		
		for(int i=0; i<MenuPrincipal.ler.size(); i++){
			
			d = ler.get(i);
			
			System.out.println(d);
		}
		

		
		
	}

	

	// funçao para calcular a media de idade 
	 public void MediaIdade() {
			String cont =null;

			float conta = 0, c= 0;

			for(int i=0; i<MenuPrincipal.paciente.size(); i++){
				
				cont = MenuPrincipal.paciente.get(i).getIdade();
				conta += Integer.parseInt(cont);
				c++;
	
		}
			conta = conta / c;
			JOptionPane.showMessageDialog(null, "Media de idade = "+conta);
		
			
		}
	
	public static void main(String[] args) {
		
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				
			}
		
	
	
}
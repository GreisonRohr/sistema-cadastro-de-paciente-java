 import java.awt.Dimension;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
    import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.JTextField;
    import javax.swing.WindowConstants;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
     
     
    public class Cadastro extends JFrame {
    	
    	
    	
    		protected JFileChooser localArquivo = new JFileChooser();
    		
    		//cria as caixas de texto, para captura do usuario
			private JTextField jtf_nome;
            private JTextField jtf_idade;
            private JTextField jtf_diagnostico;
            private JTextField jtf_tratamento;
           
            //cria botoes
            private JButton incluir;
            private JButton limpar;
           
            //cria tabela
            private JTable table;
           
            private JScrollPane jsp;
           
            private JPanel main;
            private JPanel dados;
            private JPanel tableDados;
           
            private JLabel label;
            int auto=0;
          
            public Cadastro() {
            	
            	
                    main = new JPanel();
                    dados = new JPanel();
                    tableDados = new JPanel();
                    main.setLayout(new GridLayout(0, 1, 0, 0));
                   
                    main.add(dados);
                    dados.setLayout(new CardLayout(0, 0));
                    jsp = new JScrollPane();
                    dados.add(jsp, "name_8693853272904");
                    table= new JTable();
                    table.setModel(new MinhaTableModel(new String[]{"Codigo","Nome", "Idade", "Diagnostico","Tratamento"}, MenuPrincipal.paciente.size(), 5));
                    jsp.setViewportView(table);
                    
                    label = new JLabel("");
                    jsp.setColumnHeaderView(label);
                    main.add(tableDados);
                    tableDados.setLayout(null);
                    
                    //nome das caixas de texto / e posicionamento
                    JLabel label_1 = new JLabel("Nome:");
                    label_1.setBounds(29, 25, 83, 14);
                    tableDados.add(label_1);
                    
                    jtf_nome = new JTextField(15);
                    jtf_nome.setBounds(122, 22, 249, 20);
                    tableDados.add(jtf_nome);
                    JLabel label_2 = new JLabel("Idade:");
                    label_2.setBounds(29, 66, 59, 14);
                    tableDados.add(label_2);
                    jtf_idade= new JTextField(15);
                    jtf_idade.setBounds(122, 63, 83, 20);
                    tableDados.add(jtf_idade);
                    JLabel label_3 = new JLabel("Diagnostico:");
                    label_3.setBounds(29, 133, 106, 14);
                    tableDados.add(label_3);
                    jtf_diagnostico = new JTextField(15);
                    jtf_diagnostico.setBounds(122, 110, 249, 60);
                    tableDados.add(jtf_diagnostico);
                    JLabel label_4 = new JLabel("Tratamento:");
                    label_4.setBounds(29, 208, 93, 14);
                    tableDados.add(label_4);
                    jtf_tratamento = new JTextField(15);
                    jtf_tratamento.setBounds(122, 185, 249, 60);
                    tableDados.add(jtf_tratamento);
                    
                    //botoes
                    limpar = new JButton("Limpar");
                    limpar.setBounds(403, 297, 83, 23);
                    tableDados.add(limpar);
                    
                    incluir = new JButton("Incluir");
                    incluir.setBounds(496, 297, 78, 23);
                    tableDados.add(incluir);
                   
                    this.setContentPane(main);
                    this.setSize(600,700);
                    this.setVisible(true);
                   
                    //tabela
                    table.setModel(new MinhaTableModel(new String[]{"Codigo","Nome", "Idade", "Diagnostico","Tratamento"}, MenuPrincipal.paciente.size(), 5));
                    for(int i=0; i<MenuPrincipal.paciente.size(); i++){
                    	table.setValueAt(MenuPrincipal.paciente.get(i).getCodigo(), i, 0);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getNome(), i, 1);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getIdade(), i, 2);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getDiagnostico(), i, 3);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getTratamento(), i, 4);
                        
                        auto = MenuPrincipal.paciente.get(i).getCodigo();
                        
                        	auto=auto+1;
                        	
                        

                    }
                   
                    jsp.setViewportView(table);
                    jsp.setAutoscrolls(true);
                    table.setAutoCreateRowSorter(true);
            
            
           // adiciona o cadastro no arraylist paciente
                    incluir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                    if(jtf_nome!=null && jtf_nome.getText().equals("")==true){
                                            JOptionPane.showMessageDialog(null, "Digite o nome");
                                    }
                                    else if(jtf_idade!=null && jtf_idade.getText().equals("")==true){
                                            JOptionPane.showMessageDialog(null, "Digite a idade");
                                    }
                                    else if(jtf_diagnostico!=null && jtf_diagnostico.getText().equals("")==true){
                                            JOptionPane.showMessageDialog(null, "Digite o diagnostico");
                                    }
                                    else if(jtf_tratamento!=null && jtf_tratamento.getText().equals("")==true){
                                        JOptionPane.showMessageDialog(null, "Digite a idade");
                                }
                        
                                    else{
                                    	
                                    	
                                    	                                    	
                                    		MenuPrincipal.paciente.add(new Paciente(auto++,jtf_nome.getText(), jtf_idade.getText(), jtf_diagnostico.getText(),jtf_tratamento.getText()));

                                        	limpar();
                                                
                                        	listar();
                                    	

                                            
                                    }
                            }
     
                           
                    });
                    //açoes dos botoes
                    limpar.addActionListener(new ActionListener() {
                           
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                    limpar();
                            }
                    });
            }
           // limpa as caixas de texto
            private void limpar() {
                    jtf_nome.setText("");
                    jtf_idade.setText("");
                    jtf_diagnostico.setText("");
                    jtf_tratamento.setText("");

                   
            }
           // lista os pacientes em uma tabela
            private void listar() {
                table.setModel(new MinhaTableModel(new String[]{"Codigo","Nome", "Idade", "Diagnostico","Tratamento"}, MenuPrincipal.paciente.size(), 5));
                    for(int i=0; i<MenuPrincipal.paciente.size(); i++){
                    	table.setValueAt(MenuPrincipal.paciente.get(i).getCodigo(), i, 0);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getNome(), i, 1);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getIdade(), i, 2);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getDiagnostico(), i, 3);
                        table.setValueAt(MenuPrincipal.paciente.get(i).getTratamento(), i, 4);

                    }
                   
                    jsp.setViewportView(table);
                    jsp.setAutoscrolls(true);
                    table.setAutoCreateRowSorter(true);
                   
            }
    }
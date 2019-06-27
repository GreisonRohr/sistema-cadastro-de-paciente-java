 import java.awt.Dimension;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.JTextField;
    import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
     
     
    public class Listar extends JFrame {
           
            private JTable table;
            private JScrollPane jsp;
           
            private JPanel main;
            private JPanel dados;
           
            private JLabel label;
           
            public Listar(){
                    main = new JPanel();
                    dados = new JPanel();
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
                   
                    this.setContentPane(main);
                    this.setSize(600,700);
                    this.setVisible(true);
           
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
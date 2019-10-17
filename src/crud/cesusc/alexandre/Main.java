package crud.cesusc.alexandre;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Main {

	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
	private static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	public static void salvarCadastro(){

        String relatoriocliente = " ";
        String relatoriomercadoria = " ";
        String relatoriofornecedor = " ";
        
        for (int i = 0; i < clientes.size(); i++){

            Cliente cadastro = clientes.get(i);

            relatoriocliente += cadastro.getNome() + " - " + cadastro.getCpf() + " ; ";
        }
        
        for (int i = 0; i < mercadorias.size(); i++){

            Mercadoria cadastro = mercadorias.get(i);

            relatoriomercadoria += cadastro.getNomemercadoria() + " - " + cadastro.getPeso() + " ; ";
        }
        
        for (int i = 0; i < fornecedores.size(); i++){

            Fornecedor cadastro = fornecedores.get(i);

            relatoriofornecedor += cadastro.getNomefornecedor() + " ; ";
        }

        try {

            FileWriter arquivo = new FileWriter("arquivo.txt");
            BufferedWriter escritor = new BufferedWriter(arquivo);

            escritor.write(relatoriocliente);
            escritor.write(relatoriomercadoria);
            escritor.write(relatoriofornecedor);
            escritor.close();
            arquivo.close();

        }catch(IOException erro){

        }
    }
	
	public static void main(String[] args) {
	
		String tela = "Escolha a opção: "
                + "\n 1) Realizar cadastro cliente"
                + "\n 2) Realizar cadastro mercadoria"
                + "\n 3) Realizar cadastro fornecedor"
                + "\n 4) Listar cadastros"
                + "\n 5) Alterar cadastro (cliente)"
                + "\n 6) Alterar cadastro (mercadoria)"
                + "\n 7) Alterar cadastro (fornecedor)"
                + "\n 8) Apagar cadastros"
                + "\n 9) Sair";
		
		String opcao = " ";
		
		do {
            opcao = JOptionPane.showInputDialog(tela);

            if (opcao.equals("1")) {
                cadastrarCliente();
            }
            if (opcao.equals("2")) {
                cadastrarMercadoria();
            }
            if (opcao.equals("3")) {
                cadastrarFornecedor();
            }
            if (opcao.equals("4")) {
                listarCadastros();
            }
            if (opcao.equals("5")) {
                alterarCliente();
            }
            if (opcao.equals("6")) {
                alterarMercadoria();
            }
            if (opcao.equals("7")) {
                alterarFornecedor();
            }
            if (opcao.equals("8")) {
                apagarCadastro();
            }
            if (opcao.equals("9")) {
                salvarCadastro();
            }


        } while (!opcao.equals("9"));
    }
	
	/*Início Está atualizado para o DB de Transportadora*/
	private static void cadastrarCliente() {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente");
		String cpfCliente = JOptionPane.showInputDialog("Digite o cpf do cliente");
		
		Cliente novoCliente = new Cliente(nomeCliente,cpfCliente);	
		
		clientes.add(novoCliente);
		
		try {
			conn = Conexao.getConnection();

			pst = conn.prepareStatement("INSERT into public.cliente(nomeCliente, cpfCliente) values(?, ?)");
			
			pst.setString(1, nomeCliente);
			pst.setString(2, cpfCliente);
			pst.executeUpdate();
			
			System.out.println("Cadastro realizado com sucesso");
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
		}

	}
	/*Fim Está atualizado para o DB de Transportadora*/
	
	/*Início Está atualizado para o DB de Transportadora*/
	private static void cadastrarMercadoria() {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String nomeMercadoria = JOptionPane.showInputDialog("Digite o produto");
		String pesoMercadoria = JOptionPane.showInputDialog("Digite o peso do produto");
		
		Mercadoria novaMercadoria = new Mercadoria(nomeMercadoria,pesoMercadoria);
		
		mercadorias.add(novaMercadoria);
		
		try {
			
			conn = Conexao.getConnection();
			
			pst = conn.prepareStatement("INSERT into public.mercadoria(nomeMercadoria, pesoMercadoria) values(?, ?)");
			
			pst.setString(1, nomeMercadoria);
			pst.setString(2, pesoMercadoria);
			pst.executeUpdate();
			
			System.out.println("Cadastro realizado com sucesso");
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
		}
	}
	/*Fim Está atualizado para o DB de Transportadora*/
	
	/*Início Está atualizado para o DB de Transportadora*/
	private static void cadastrarFornecedor() {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String nomeFornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor");
		
		Fornecedor novoFornecedor = new Fornecedor(nomeFornecedor);
		
		fornecedores.add(novoFornecedor);
		
		try {
			
			conn = Conexao.getConnection();
			
			pst = conn.prepareStatement("INSERT into public.fornecedor(nomefornecedor) values(?)");
			
			pst.setString(1, nomeFornecedor);
			pst.executeUpdate();
			
			System.out.println("Cadastro realizado com sucesso");
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
		}
	}
	/*Fim Está atualizado para o DB de Transportadora*/
	
	
	private static void listarCadastros() {

        String relatoriocliente = " ";
        String relatoriomercadoria = " ";
        String relatoriofornecedor = " ";

        for (int i = 0; i < clientes.size(); i++) {

            Cliente cadastroProvisorio = clientes.get(i);

            relatoriocliente += cadastroProvisorio.getNome() + " - "
                    + cadastroProvisorio.getCpf() + " ; ";

        }
        
        for (int i = 0; i < mercadorias.size(); i++) {

            Mercadoria cadastroProvisorio = mercadorias.get(i);

            relatoriomercadoria += cadastroProvisorio.getNomemercadoria() + " - "
                    + cadastroProvisorio.getPeso() + " ; ";

        }
        
        for (int i = 0; i < fornecedores.size(); i++) {

            Fornecedor cadastroProvisorio = fornecedores.get(i);

            relatoriofornecedor += cadastroProvisorio.getNomefornecedor() + " ; ";
        }

        JOptionPane.showMessageDialog(null, relatoriocliente, "Clientes cadastrados", 1);
        JOptionPane.showMessageDialog(null, relatoriomercadoria,"Mercadorias cadastradas", 1);
        JOptionPane.showMessageDialog(null,relatoriofornecedor, "Fornecedores cadastrados", 1);
    }
	
	private static void alterarCliente() {
		
		Connection conn = null;
		PreparedStatement pst = null;

        String nomeCliente = JOptionPane.showInputDialog("Digite um nome para edição: ");
        

        for (int i = 0; i < clientes.size(); i++) {

            Cliente cadastroProvisorio = clientes.get(i);

            if (cadastroProvisorio.getNome().equals(nomeCliente)) {
            	
            	JOptionPane.showMessageDialog(null, "Cadastro encontrado!");

                cadastroProvisorio.setNome(JOptionPane.showInputDialog("Digite um novo nome"));
                
                try {
        			
        			conn = Conexao.getConnection();
        			
        			pst = conn.prepareStatement("UPDATE public.cliente SET nomecliente = '?'  WHERE nomeCliente = '?'");
        			
        			
        			pst.setString(1, nomeCliente);
        			///pst.setString(2, cadastroProvisorio);	
        			
        			pst.executeUpdate();
        			
        			System.out.println("Cadastro alterado com sucesso");
        			
        		}catch (Exception e) {
        			e.printStackTrace();
        			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
        		}
                
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
                break;
            }
        }
    }
	
	private static void alterarMercadoria() {
		
		Connection conn = null;
		PreparedStatement pst = null;

        String nomeMercadoria = JOptionPane.showInputDialog("Digite um nome da mercadoria para edição: ");

        for (int i = 0; i < mercadorias.size(); i++) {

            Mercadoria cadastroProvisorio = mercadorias.get(i);

            if (cadastroProvisorio.getNomemercadoria().equals(nomeMercadoria)) {
            	
            	JOptionPane.showMessageDialog(null, "Cadastro encontrado!");

                cadastroProvisorio.setNomemercadoria(JOptionPane.showInputDialog("Digite um novo nome"));
                
                try {
        			
        			conn = Conexao.getConnection();
        			
        			pst = conn.prepareStatement("UPDATE public.mercadoria SET nomemercadoria = '?'  WHERE nomemercadoria = '?'");
        			
        			pst.setString(1, nomeMercadoria);
        			///pst.setString(2, cadastroProvisorio);
        			
        			pst.executeUpdate();
        			
        			System.out.println("Cadastro alterado com sucesso");
        			
        		}catch (Exception e) {
        			e.printStackTrace();
        			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
        		}
                
                
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
                break;
            }
        }
    }
	
	private static void alterarFornecedor() {
		
		Connection conn = null;
		PreparedStatement pst = null;

        String nomeFornecedor = JOptionPane.showInputDialog("Digite um nome de fornecedor para edição: ");

        for (int i = 0; i < fornecedores.size(); i++) {

            Fornecedor cadastroProvisorio = fornecedores.get(i);

            if (cadastroProvisorio.getNomefornecedor().equals(nomeFornecedor)) {
            	
            	JOptionPane.showMessageDialog(null, "Cadastro encontrado!");

                cadastroProvisorio.setNomefornecedor(JOptionPane.showInputDialog("Digite um novo nome"));
                
                try {
        			
        			conn = Conexao.getConnection();
        			
        			pst = conn.prepareStatement("UPDATE public.fornecedor SET nomefornecedor = '?'  WHERE nomefornecedor = '?'");
        			
        			pst.setString(1, nomeFornecedor);
        			///pst.setString(2, cadastroProvisorio);
        			
        			pst.executeUpdate();
        			
        			System.out.println("Cadastro alterado com sucesso");
        			
        		}catch (Exception e) {
        			e.printStackTrace();
        			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
        		}
                
                
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
                break;
            }
        }
    }
	
	private static void apagarCadastro(){
		
		Connection conn = null;
		PreparedStatement pst = null;
		
        try {
			
 			conn = Conexao.getConnection();
 			
 			pst = conn.prepareStatement("DELETE FROM public.cliente;");
 			pst = conn.prepareStatement("DELETE FROM public.mercadoria;");
 			pst = conn.prepareStatement("DELETE FROM public.fornecedor;");
 			
 			pst.executeUpdate();
 			
 			System.out.println("Cadastros removidos com sucesso");
 			
 		}catch (Exception e) {
 			e.printStackTrace();
 			JOptionPane.showMessageDialog(null,"Erro durante o cadastro");
 		}

        clientes.clear();
        mercadorias.clear();
        fornecedores.clear();
      
        JOptionPane.showMessageDialog(null, "Cadastros apagados com sucesso!");
    }
}

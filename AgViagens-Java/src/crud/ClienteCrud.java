package crud;

import java.util.Scanner;

import dao.AcessoDAO;
import dao.ClienteDAO;
import modelo.Acesso;
import modelo.Cliente;

public class ClienteCrud {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		AcessoDAO acessoDAO = new AcessoDAO();
		Cliente cliente = new Cliente();

		Scanner entrada = new Scanner(System.in);
		int opcao, id = 0, id_acesso = 0;
		String nome, email, senha, cpf = "";

		do {

			System.out.println("===== CRUD CLIENTE =====");
			System.out.println("1 - Cadastro de cliente");
			System.out.println("2 - Excluir cliente");
			System.out.println("3 - Atualizar cliente");
			System.out.println("4 - Mostrar clientes");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				System.out.println("Digite o nome: ");
				nome = entrada.next();
				cliente.getNome();
				System.out.println("Digite o email: ");
				email = entrada.next();
				cliente.setEmail(email);
				System.out.println("Digite a senha: ");
				senha = entrada.next();
				cliente.setSenha(senha);
				System.out.println("Digite o CPF: ");
				cpf = entrada.next();
				cliente.setCpf(cpf);
				System.out.println("Digite o id de acesso: ");
				id_acesso = entrada.nextInt();
				Acesso acesso = acessoDAO.getAcessoById(id_acesso);

				Cliente cli = new Cliente(id, nome, email, senha, cpf, acesso);
				clienteDAO.save(cli);

				break;
			}
			case 2: {
				System.out.println("Digite o ID do cliente para exclusao: ");

				id = entrada.nextInt();

				clienteDAO.deleteById(id);
				break;
			}
			case 3: {

				System.out.println("Digite o ID do cliente para atualizar: ");

				id = entrada.nextInt();

				System.out.println("Digite o nome: ");
				nome = entrada.next();

				System.out.println("Digite o email: ");
				email = entrada.next();

				System.out.println("Digite a senha: ");
				senha = entrada.next();

				System.out.println("Digite o CPF: ");
				cpf = entrada.next();

				System.out.println("Digite o id de acesso: ");
				id_acesso = entrada.nextInt();
				Acesso acesso1 = acessoDAO.getAcessoById(id_acesso);

				Cliente cli1 = new Cliente(id, nome, email, senha, cpf, acesso1);
				clienteDAO.update(cli1);

				break;
			}
			case 4: {
				for (Cliente c : clienteDAO.getCliente()) {
					System.out.println("Id: " + c.getId() + " Nome: " + c.getNome() + " Email: " + c.getEmail()
							+ " Senha: " + c.getSenha() + " CPF:" + c.getCpf());
				}

				System.out.println("----------------------------------- ");
			}
				break;

			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int iD = entrada.nextInt();

				Cliente c = clienteDAO.getClienteById(iD);

				System.out.println("Nome: " + c.getNome() + " Email: " + c.getEmail() + " Senha: " + c.getSenha()
						+ "CPF: " + c.getCpf());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Até Logo! === ");
				break;
			}
			default:
				System.out.println(opcao != 6 ? "opção invalida, digite novamente." : "");

			}
			;

		} while (opcao != 6);

		entrada.close();

	}
}

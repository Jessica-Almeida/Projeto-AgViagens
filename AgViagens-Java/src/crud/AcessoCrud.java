package crud;

import java.util.Scanner;

import dao.AcessoDAO;
import modelo.Acesso;

public class AcessoCrud {

	public static void main(String args[]) {

		AcessoDAO acessoDAO = new AcessoDAO();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String tipo = "";
		int id = 0;

		do {

			System.out.println("===== CRUD ACESSO =====");
			System.out.println("1 - Cadastro de acesso");
			System.out.println("2 - Excluir acesso");
			System.out.println("3 - Atualizar acesso");
			System.out.println("4 - Mostrar acessos");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o tipo de acesso: ");
				tipo = entrada.next();

				Acesso a1 = new Acesso(id, tipo);
				acessoDAO.save(a1);

				break;
			}
			case 2: {
				System.out.println("Digite o ID do acesso para exclusao: ");
				id = entrada.nextInt();

				acessoDAO.deleteById(id);

				break;
			}
			case 3: {

				System.out.println("Digite o ID do acesso para atualizar: ");
				id = entrada.nextInt();
				System.out.println("Digite o novo tipo de acesso: ");
				tipo = entrada.next();

				Acesso a2 = new Acesso(id, tipo);
				acessoDAO.update(a2);
				break;
			}
			case 4: {
				for (Acesso a : acessoDAO.getAcesso()) {

					System.out.println("Id: " + a.getId() + " Tipo: " + a.getTipo());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int iD = entrada.nextInt();

				Acesso a3 = acessoDAO.getAcessoById(iD);

				System.out.println("Tipo: " + a3.getTipo());

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

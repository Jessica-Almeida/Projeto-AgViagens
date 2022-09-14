package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import modelo.Destino;

public class DestinoCrud {

	public static void main(String args[]) {

		DestinoDAO destinoDAO = new DestinoDAO();

		Scanner entrada = new Scanner(System.in);
		int opcao, id = 0;
		String pais, cidade, dataIda, dataVolta = "";
		double preco = 0;

		do {

			System.out.println("===== CRUD DESTINO =====");
			System.out.println("1 - Cadastro de destino");
			System.out.println("2 - Excluir destino");
			System.out.println("3 - Atualizar destino");
			System.out.println("4 - Mostrar destinos");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o País: ");
				entrada.nextLine();
				pais = entrada.nextLine();
				System.out.println("Digite a Cidade: ");
				cidade = entrada.nextLine();
				System.out.println("Digite a data de ida: ");
				dataIda = entrada.next();
				System.out.println("Digite a data de volta: ");
				dataVolta = entrada.next();
				System.out.println("Digite o preço do destino: ");
				preco = entrada.nextDouble();

				Destino d1 = new Destino(id, pais, cidade, dataIda, dataVolta, preco);
				destinoDAO.save(d1);

				break;
			}
			case 2: {
				System.out.println("Digite o ID do destino para exclusao: ");
				id = entrada.nextInt();

				destinoDAO.deleteById(id);

				break;
			}
			case 3: {

				System.out.println("Digite o ID do destino para atualizar: ");
				id = entrada.nextInt();
				System.out.println("Digite o novo País: ");
				entrada.nextLine();
				pais = entrada.nextLine();
				System.out.println("Digite a nova Cidade: ");
				cidade = entrada.nextLine();
				System.out.println("Digite a nova data de ida: ");
				dataIda = entrada.next();
				System.out.println("Digite a nova data de volta: ");
				dataVolta = entrada.next();
				System.out.println("Digite o novo preço do destino: ");
				preco = entrada.nextDouble();

				Destino d2 = new Destino(id, pais, cidade, dataIda, dataVolta, preco);
				destinoDAO.update(d2);

				break;
			}
			case 4: {
				for (Destino d : destinoDAO.getDestino()) {

					System.out.println("Id: " + d.getId() + " País: " + d.getPais() + " Cidade: " + d.getCidade()
							+ " Data de ida: " + d.getDataIda() + " Data de volta: " + d.getDataVolta() + " Preço: "
							+ d.getPreco());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int iD = entrada.nextInt();

				Destino d3 = destinoDAO.getDestinoById(iD);

				System.out.println("País: " + d3.getPais() + " Cidade: " + d3.getCidade() + " Data de ida: "
						+ d3.getDataIda() + " Data de volta: " + d3.getDataVolta() + " Preço: " + d3.getPreco());

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

		} while (opcao != 6);

		entrada.close();

	}
}

package crud;

import java.util.Date;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DestinoDAO;
import modelo.Cliente;
import modelo.Compra;
import modelo.Destino;

public class CompraCrud {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		CompraDAO compraDAO = new CompraDAO();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0, id = 0, idCliente = 0, idDestino = 0, qnt = 0;

		do {
			System.out.println("===== CRUD CLIENTE =====");
			System.out.println("1 - Cadastro de compra");
			System.out.println("2 - Excluir compra");
			System.out.println("3 - Atualizar compra");
			System.out.println("4 - Mostrar compras");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				System.out.println("Digite o id do Cliente: ");
				idCliente = entrada.nextInt();
				System.out.println("Digite o id do Destino: ");
				idDestino = entrada.nextInt();
				System.out.println("Digite a quantidade: ");
				qnt = entrada.nextInt();

				Cliente cliente = clienteDAO.getClienteById(idCliente);
				Destino destino = destinoDAO.getDestinoById(idDestino);

				Compra c1 = new Compra(id, qnt, destino, cliente);
				System.out.println("Total da compra: " + c1.getTotal());
				c1.setData(new Date());
				compraDAO.save(c1);
				System.out.println("----------------------------------- ");

				break;
			}
			case 2: {
				System.out.println("Digite o ID da compra para exclusao: ");
				id = entrada.nextInt();

				compraDAO.deleteById(id);
				break;
			}
			case 3: {

				System.out.println("Digite o ID da compra para atualizar: ");
				id = entrada.nextInt();
				System.out.println("Digite a quantidade: ");
				qnt = entrada.nextInt();
				System.out.println("Digite o id do Cliente: ");
				idCliente = entrada.nextInt();
				System.out.println("Digite o id do Destino: ");
				idDestino = entrada.nextInt();

				Cliente cli = clienteDAO.getClienteById(idCliente);
				Destino de = destinoDAO.getDestinoById(idDestino);

				Compra c2 = new Compra(id, qnt, de, cli);
				System.out.println("Total da compra: " + c2.getTotal());
				c2.setData(new Date());
				compraDAO.update(c2);
				System.out.println("----------------------------------- ");

				break;
			}
			case 4:

			{
				for (Compra c : compraDAO.getCompra()) {
					System.out.println("Id: " + c.getId() + " Data da compra: " + c.getData() + " Quantidade: "
							+ c.getQuantidade() + " Total : " + c.getTotal());
				}

				System.out.println("----------------------------------- ");
			}
				break;

			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int iD = entrada.nextInt();

				Compra c = compraDAO.getCompraById(iD);

				System.out.println("ID: " + c.getId() + " Data da compra: " + c.getData() + " Quantidade: "
						+ c.getQuantidade() + " Total: " + c.getTotal());

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

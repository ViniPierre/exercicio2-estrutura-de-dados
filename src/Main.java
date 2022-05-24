import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        int opcao;
        
        do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));	
			if(opcao < 1 || opcao > 5) {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			} else {
				switch(opcao) {
					case 1:
						Processo.cadastrar();
						break;
					case 2:
						Processo.listar();
						break;
					case 3:
						Processo.vender();
						break;
				    }	
			    }			
		    } while (opcao != 4);
	    }

    public static String menu() {
		String aux = "Escolha uma opção:\n";
		aux += "1. Cadastrar produto\n";
		aux += "2. Listar rodutos\n"; 
		aux += "3. Vender produto\n"; 
		aux += "4. Finalizar\n";
		return aux;
	}

}




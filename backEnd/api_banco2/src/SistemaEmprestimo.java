public class SistemaEmprestimo {
  

  public static void main(String[] args) {
    boolean sair = false;

    while (!sair) {
      
      JOptionPane.showMessageDialog(null, "Sistema de Emprestimo \n");
        int tipoPessoa = Integer.parseInt(JOptionPane.showInputDialog(" Escolha alguma das opções \n"
            + "Opção 1 - Pessoa Fisica \n"
            + "Opção 2 - Pessoa Juridica \n"
            + "Opção 3 - Sair do sistema"));

        if (tipoPessoa == 3) {
            sair = true;
        } else if (tipoPessoa == 1) {
            String cpf = JOptionPane.showInputDialog("Digite seu CPF:");
            String nome = JOptionPane.showInputDialog("Digite seu nome:");
            double dividaAtiva = Double.parseDouble(JOptionPane.showInputDialog("Digite sua dívida atual:"));
            double valorEmprestimo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do empréstimo:"));

            PessoaFisica pessoaFisica = new PessoaFisica(nome, dividaAtiva, cpf);

            if (!validarCPF(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inválido. Empréstimo negado.");
            } else if (valorEmprestimo > 50000) {
                JOptionPane.showMessageDialog(null, "Valor do empréstimo excede o limite. Empréstimo negado.");
            } else if (valorEmprestimo > pessoaFisica.getDividaAtiva() / 2) {
                JOptionPane.showMessageDialog(null, "Valor do empréstimo excede a metade da dívida ativa. Empréstimo negado.");
            } else {
                JOptionPane.showMessageDialog(null, "Empréstimo aprovado.");
            }
        } else if (tipoPessoa == 2) {
            String cnpj = JOptionPane.showInputDialog("Digite seu CNPJ:");
            String nomeEmpresa = JOptionPane.showInputDialog("Digite o nome da empresa:");
            double dividaAtiva = Double.parseDouble(JOptionPane.showInputDialog("Digite sua dívida atual:"));
            double valorEmprestimo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do empréstimo:"));

            PessoaJuridica pessoaJuridica = new PessoaJuridica(nomeEmpresa, dividaAtiva, cnpj);

            if (!validarCNPJ(cnpj)) {
                JOptionPane.showMessageDialog(null, "CNPJ inválido. Empréstimo negado.");
            } else if (valorEmprestimo > 50000) {
                JOptionPane.showMessageDialog(null, "Valor do empréstimo excede o limite. Empréstimo negado.");
            } else if (valorEmprestimo > pessoaJuridica.getDividaAtiva() / 2) {
                JOptionPane.showMessageDialog(null, "Valor do empréstimo excede a metade da dívida ativa. Empréstimo negado.");
            } else {
                JOptionPane.showMessageDialog(null, "Empréstimo aprovado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida. Empréstimo negado.");
        }
    }
}

private static boolean validarCPF(String cpf) {
    if (cpf.length() != 11) {
        return false;
    }
   

    return true;
}

private static boolean validarCNPJ(String cnpj) {
    if (cnpj.length() != 15) {
        return false;
    }
  

    return true;
}
}

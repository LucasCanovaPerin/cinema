/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.ManutencaoCinema;

import dao.DaoCinema;
import javax.swing.JOptionPane;
import modelo.Cinema;
import tela.manutencao.ManutencaoCinema;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCinema {
public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Endereco");
        modelo.addColumn("Capacidade");
        List<Cinema> resultados = DaoCinema.consultar();
        for (Cinema objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getCapacidade());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }

    public static void inserir(ManutencaoCinema man){
        Cinema objeto = new Cinema();
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setCapacidade(Integer.parseInt(man.jtfCapacidade.getText()));
        
        boolean resultado = DaoCinema.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

   public static void alterar(ManutencaoCinema man){
        Cinema objeto = new Cinema();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setEndereco(man.jtfEndereco.getText());
       objeto.setCapacidade(Integer.parseInt(man.jtfCapacidade.getText()));
        
        boolean resultado = DaoCinema.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

   public static void excluir(ManutencaoCinema man){
        Cinema objeto = new Cinema();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoCinema.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    
}

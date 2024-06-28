package fatec.poo.control;

import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class DaoVendedor {
    private Connection conn;
    
    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }    
    
    public Vendedor consultar (String cpf) {
        Vendedor objVend = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM VENDEDOR WHERE CPF = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                objVend = new Vendedor(rs.getString("CPF"),
                                     rs.getString("NOME"),
                                     rs.getDouble("SALARIO_BASE"));
                
                objVend.setEndereco(rs.getString("ENDERECO"));
                objVend.setCidade(rs.getString("CIDADE"));
                objVend.setUf(rs.getString("UF"));
                objVend.setCep(rs.getString("CEP"));
                objVend.setDdd(rs.getString("DDD"));
                objVend.setTelefone(rs.getString("TELEFONE"));                
                objVend.setTaxaComissao(rs.getDouble("TAXA_COMISSAO"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objVend);
    }    
     
    public void inserir(Vendedor objVend) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO VENDEDOR(" +
                                       "CPF, NOME, ENDERECO, CIDADE, " +
                                       "UF, CEP, DDD, TELEFONE, " +
                                       "SALARIO_BASE, TAXA_COMISSAO)" +
                                       " VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, objVend.getCpf());
            ps.setString(2, objVend.getNome());
            ps.setString(3, objVend.getEndereco());
            ps.setString(4, objVend.getCidade());
            ps.setString(5, objVend.getUf());
            ps.setString(6, objVend.getCep());
            ps.setString(7, objVend.getDdd());
            ps.setString(8, objVend.getTelefone());
            ps.setDouble(9, objVend.getSalarioBase());
            ps.setDouble(10, objVend.getTaxaComissao());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Vendedor objVend) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE VENDEDOR SET " +
                                       "NOME = ?, " +
                                       "ENDERECO = ?, " +
                                       "CIDADE = ?, " +
                                       "UF = ?, " +
                                       "CEP = ?, " +
                                       "DDD = ?, " +
                                       "TELEFONE = ?, " +
                                       "SALARIO_BASE = ?, " +
                                       "TAXA_COMISSAO = ? " +
                                       "WHERE CPF = ?");
            
            ps.setString(1, objVend.getNome());
            ps.setString(2, objVend.getEndereco());
            ps.setString(3, objVend.getCidade());
            ps.setString(4, objVend.getUf());
            ps.setString(5, objVend.getCep());
            ps.setString(6, objVend.getDdd());
            ps.setString(7, objVend.getTelefone());
            ps.setDouble(8, objVend.getSalarioBase());
            ps.setDouble(9, objVend.getTaxaComissao());
            ps.setString(10, objVend.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Vendedor objVend) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM VENDEDOR WHERE CPF = ?");
            
            ps.setString(1, objVend.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
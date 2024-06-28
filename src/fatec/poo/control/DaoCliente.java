package fatec.poo.control;

import fatec.poo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class DaoCliente {
    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }    
    
    public Cliente consultar (String cpf) {
        Cliente objCli = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM CLIENTE WHERE CPF = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                objCli = new Cliente(rs.getString("CPF"),
                                     rs.getString("NOME"),
                                     rs.getDouble("LIMITE_CREDITO"));
                
                objCli.setEndereco(rs.getString("ENDERECO"));
                objCli.setCidade(rs.getString("CIDADE"));
                objCli.setUf(rs.getString("UF"));
                objCli.setCep(rs.getString("CEP"));
                objCli.setDdd(rs.getString("DDD"));
                objCli.setTelefone(rs.getString("TELEFONE"));                
                objCli.setLimiteDisponivel(rs.getDouble("LIMITE_DISPONIVEL"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        
        return(objCli);
    }    
     
    public void inserir(Cliente objCli) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO CLIENTE(" +
                                       "CPF, NOME, ENDERECO, CIDADE, " +
                                       "UF, CEP, DDD, TELEFONE, " +
                                       "LIMITE_CREDITO, LIMITE_DISPONIVEL)" +
                                       " VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, objCli.getCpf());
            ps.setString(2, objCli.getNome());
            ps.setString(3, objCli.getEndereco());
            ps.setString(4, objCli.getCidade());
            ps.setString(5, objCli.getUf());
            ps.setString(6, objCli.getCep());
            ps.setString(7, objCli.getDdd());
            ps.setString(8, objCli.getTelefone());
            ps.setDouble(9, objCli.getLimiteCredito());
            ps.setDouble(10, objCli.getLimiteDisponivel());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Cliente objCli) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE CLIENTE SET " +
                                       "NOME = ?, " +
                                       "ENDERECO = ?, " +
                                       "CIDADE = ?, " +
                                       "UF = ?, " +
                                       "CEP = ?, " +
                                       "DDD = ?, " +
                                       "TELEFONE = ?, " +
                                       "LIMITE_CREDITO = ?, " +
                                       "LIMITE_DISPONIVEL = ? " +
                                       "WHERE CPF = ?");
            
            ps.setString(1, objCli.getNome());
            ps.setString(2, objCli.getEndereco());
            ps.setString(3, objCli.getCidade());
            ps.setString(4, objCli.getUf());
            ps.setString(5, objCli.getCep());
            ps.setString(6, objCli.getDdd());
            ps.setString(7, objCli.getTelefone());
            ps.setDouble(8, objCli.getLimiteCredito());
            ps.setDouble(9, objCli.getLimiteDisponivel());
            ps.setString(10, objCli.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Cliente objCli) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM CLIENTE WHERE CPF = ?");
            
            ps.setString(1, objCli.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
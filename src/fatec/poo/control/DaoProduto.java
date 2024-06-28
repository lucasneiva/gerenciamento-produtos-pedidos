package fatec.poo.control;

import fatec.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */

public class DaoProduto {
    private Connection conn;
    
    public DaoProduto(Connection conn) {
         this.conn = conn;
    }    
    
    public Produto consultar (int codigo) {
        Produto objProd = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM PRODUTO WHERE CODIGO = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                objProd = new Produto(rs.getInt("CODIGO"),
                                     rs.getString("NOME"),
                                     rs.getDouble("PRECO"));
                
                objProd.setQtdeEstoque(rs.getInt("QTDE_ESTOQUE"));
              
            }
            
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        
        return(objProd);
    }    
     
    public void inserir(Produto objProd) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO PRODUTO( CODIGO, NOME, PRECO, QTDE_ESTOQUE) VALUES (?,?,?,?)");
            ps.setInt(1, objProd.getCodigo());
            ps.setString(2, objProd.getNome());
            ps.setDouble(3, objProd.getPreco());
            ps.setInt(4, objProd.getQtdeEstoque());
            
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Produto objProd) {
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement("UPDATE PRODUTO SET " +
                                       "NOME = ?, " +
                                       "PRECO = ?, " +
                                       "QTDE_ESTOQUE = ? " +
                                       "WHERE CODIGO = ?");
            
            ps.setString(1, objProd.getNome());
            ps.setDouble(2, objProd.getPreco());
            ps.setInt(3, objProd.getQtdeEstoque());
            ps.setInt(4, objProd.getCodigo());
           
            ps.execute();
            
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Produto objProd) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM PRODUTO WHERE CODIGO = ?");
            
            ps.setInt(1, objProd.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
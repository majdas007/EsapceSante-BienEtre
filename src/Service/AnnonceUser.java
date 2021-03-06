
package Service;

import Entite.Annonce;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utils.ConnexionBD;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnnonceUser {

    static ConnexionBD ds = ConnexionBD.getInstance();

    public static void inserAnnonce(Annonce An) {
        try {
            String req = "INSERT INTO annonce (`type_annonce`,"
                    + " `titre_annonce`, "
                    + "`desc_annonce`, "
                    + "`date_annonce`,"
                    + " `addr_annonce`,"
                    + " `tel_annonce`,"
                    + " `img_annonce`,"
                    + " `id_user`) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, An.getType_annonce());
            ste.setString(2, An.getTitre_annonce());
            ste.setString(3, An.getDesc_annonce());

            ste.setString(4, An.getDate_annonce());
            ste.setString(5, An.getAddr_annonce());
            ste.setInt(6, An.getTel_annonce());
            ste.setString(7, An.getImg_annonce());
            ste.setInt(8, 3);

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void updateAnnonce(Annonce An, int id) {
        try {
            String req = "UPDATE annonce SET type_annonce =?, titre_annonce=? ,desc_annonce=?,date_annonce=?,addr_annonce=?,tel_annonce=?,img_annonce=?  WHERE Id_annonce=" +id;
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ste.setString(1, An.getType_annonce());
            ste.setString(2, An.getTitre_annonce());
            ste.setString(3, An.getDesc_annonce());
            ste.setString(4, An.getDate_annonce());
            ste.setString(5, An.getAddr_annonce());
            ste.setInt(6, An.getTel_annonce());
            ste.setString(7, An.getImg_annonce());
            //ste.setInt(8, An.getId_user());

            ste.executeUpdate();
            System.out.println("bien");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void deleteAnnonce(int id) {
        try {
            String req = "DELETE FROM annonce WHERE Id_annonce =" + id;
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ste.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }

    public static List<Annonce> selectAnnonce1() {
        List<Annonce> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM annonce ";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Annonce(
                        result.getInt("id_annonce"),
                        result.getString("Type_annonce"),
                        result.getString("Titre_annonce"),
                        result.getString("Date_annonce"),
                        result.getString("Desc_annonce"),
                        result.getString("Addr_annonce"),
                        result.getInt("Tel_annonce"),
                        result.getString("Img_annonce")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Annonce.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Annonce> selectAnnonce2() {
        List<Annonce> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM annonce ";
            req += "where Type_annonce=?";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, "Offres d'emplois");

            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Annonce(
                        result.getInt("id_annonce"),
                        result.getString("Type_annonce"),
                        result.getString("Titre_annonce"),
                        result.getString("Date_annonce"),
                        result.getString("Desc_annonce"),
                        result.getString("Addr_annonce"),
                        result.getInt("Tel_annonce"),
                        result.getString("Img_annonce")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Annonce.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Annonce> selectAnnonce3() {
        List<Annonce> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM annonce ";
            req += "where Type_annonce=?";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, "Evenements");

            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Annonce(
                        result.getInt("id_annonce"),
                        result.getString("Type_annonce"),
                        result.getString("Titre_annonce"),
                        result.getString("Date_annonce"),
                        result.getString("Desc_annonce"),
                        result.getString("Addr_annonce"),
                        result.getInt("Tel_annonce"),
                        result.getString("Img_annonce")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Annonce.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Annonce> rech(String Titre) throws SQLException {
        List<Annonce> list = new ArrayList<>();
        String req = "SELECT * FROM annonce WHERE Titre_annonce like '%" +Titre+"%'";
        try (PreparedStatement ste = ds.getConnection().prepareStatement(req)) {        
        
        
        ResultSet result = ste.executeQuery();
        while (result.next()) {
            Annonce annonce = new Annonce();
            

                annonce.setType_annonce(result.getString("Type_annonce"));
                annonce.setTitre_annonce(result.getString("Titre_annonce"));
                annonce.setDate_annonce(result.getString("Date_annonce"));
                annonce.setAddr_annonce(result.getString("Addr_annonce"));
                annonce.setDesc_annonce(result.getString("Desc_annonce"));
                annonce.setTel_annonce(result.getInt("Tel_annonce"));
                annonce.setImg_annonce(result.getString("Img_annonce"));
                
                  list.add(annonce);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }



    }